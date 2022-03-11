package com.laura.backenddev.mapper;

import org.mapstruct.Mapper;
import com.laura.backenddev.dto.UserDtoResponse;
import com.laura.backenddev.entity.User;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

	UserDtoResponse mdodelToUser (User user);
	
	
}
