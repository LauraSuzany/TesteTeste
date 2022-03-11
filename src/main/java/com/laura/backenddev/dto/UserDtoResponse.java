package com.laura.backenddev.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@NotBlank
public class UserDtoResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	
	private String cpf;
	
}
