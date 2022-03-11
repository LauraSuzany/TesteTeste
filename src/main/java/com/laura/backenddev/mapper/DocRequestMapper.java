package com.laura.backenddev.mapper;

import org.mapstruct.Mapper;
import com.laura.backenddev.dto.DocDtoRequest;
import com.laura.backenddev.dto.DocDtoResponse;
import com.laura.backenddev.entity.Doc;
import com.laura.backenddev.entity.User;

@Mapper(componentModel = "spring")
public interface DocRequestMapper {
		
	Doc docDtoresquestToModel(DocDtoRequest docDtoRequest);//dto para entity
	default Doc docDtoresquestToModel(DocDtoRequest docDtoRequest, User user) {
		Doc doc = new Doc();
		doc.setUser(user);
		doc.setDocument(docDtoRequest.getDocument());
		doc.setTipoDocumento(docDtoRequest.getTipoDocumento());
		return doc;
	}
	DocDtoResponse docModeltoDtoResponse(Doc doc);
	
	
}
