package fr.imie.presentation;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import fr.imie.data.Employee;



public class IHMConsole implements AutoCloseable {

    public IHMConsole() {
        super();
    }

    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub
        
    }

    public void run() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/sirh-rest/api/employee/1");
        Invocation.Builder builder = 
        target.request();
        // Récupérer l'objet Response
        Response response = builder.get();
        // Récupérer un objet particulier
        Employee employe = builder.get(Employee.class);
        System.out.println(employe.getPrenom() + " " + employe.getNom());
    }

}
