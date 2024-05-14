package sks.project.sksbackend.repositoryDataAccess;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import sks.project.sksbackend.entities.User;


@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	Optional<User> findOneByEmailAndPassword(String email, String password);
    User findByEmail(String email);

}
