//package com.laura.backenddev.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.laura.backenddev.entity.User;
//import com.laura.backenddev.repository.UserRepository;
//import com.laura.backenddev.service.exceptions.ObjectNotFoundException;
//
//@Service
//public class CrudUserService {
//	@Autowired
//	private UserRepository userRepository;
//
//	public User getStudentByID(Long id) {
//		Optional<User> obj = userRepository.findById(id);
//		return obj.orElseThrow(
//				() -> new ObjectNotFoundException("Object not found " + id + ", type " + User.class.getName()));
//	}
////	public List<User> findAll() {
////		return userRepository.findAll();
////	}
//
//	public List<User> getAllStudents() {
//		// TODO Auto-generated method stub
//		return userRepository.findAll();
//
//	}
//
//	public User insert(User user) {
//		return userRepository.save(user);
//
//	}
//	public User update(User user) {
//		// TODO Auto-generated method stub
//		return userRepository.save(user);
//	
//
//	}
//	public void deletes(User user) {
//		// TODO Auto-generated method stub
//		 userRepository.delete(user);
//	
//
//	}
//
//}
