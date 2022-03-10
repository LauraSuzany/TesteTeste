package com.laura.backenddev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laura.backenddev.dto.UserDTO;
import com.laura.backenddev.entity.User;
import com.laura.backenddev.mapper.UserMapper;
import com.laura.backenddev.repository.UserRepository;
import com.laura.backenddev.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "Teste empresa DBA Suporte")
@CrossOrigin(originPatterns = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserMapper userMapper;

//	@GetMapping("/user")
//	@ApiOperation(value = "New findAll with dto")
//	public ResponseEntity<List<UserDTO>> findAll() {
//		return new ResponseEntity<>(userMapper.modelsToDtos(userRepository.findAll()),HttpStatus.OK);
//	}
	
	
	@PostMapping("/user")
	@ApiOperation(value = "New Save with dto")
	public ResponseEntity<User> save(@RequestBody UserDTO userDTO) {

		return new ResponseEntity<>(userService.saveUser(userDTO),HttpStatus.CREATED);
				//	userMapper.dtoToUModel(userDTO)),HttpStatus.CREATED);
	}
	
	

	/*
	@GetMapping("/user/{id}")
	@ApiOperation(value = "New findbyID with dto")
	public ResponseEntity<UserDTO> findByID(@PathVariable Long id) {
		return new ResponseEntity<>(userMapper.modelToDto(userRepository.findById(id).get()),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/user/{id}")
	@ApiOperation(value = "New delete with dto")
	public ResponseEntity<Void> delet(@PathVariable Long id) {
		UserDTO userDTO = userMapper.modelToDto(userRepository.findById(id).get());
		userRepository.deleteById(userDTO.getId());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	@PutMapping("/user")
	@ApiOperation(value = "update with a new dto")
	public ResponseEntity<User> update(@RequestBody UserDTO userDTO) {
		return new ResponseEntity<>(userRepository.save(
		*/		//	userMapper.dtoToUModel(userDTO)),HttpStatus.CREATED);
	}
	

	
	
	
	
	
	

