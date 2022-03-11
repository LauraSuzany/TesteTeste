package com.laura.backenddev.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.laura.backenddev.dto.DocDtoRequest;
import com.laura.backenddev.dto.DocDtoResponse;
import com.laura.backenddev.entity.Doc;
import com.laura.backenddev.entity.User;
import com.laura.backenddev.mapper.DocRequestMapper;
import com.laura.backenddev.mapper.DocResponseMapper;
import com.laura.backenddev.repository.DocRepository;
import com.laura.backenddev.repository.UserRepository;

import javassist.NotFoundException;

@Service
public class docService {
	@Autowired
	private DocRequestMapper docRequestMapper;

	@Autowired
	private DocResponseMapper docResponseMapper;

	final private UserRepository userRepository;
	final private DocRepository docRepository;

	@Autowired
	public docService(UserRepository userRepository, DocRepository docRepository) {
		this.userRepository = userRepository;
		this.docRepository = docRepository;
	}

	public DocDtoResponse save(Long userId, DocDtoRequest docDtoRequest) throws NotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found!"));	
		Doc creat = docRepository.save(docRequestMapper.docDtoresquestToModel(docDtoRequest, user));
		return docRequestMapper.docModeltoDtoResponse(creat);
	}
	
	public void deletarDocById(Long id) throws NotFoundException {
		Optional<Doc> findId = docRepository.findById(id);
		if (!findId.isPresent()) {
			throw new NotFoundException("Document not found!");
		}
		
		docRepository.deleteById(id);

	}
	
	public List<DocDtoResponse> findAllDoc() {
		return this.docRepository.findAll().stream()
				.map(docResponseMapper::mdodelToDoc).collect(Collectors.toList());

	}

	public List<DocDtoResponse> getAll(Integer page, Integer size) {
		Page<Doc> listPage = docRepository.findAll(PageRequest.of(page, size));
		return listPage.stream().map(docResponseMapper::mdodelToDoc).collect(Collectors.toList());

	}

		public DocDtoResponse docupdate( DocDtoRequest docDtoRequest, Long user_id, Long id) throws NotFoundException {
			Optional<Doc> findUserId = docRepository.findByUserAndDocId(user_id, id);
			if (!findUserId.isPresent()) {
				throw new NotFoundException("User not found!");
			}			
			Doc docUpdate = docRepository.findById(id).get();
			BeanUtils.copyProperties(docDtoRequest, docUpdate, "id");
			Doc save = docRepository.save(docUpdate);
			return docRequestMapper.docModeltoDtoResponse(docUpdate);
		
		}
	
}