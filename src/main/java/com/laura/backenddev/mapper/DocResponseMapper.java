package com.laura.backenddev.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.laura.backenddev.dto.DocDto;
import com.laura.backenddev.dto.DocDtoResponse;
import com.laura.backenddev.dto.UserDTO;
import com.laura.backenddev.entity.Doc;
import com.laura.backenddev.entity.User;

@Mapper(componentModel = "spring")
public interface DocResponseMapper {
		
	DocDtoResponse mdodelToDoc (Doc doc);
	//List<DocDto> dtoDocToDtoList(List<Doc> docList);
	
	//posso definir um paper para todos
	
	 //List<EnderecoResponse> deRequest(final List<EnderecoRequest> enderecoRequests);
	
	//entidade que eu quero passar para p padão tdo
	
	
}
