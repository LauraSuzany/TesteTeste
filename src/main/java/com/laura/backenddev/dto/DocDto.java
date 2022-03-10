package com.laura.backenddev.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private byte document;
	
	@NotBlank
	private String tipoDocumento;
	
	}


	

