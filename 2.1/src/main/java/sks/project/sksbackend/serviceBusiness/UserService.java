package sks.project.sksbackend.serviceBusiness;

import sks.project.sksbackend.dto.LoginDto;
import sks.project.sksbackend.dto.UserDto;
import sks.project.sksbackend.exception.LoginMesage;

public interface UserService {

	 String addUser(UserDto userDto);
	 LoginMesage loginUser(LoginDto loginDto);
	
}
