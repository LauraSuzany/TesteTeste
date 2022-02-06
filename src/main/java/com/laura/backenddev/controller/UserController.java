package com.laura.backenddev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.laura.backenddev.entity.User;
import com.laura.backenddev.service.CrudUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(value = "Teste empresa DBA Suporte")
@CrossOrigin(originPatterns= "*")
public class UserController {
	@Autowired

	private CrudUserService crudUserService;

	@GetMapping(value = "/{id}")
	@ApiOperation(value="Retorna um produtpo id")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = crudUserService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	@ApiOperation(value="Retorna uma lista de produtos")
	public List<User> list() {
		return crudUserService.findAll();
	}

	@PostMapping
	@ApiOperation(value="Salva um produto")
	public User insert(@RequestBody @Valid User user) {
		return crudUserService.insert(user);
	}

	@PutMapping
	@ApiOperation(value="Atualiza um produtos")
	public User update(@RequestBody @Valid User user) {
		return crudUserService.update(user);
	}

	@DeleteMapping
	@ApiOperation(value="Deleta um produtos")
	public void deletes(@RequestBody User user) {
		crudUserService.deletes(user);
	}
}
