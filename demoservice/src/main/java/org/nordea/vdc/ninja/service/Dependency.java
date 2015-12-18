package org.nordea.vdc.ninja.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@EnableAutoConfiguration
@Entity
@Table(name = "T_DEPENDENCY")
public class Dependency {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="dependency")
	private String dependency;
	@Column(name ="status", length=200 )
	private HttpStatus status;
	
	public Dependency() {}
	
	public Dependency(String dependency, HttpStatus status) {
		super();
		this.dependency = dependency;
		this.status = status;
	}

	public String getDependency() {
		return dependency;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	
	public void setStatus(HttpStatus status) {
		this.status=status;
	}
	
	
}
