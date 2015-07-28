package fr.imie.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.imie.entities.EmployeeEntity;
import fr.imie.services.Services;

@RequestScoped
@Path("/employee")
public class EmployeeResource {
    @EJB
    private Services serv;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmployeeEntity> getAll() {
        return serv.findAllEmployees();
    }
    
    @GET
    @Path("/{id}")  // par exemple /clients/12
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeEntity post(@PathParam("id") Integer id) {
        return serv.findEmployeeById(id);
    }
}
