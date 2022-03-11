package com.laura.backenddev.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	private String nome;

	private String cpf;
	/*
	public UserDTO (User user) {
		this.id = user.getId();
		this.nome = user.getNome();
		this.cpf = user.getCpf();
		
		id = user.getId();
		nome = user.getNome();
		cpf = user.getCpf();
		*/
	}

