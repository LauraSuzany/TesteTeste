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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laura.backenddev.entity.UserDocumentation;
import com.laura.backenddev.repository.UserDocumentationRepository;
import com.laura.backenddev.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;

@RestController
@RequestMapping("api")
@Api(value = "Teste empresa DBA Suporte")
@CrossOrigin(originPatterns = "*")

public class UserDocumentationController {
	@Autowired
	private UserDocumentationRepository userDocumentationRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/user/{userId}/userDoc")
	public Optional<UserDocumentation> getContactByUserId(@PathVariable Long userId) throws NotFoundException {

		if (!userRepository.existsById(userId)) {
			throw new NotFoundException("User not found!");
		}

		return userDocumentationRepository.findById(userId);

	}
	@GetMapping("/userDoc")
	public ResponseEntity<Page<UserDocumentation>> getAllUserDocu
	(
			@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer size,
			@RequestParam(required = false, defaultValue = "0") boolean enablePagination){
			return ResponseEntity.ok(userDocumentationRepository.findAll(enablePagination ? PageRequest.of(page, size) : Pageable.unpaged()));
		
	}
			


	@PostMapping("/user/{userId}/userDoc")
	public UserDocumentation createDoc(@PathVariable Long userId,
			@Valid @RequestBody UserDocumentation userDocumentation) throws NotFoundException {
		return userRepository.findById(userId).map(user -> {
			userDocumentation.setUser(user);
			return userDocumentationRepository.save(userDocumentation);
		}).orElseThrow(() -> new NotFoundException(" not found!"));

	}
	
	
	@PutMapping("/user/{userId}/userDoc/{docid}")
	@ApiOperation(value = "Atualiza")
	public UserDocumentation update(@PathVariable Long userId, @PathVariable Long docid,
			@Valid @RequestBody UserDocumentation docUserupdate) throws NotFoundException  {
		if (!userRepository.existsById(userId)) {
			throw new NotFoundException("User not found!");
		}
			return userDocumentationRepository.findById(docid)
			.map( maUppdateDoc -> {
				maUppdateDoc.setDocument(docUserupdate.getDocument());
				maUppdateDoc.setTipoDocumento(docUserupdate.getTipoDocumento());
	            return userDocumentationRepository.save(maUppdateDoc);
	        }).orElseThrow(() -> new NotFoundException("found with id"));	
	
	}
	@DeleteMapping("/user/{userId}/userDoc/{docid}")
	public String deleteDoc(@PathVariable Long userId, @PathVariable Long docid) throws NotFoundException {
		if (!userRepository.existsById(userId)) {
			throw new NotFoundException("User not found!");
		}
 	
        return userDocumentationRepository.findById(docid)
                .map(maUppdateDoc -> {
                	userDocumentationRepository.delete(maUppdateDoc);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new NotFoundException("Contact not found!"));
    }
}