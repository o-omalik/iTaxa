package org.nordea.vdc.ninja.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

@Component
@EnableAutoConfiguration
@Entity
@Table(name = "T_SERVICE")
public class Service {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	@Column(name = "name", length = 500)
	@Value("${spring.application.name}")
	private String name;
	@Column(name = "host", length = 500)
	private String host;
	@Column(name = "port", length = 500)
	@Value("${server.port}")
	private String port;
	@Column(name = "version", length = 500)
	@Value("${app.version}")
	private String version;

	@Autowired
	@OneToMany
	@JoinColumn (name="DEP_ID", referencedColumnName="ID")
	private Set<Dependency> dependencies;
	
	@OneToMany
	@JoinColumn (name="SERVICE_ID", referencedColumnName="ID")
	private Set<Client> clients;

	public Service() {
	}

	public Service(String name, String version, String host, String port,
			Set<Client> clients, Set<Dependency> dependencies) {
		this.name = name;
		this.version = version;
		this.host = host;
		this.port = port;
		this.clients = clients;
		this.dependencies=dependencies;
	}

	public String getName() {
		return name;
	}

	public String getHost() {
		try {
			if ("".equals(host) || null == host) {
				host = InetAddress.getLocalHost().getHostName();
			}
		} catch (UnknownHostException e) {
			throw new ServiceException(e);
		}

		return host;
	}

	public String getPort() {
		return port;
	}

	public String getVersion() {
		return version;
	}
	
	public Set<Dependency> getDependencies() {
		if(dependencies==null) {
			dependencies = new HashSet<Dependency>();
		}
		return dependencies;
	}
	
	
	public void setDependencies(Dependency dependency) {
		dependencies.add(dependency);
	}

	public Set<Client> getClients() {
		if (null == clients) {
			clients = new HashSet<Client>();
		}
		return clients;
	}


	public void addClients(Client client) {
		getClients().add(client);
	}
	
	public void addDependencies(Dependency dependency) {
		getDependencies().add(dependency);

		
	}

	@Override
	public String toString() {
		return "Service [name=" + name + ", host=" + host + ", port=" + port
				+ ", version=" + version + ", clients=" + clients + "]";
	}

}
