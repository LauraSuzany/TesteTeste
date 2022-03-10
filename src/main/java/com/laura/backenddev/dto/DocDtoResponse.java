package com.laura.backenddev.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocDtoResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private UserDTO user;
	
	private byte document;

	private String tipoDocumento;
	

	
	}
	

