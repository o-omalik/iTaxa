package org.nordea.vdc.ninja.service;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

@Component
@EnableAutoConfiguration
@Entity
@Table(name = "T_CLIENT")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="name", length=500)
	private String name;
	@Column(name="token", length=500)
	private String token;
	
	public Client() {}

	public Client(String name) {
		super();
		this.name=name;
	}

	public Client(String name, String token) {
		super();
		this.name = name;
		this.token = token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String key) {
		this.token = key;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", token=" + token + "]";
	}

}
