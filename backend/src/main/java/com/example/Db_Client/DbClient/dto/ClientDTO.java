package com.example.Db_Client.DbClient.dto;

import java.io.Serializable;
import java.time.Instant;

import com.example.Db_Client.DbClient.entities.Client;

public class ClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String cpf;
	private Double income;
	private Integer children;
	private Instant birthDate;
	
	public ClientDTO() {
	}
	
	public ClientDTO(Long id, String name, String cpf, Double income, Integer children, Instant birthDate) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.children = children;
		this.birthDate = birthDate;
	}
	
	public ClientDTO(Client entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.cpf = entity.getCpf();
		this.income = entity.getIncome();
		this.children = entity.getChildren();
		this.birthDate = entity.getBirthDate();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}

	public Long getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}
	
	
}
