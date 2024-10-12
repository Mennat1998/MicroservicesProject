package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.example.demo.Dtos.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@PostMapping("/register")
	public String register (@RequestBody User user)
	{
		return userService.register(user);
	}
	@PostMapping("/getToken")
	public String getToken (@RequestBody UserDto userDto)
	{
		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userDto.getName(), 
						userDto.getPassword()));
        if (authenticate.isAuthenticated()) {
            return userService.generateToken(userDto);
        } else {
            throw new RuntimeException("invalid access");
        }
	}

	@GetMapping("/validateToken")
	public String validateToken (@RequestParam("token")String token)
	{
		userService.validateToken(token);
		return "Token is Valid"  ;
	}
}
