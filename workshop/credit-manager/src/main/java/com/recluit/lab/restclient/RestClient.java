package com.recluit.lab.restclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClient {

	public String getMessage(){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/RESTServer/rest/hello");
		ClientResponse response = webResource.accept("text/plain").get(ClientResponse.class);
		
		if(response.getStatus() != 200){
			throw new RuntimeException("Failed: "+ response.getStatus());
		}
		
		return response.getEntity(String.class);
	}
	
	public String addLoan(String title){
		Client client = Client.create();
		String url = "http://localhost:8080/RESTServer/rest/book/"+title.replace(" ", "%20");
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("text/plain").get(ClientResponse.class);
		
		if(response.getStatus() == 200){
			return response.getEntity(String.class);
		}
		else{
			return null;
		}
		
		
	}
	
}
