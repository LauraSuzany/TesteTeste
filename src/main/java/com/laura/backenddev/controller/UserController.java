package com.laura.backenddev.controller;

import java.util.List;
import javax.validation.Valid;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.laura.backenddev.dto.UserDtoRequest;
import com.laura.backenddev.dto.UserDtoResponse;
import com.laura.backenddev.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;

@RestController
@RequestMapping("/api")
@Api(value = "Teste empresa DBA Suporte")
@CrossOrigin(originPatterns = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/page")
	@ApiOperation(value = "Retorna uma lista de usuário com paginação")
	public ResponseEntity<List<UserDtoResponse>> getAllPage(@RequestParam Integer page, @RequestParam Integer size) {
		return ResponseEntity.ok(userService.getAll(page, size));
	}
	
	@PostMapping("/user")
	@ApiOperation(value = "Post MapperStruct")
	public ResponseEntity<UserDtoResponse> creatUser(@RequestBody @Valid UserDtoRequest userDtoRequest) {
		return new ResponseEntity<>(userService.save(userDtoRequest), HttpStatus.CREATED);
	}
	
	@PutMapping("/user/{user_id}")
	@ApiOperation(value = "update with a new dto")
	public ResponseEntity<UserDtoResponse> update(@PathVariable Long user_id, @RequestBody UserDtoRequest userDtoRequest) throws NotFoundException {
		return new ResponseEntity<>(userService.update(userDtoRequest, user_id), HttpStatus.OK);
	}
	
	
	@DeleteMapping("user/{user_id}")
	@ApiOperation(value = "Delete by ID")
	public ResponseEntity<Void> delete(@PathVariable Long user_id) throws NotFoundException {
		userService.deletarUserById(user_id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}