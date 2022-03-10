package com.laura.backenddev.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.laura.backenddev.dto.DocDto;
import com.laura.backenddev.dto.DocDtoResponse;
import com.laura.backenddev.dto.UserDTO;
import com.laura.backenddev.entity.Doc;
import com.laura.backenddev.entity.User;
import com.laura.backenddev.mapper.DocMapper;
import com.laura.backenddev.mapper.DocResponseMapper;
import com.laura.backenddev.repository.DocRepository;
import com.laura.backenddev.repository.UserRepository;

import javassist.NotFoundException;

@Service
public class docService {
	@Autowired
	private DocMapper docMapper;
	
	@Autowired
	private DocResponseMapper docResponseMapper;

	final private UserRepository userRepository;
	final private DocRepository docRepository;

	@Autowired
	public docService(UserRepository userRepository, DocRepository docRepository) {
		this.userRepository = userRepository;
		this.docRepository = docRepository;
	}

	public Doc saveDoc(Long userId, DocDto docDto) throws NotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
		Doc doc = docMapper.toEntity(docDto);
		doc.setUser(user);
		return docRepository.save(doc);
	}

	public List<DocDtoResponse> findAllDoc() {
		return this.docRepository.findAll()
				.stream()
				.map(docList -> docResponseMapper.mdodelToDoc(docList))
				.collect(Collectors.toList());
	}
	
	
	
	
	public List<DocDtoResponse> getAll(Integer page, Integer size) {
		
		Page<Doc> listPage = docRepository.findAll(PageRequest.of(page, size));		
			return listPage.stream()
				.map(docList -> docResponseMapper.mdodelToDoc(docList))
				.collect(Collectors.toList());
			
	}
	
	//optional sempre is present
	//list empaty
	public Doc docupdate(Long userId, Long docid) throws NotFoundException {
		Optional<Doc> findUserId = docRepository.findByUserAndDocId(userId, docid);
		if(!findUserId.isPresent()) {
			throw new NotFoundException("User not found!");
		}
		
		return null;
		}
		
//	
//	if
//	 (!userRepository.existsById(userId)) { throw new
//	 NotFoundException("User not found!"); } return
//			 
//	 docRepository.findById(docid).map(maUppdateDoc -> {
//	 maUppdateDoc.setDocument(docUserupdate.getDocument());
//	 maUppdateDoc.setTipoDocumento(docUserupdate.getTipoDocumento()); return
//	 docRepository.save(maUppdateDoc); }).orElseThrow(() -> new
//	 NotFoundException("found with id"));	
//
//	  }
//	
//	public List<DocDtoResponse> getAllPage(
//			){
//		
//				return this.docRepository.findAll()
//				.stream()
//				.map(docList -> docResponseMapper.mdodelToDoc(docList))
//				.collect(Collectors.toList());
//	}
	
	
	
	
	//stream percorrer cada indice 
	//map para cada objeto refereciodo pelo indece
	//Map – mapeia chaves para valores. Cada elemento tem na verdade dois objetos: uma chave e um valor.
//	public Doc findAll() {
//		return (Doc) docRepository.findAll();
//	}
}

	
	


//	public void decodeBase64() {//
//
//		String strDecode = "";
//
//		if (Objects.isNull(strDecode)) {
//
//			System.out.println("Informando valor: " + null);
//
//		} else if (strDecode.isEmpty()) {
//
//			JOptionPane.showMessageDialog(null, "Valor null");
//
//		} else {
//			byte[] decode = Base64.getDecoder().decode(strDecode);
//
//			System.out.println(new String(decode));
//
//		}
//	}
//
//		private void encodeParaBase64(String str) {	    	
//		System.out.println(String.format("'encodeParaBase64' %s", str));
//		
//		byte[] b = Base64.getEncoder().encode(str.getBytes());
//		System.out.println(String.format("'encodeParaBase64' %s ", new String(b)));
//
//			    }
//	public byte[] geraArrayDeBytes(document document)
//	{
//	DocMapper doc = new Doc();
//	org.apache.xml.security.utils.XMLUtils.outputDOM(document, ArrayDeBytes , true);
//	return ArrayDeBytes.toByteArray();
//	}
//	

