package com.laura.backenddev.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.laura.backenddev.dto.DocDtoRequest;
import com.laura.backenddev.dto.DocDtoResponse;
import com.laura.backenddev.dto.UserDtoRequest;
import com.laura.backenddev.dto.UserDtoResponse;
import com.laura.backenddev.entity.Doc;
import com.laura.backenddev.entity.User;
import com.laura.backenddev.mapper.UserRequestMapper;
import com.laura.backenddev.repository.UserRepository;

import javassist.NotFoundException;
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRequestMapper userRequestMapper;
	
	public List<UserDtoResponse> getAll(Integer page, Integer size) {
		Page<User> listPage = userRepository.findAll(PageRequest.of(page, size));
		return listPage.stream().map(userRequestMapper::userModeltoDtoResponse).collect(Collectors.toList());
	}


	public UserDtoResponse save(UserDtoRequest userDtoRequest) {
		User userCreated = userRepository.save(userRequestMapper.userDtoRequestToModel(userDtoRequest));
		return userRequestMapper.userModeltoDtoResponse(userCreated);
	}
	

	public UserDtoResponse update(UserDtoRequest userDtoRequest, Long user_id) throws NotFoundException {
		Optional<User> findUserId = userRepository.findById(user_id);
		if (!findUserId.isPresent()) {
			throw new NotFoundException("User not found!");
		}
	    User userUpdate = (userRepository.findById(user_id).get());
		BeanUtils.copyProperties(userDtoRequest, userUpdate, "id");
		User userSave = userRepository.save(userUpdate);
		return userRequestMapper.userModeltoDtoResponse(userUpdate);
	}



	public void deletarUserById(Long user_id) throws NotFoundException {
		Optional<User> findId = userRepository.findById(user_id);
		if (!findId.isPresent()) {
			throw new NotFoundException("Document not found!");
		}
		userRepository.deleteById(user_id);
	}
	

}

