package com.laura.backenddev.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocDtoRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private byte document;
	
	@NotBlank
	private String tipoDocumento;
	
	}


	

