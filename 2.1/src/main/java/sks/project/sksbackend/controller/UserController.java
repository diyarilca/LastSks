package sks.project.sksbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sks.project.sksbackend.dto.LoginDto;
import sks.project.sksbackend.dto.UserDto;
import sks.project.sksbackend.exception.LoginMesage;
import sks.project.sksbackend.serviceBusiness.UserService;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
	
	 	@Autowired
	    private UserService userService;
	 	
	 	
	 	
	    @PostMapping(path = "/save")
	    public String saveUser(@RequestBody UserDto userDto)
	    {
	        String id = userService.addUser(userDto);
	        return id;
	    }
	    @PostMapping(path = "/login")
	    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto)
	    {
	        LoginMesage loginMesage = userService.loginUser(loginDto);
	        return ResponseEntity.ok(loginMesage);
	    }

}
