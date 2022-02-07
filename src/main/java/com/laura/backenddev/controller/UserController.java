package com.laura.backenddev.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.laura.backenddev.entity.User;
import com.laura.backenddev.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;

@RestController
@RequestMapping("/api")
@Api(value = "Teste empresa DBA Suporte")
@CrossOrigin(originPatterns = "*")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/user")
	@ApiOperation(value = "Retorna uma lista")
	public ResponseEntity<Page<User>> getAll(@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer size,
			@RequestParam(required = false, defaultValue = "0") boolean enablePagination) {

		return ResponseEntity
				.ok(userRepository.findAll(enablePagination ? PageRequest.of(page, size) : Pageable.unpaged()));
	}

	@GetMapping("/user/{id}")
	@ApiOperation(value = "Retorna dados por id")
	public User getUsertByID(@PathVariable Long id) throws NotFoundException {
		Optional<User> objUser = userRepository.findById(id);
		if (objUser.isPresent()) {
			return objUser.get();
		} else {
			throw new NotFoundException("not found fsdfsdfs id " + id);
		}
	}

	@PostMapping("/user")
	@ApiOperation(value = "Salva")
	@ExceptionHandler(BadRequest.class)
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}

	@PutMapping("/user/{id}")
	@ApiOperation(value = "Atualizar")
	public User updateUser(@PathVariable Long id, @Valid @RequestBody User userUpdated) throws NotFoundException {
		return userRepository.findById(id).map(user -> {
			user.setNome(userUpdated.getNome());
			user.setCpf(userUpdated.getCpf());
			return userRepository.save(user);
		}).orElseThrow(() -> new NotFoundException("Not found with id" + id));
	}

	@DeleteMapping("/user/{id}")
	@ApiOperation(value = "Deletar")
	public String deleteUsert(@PathVariable Long id) throws NotFoundException {
		return userRepository.findById(id).map(user -> {
			userRepository.delete(user);
			return "Delete Successfully!";
		}).orElseThrow(() -> new NotFoundException("Not found with id " + id));
	}
}
