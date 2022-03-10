package com.laura.backenddev.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.laura.backenddev.dto.DocDto;
import com.laura.backenddev.entity.Doc;

@Mapper(componentModel = "spring")
public interface DocMapper {
		

	DocDto toDTO(Doc Doc);
	Doc toEntity(DocDto docDto);//dto para entity
}
