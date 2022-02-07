//package com.laura.backenddev.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.laura.backenddev.entity.User;
//import com.laura.backenddev.entity.UserDocumentation;
//import com.laura.backenddev.repository.UserDocumentationRepository;
//import com.laura.backenddev.service.exceptions.ObjectNotFoundException;
//
//@Service
//public class CrudUserDocumentationService {
//	@Autowired
//	private UserDocumentationRepository userDocumentationRepository;
//
//	public List<UserDocumentation> encontrar() {
//		// TODO Auto-generated method stub
//		return userDocumentationRepository.findAll();
//
//	}
//	public UserDocumentation findById(Long id) {
//		Optional<UserDocumentation> obj = userDocumentationRepository.findById(id);
//		return obj.orElseThrow(
//				() -> new ObjectNotFoundException("Object not found " + id + ", type " + User.class.getName()));
//	}
//	public UserDocumentation create(UserDocumentation userDocumentation) {
//		// TODO Auto-generated method stub
//		return userDocumentationRepository.save(null);
//	}
//	
//	
////	public UserDocumentation update(UserDocumentation userDocumentation) {
////		// TODO Auto-generated method stub
////		return userDocumentationRepository.save(userDocumentation);
////	
////
////	}
//}
