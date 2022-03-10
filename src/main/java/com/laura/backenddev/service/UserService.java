package com.laura.backenddev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laura.backenddev.dto.UserDTO;
import com.laura.backenddev.entity.User;
import com.laura.backenddev.mapper.UserMapper;
import com.laura.backenddev.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	
	public User saveUser (UserDTO userDTO) {
		log.info("userTDO { }", userDTO);
		return userRepository.save(userMapper.toEntity(userDTO));
		
	}
	
	
}
