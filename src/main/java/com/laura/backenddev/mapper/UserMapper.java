package com.laura.backenddev.mapper;

import java.util.List;

import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;

import com.laura.backenddev.dto.UserDTO;
import com.laura.backenddev.entity.User;
@Mapper(componentModel = "spring")//
public interface UserMapper {
	
	//UserMapper INSTANCE= Mappers.getMapper(UserMapper.class); O factory cria obj dinamicos sem conhecer a classe de implentacao
	//porém o sonar fica pertubando usar o @Mapper(componentModel = "spring") para corrigir este
	/*caso os atributos do meu model tivesse o mesmo valor dos atributos do meu dto porém com nomes diferentes {
	@Mapping(source = "clienteOrigem.cep", target = "zipCode")
}
*/
	List <UserDTO> modelsToDtos(List<User> user);
	UserDTO modelToDto(User user);
	User dtoToUModel(UserDTO userDTO);
}
