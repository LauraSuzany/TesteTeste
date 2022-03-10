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
import com.laura.backenddev.dto.DocDto;
import com.laura.backenddev.dto.DocDtoResponse;
import com.laura.backenddev.entity.Doc;
import com.laura.backenddev.mapper.DocResponseMapper;
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

	@Autowired
	private DocResponseMapper docResponseMapper;

	@PostMapping("doc/user/{userId}")
	@ApiOperation(value = "New teste")
	public ResponseEntity<DocDtoResponse> createDoc(@PathVariable Long userId, @Valid @RequestBody DocDto docDto)
			throws NotFoundException {
		Doc doc = docService.saveDoc(userId, docDto);
		return new ResponseEntity<>(docResponseMapper.mdodelToDoc(doc), HttpStatus.OK);
	}

	@GetMapping("/doc")
	@ApiOperation(value = "Retorna todos os documentos")
	public ResponseEntity<List<DocDtoResponse>> findAllDoc() {
		return new ResponseEntity<>(docService.findAllDoc(), HttpStatus.OK);
	}

	@GetMapping("/doc/page")
	@ApiOperation(value = "Retorna uma lista com paginação")
	public ResponseEntity<Iterable<DocDtoResponse>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
		return ResponseEntity.ok(docService.getAll(page, size));
	}

	@PutMapping("/doc/{user_id}/doc/{id}")
	@ApiOperation(value = "Atualizar por ID")
	public ResponseEntity<Doc> Docupdate(@PathVariable Long user_id, @PathVariable Long id,
			@Valid @RequestBody DocDto docDto) throws NotFoundException {
		return new ResponseEntity<>(docService.docupdate(user_id, id, docDto), HttpStatus.OK);
	}

	@DeleteMapping("doc/{id}")
	@ApiOperation(value = "Delete by ID")
	public void deleteDoc(@PathVariable Long id) throws NotFoundException {
		docService.deletarDocById(id);
	}

}
