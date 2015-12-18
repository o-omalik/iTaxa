package org.nordea.vdc.ninja.service;

import org.springframework.data.repository.CrudRepository;
/**
public interface ServiceRepository extends CrudRepository<Service, Long> {
	
	public Service findByName(String service);
	
	public Service save(Service service);
	
	public void delete(Service service);
}
**/