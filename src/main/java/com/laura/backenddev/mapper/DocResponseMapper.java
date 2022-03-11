package com.laura.backenddev.mapper;

import org.mapstruct.Mapper;
import com.laura.backenddev.dto.DocDtoResponse;
import com.laura.backenddev.entity.Doc;

@Mapper(componentModel = "spring")
public interface DocResponseMapper {

	DocDtoResponse mdodelToDoc (Doc doc);
	
	
}
