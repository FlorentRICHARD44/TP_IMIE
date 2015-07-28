package fr.imie.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

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
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeEntity post(@PathParam("id") Integer id) {
        return serv.findEmployeeById(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(EmployeeEntity employee) {
        ResponseBuilder builder = Response.status(Status.CREATED);
        if (!employee.getNom().equals("") && !employee.getPrenom().equals("")) {
            employee = serv.save(employee);
            employee.setMatricule(String.format("MAT%d", employee.getId()));
            employee = serv.save(employee);
            builder.entity(employee);
        } else {
            builder = Response.status(Status.BAD_REQUEST);
        }
        return builder.build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(EmployeeEntity employee) {
        ResponseBuilder builder = Response.status(Status.CREATED);
        if ((serv.findEmployeeById(employee.getId()) != null)
         && !employee.getNom().equals("")
         && !employee.getPrenom().equals("")) {
            employee = serv.save(employee);
            builder.entity(employee);
        } else {
            builder = Response.status(Status.BAD_REQUEST);
        }
        return builder.build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) {
        EmployeeEntity employee = serv.findEmployeeById(id);
        ResponseBuilder builder = null;
        if (employee == null) {
            builder = Response.status(Status.BAD_REQUEST);
        } else {
            serv.remove(employee);
            builder = Response.status(Status.OK);
        }
        return builder.build();
    }
    
}
