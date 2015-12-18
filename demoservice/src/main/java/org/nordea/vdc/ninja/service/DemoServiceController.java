package org.nordea.vdc.ninja.service;


import java.net.URI;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@EnableAutoConfiguration
public class DemoServiceController  {
	
	public final static String TOKEN_SERVICE_ENDPOINT = "tokenservice";
	
	private static final Logger log = LoggerFactory.getLogger(DemoServiceController.class);
    private DiscoveryClient discoveryClient;
    private Service service;
    
    @Autowired
    public DemoServiceController(Service service, DiscoveryClient discoveryClient) {
    	this.service=service;
    	this.discoveryClient=discoveryClient;
    }
    
    @RequestMapping("/demoservice/info")
    public Service getService(@RequestHeader(value="service-token") String token, @RequestHeader(value="Content-Type", defaultValue="application/json") String contentType) {	
    	if(isValidToken(token)) {
    		log.info("Service information " + service.toString());
    		return service;
    	}
        return null;
    } 
    
    @RequestMapping(method=RequestMethod.POST, value ="/demoservice/register")
    public String registerClient(@RequestBody Client client) { 
    	getClientToken(client); 
        log.info("Client " + client.getName() + " is registered with  " + client.getToken());
		return client.getToken();
    	
    }   
   
   private void getClientToken(Client client) {	
	RestTemplate restTemplate = new RestTemplate();
	URI tokenEndpoint = getServiceEndpointFromEureka(TOKEN_SERVICE_ENDPOINT);
	HttpStatus status = serviceHealthCheck(restTemplate, tokenEndpoint);
	addServiceDependency(tokenEndpoint, status);
	if(status.equals(HttpStatus.OK)) {
		String token = restTemplate.getForObject(tokenEndpoint + "token", String.class);
		restTemplate.postForObject(tokenEndpoint + "register", client, String.class);	
		client.setToken(token);	
		service.addClients(client);
	}
	
   } 
   
   private void addServiceDependency(URI tokenEndpoint, HttpStatus status) {
	   Dependency dep = new Dependency(tokenEndpoint.toString(), status);
	   service.addDependencies(dep);
   }
   
   private boolean isValidToken(String serviceToken) {
	   Set<Client> clients = service.getClients();
	   for(Client c :clients) {
		   if(c.getToken().equals(serviceToken)){
			   return true;
		   }
	   }
	return false;	   
   }
   
   private URI getServiceEndpointFromEureka(String endpoint) {
	   URI uri = null;
	   List<ServiceInstance> instances = discoveryClient.getInstances(endpoint);
	   if (instances != null && instances.size() > 0) {
		   ServiceInstance instance = instances.get(0);
		   uri = URI.create(String.format("http://%s:%s/" + endpoint + "/",instance.getHost(), instance.getPort()));
	   }
	   return uri;
	
	}
   
   private HttpStatus serviceHealthCheck(RestTemplate restTemplate, URI endpoint) {
	   ResponseEntity<String> response = restTemplate.postForEntity(endpoint + "info", null, String.class);
	   return response.getStatusCode();
   }

 }
    
   