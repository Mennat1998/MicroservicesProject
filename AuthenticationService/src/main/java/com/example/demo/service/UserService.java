package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Dtos.UserDto;
import com.example.demo.config.JwtService;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder ;
	
	@Autowired
	private JwtService jwtService ;
	
	public String register(User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return " User Added ";
	}
	
	public String generateToken(UserDto userDto)
	{

		return jwtService.generateToken(userDto.getName());
		
	}
	
	
	public void validateToken(String token)
	{
		jwtService.validateToken(token);
		
	}
	
	
	
}
