package jaxrs.service;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import jaxrs.ihm.domain.Employe;

public class EmployeClientService {
	
	private static final String BASE_URL = "http://localhost:8080/sirh-rest/api";
	
	public List<Employe> findAllEmployes() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(BASE_URL);
		Invocation.Builder builder = target.path("employee").request();	
		return builder.get(new GenericType<List<Employe>>(){});
	}
	
	public Employe findEmployeById(Integer id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(BASE_URL);
		Invocation.Builder builder = target.path("api").path("employee").path(id.toString()).request();	
		return builder.get(Employe.class);
	}

}
