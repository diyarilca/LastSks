package sks.project.sksbackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService users() {
		UserDetails user1 = User.builder()
				.username("user")
				.password(bCryptPasswordEncoder().encode("123456"))
				.roles("USER")
				.build();
		
		UserDetails admin = User.builder()
				.username("admin")
				.password(bCryptPasswordEncoder().encode("123"))
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user1,admin);
		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception{
		
		security
				.headers(x -> x.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
				.csrf(AbstractHttpConfigurer::disable)
				.formLogin(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(x -> x.requestMatchers("/user/**","/product/**","/company/**","/ship/**", "/api/employees/**","/vehicle/**").permitAll())
				//public ve api/employees tarafından gelen isteklere authorize güvenlik işlemi uygulanmicak
				//onun dışından gelen isteklere kimlik sorgulaması yapılıcak
				.authorizeHttpRequests(x -> x.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults());
		
		
		return security.build();
	}
	
	

}
