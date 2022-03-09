package com.laura.backenddev.dto;

import java.io.Serializable;

import com.laura.backenddev.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private byte document;
	
	private String tipoDocumento;
	
	private User user;
	}


	

