package sks.project.sksbackend.serviceBusiness.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sks.project.sksbackend.dto.LoginDto;
import sks.project.sksbackend.dto.UserDto;
import sks.project.sksbackend.entities.User;
import sks.project.sksbackend.exception.LoginMesage;
import sks.project.sksbackend.repositoryDataAccess.UserRepository;
import sks.project.sksbackend.serviceBusiness.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	
	@Override
	public String addUser(UserDto userDto) {
		   User user= new User(
	               userDto.getUserId(),
				   userDto.getUserName(),
				   userDto.getEmail(),
	               this.passwordEncoder.encode(userDto.getPassword())
	        );
	        userRepository.save(user);
	        return user.getUserName();
	}
	
	@Override
	public LoginMesage loginUser(LoginDto loginDto) {
		
        String msg = "";
        User user = userRepository.findByEmail(loginDto.getEmail());
        if (user != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> employee = userRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginMesage("Başarılı Giriş", true);
                } else {
                    return new LoginMesage("Başarısız Giriş", false);
                }
            } else {
                return new LoginMesage("Şifre eşleşmiyor", false);
            }
        }else {
            return new LoginMesage("Email Girilmemiş", false);
        }
	
	

	}
}
