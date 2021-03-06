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
import com.laura.backenddev.dto.DocDtoRequest;
import com.laura.backenddev.dto.DocDtoResponse;
import com.laura.backenddev.service.docService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;

@RestController
@RequestMapping("api")
@Api(value = "Teste empresa DBA Suporte")

@CrossOrigin(originPatterns = "*")

public class DocController {

	@Autowired
	private docService docService;

	@PostMapping("doc/user/{userId}")
	@ApiOperation(value = "New teste")
	public ResponseEntity<DocDtoResponse> createDoc(@PathVariable Long userId
			, @Valid @RequestBody DocDtoRequest docDtoRequest)throws NotFoundException {
		return new ResponseEntity<>(docService.save(userId,docDtoRequest), HttpStatus.OK);
	}

	@GetMapping("/doc")
	@ApiOperation(value = "Retorna todos os documentos")
	public ResponseEntity<List<DocDtoResponse>> findAllDoc() {
		return new ResponseEntity<>(docService.findAllDoc(), HttpStatus.OK);
	}

	@GetMapping("/doc/page")
	@ApiOperation(value = "Retorna uma lista com paginação")
	public ResponseEntity<Iterable<DocDtoResponse>> getAllPage(@RequestParam Integer page, @RequestParam Integer size) {
		return ResponseEntity.ok(docService.getAll(page, size));
	}

	@PutMapping("/doc/{user_id}/doc/{id}")
	@ApiOperation(value = "Atualizar por ID")
	public ResponseEntity<DocDtoResponse> docupdate(@PathVariable Long user_id, @PathVariable Long id
			,@Valid @RequestBody DocDtoRequest docDtoRequest) throws NotFoundException {
		return new ResponseEntity<>(docService.docupdate(docDtoRequest, user_id, id), HttpStatus.OK);
	}
		
	@DeleteMapping("doc/{id}")
	@ApiOperation(value = "Delete by ID")
	public ResponseEntity<Void> delete(@PathVariable Long id) throws NotFoundException {
		docService.deletarDocById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
