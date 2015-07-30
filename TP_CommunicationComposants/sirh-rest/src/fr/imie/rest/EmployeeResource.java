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
import javax.xml.ws.WebServiceRef;

import fr.imie.bankocash.soap.BankocashSoapService;
import fr.imie.bankocash.soap.BankocashSoapServiceService;
import fr.imie.bankocash.soap.CompteEntity;
import fr.imie.entities.EmployeeEntity;
import fr.imie.entities.ProjectEntity;
import fr.imie.services.Services;

@RequestScoped
@Path("/employee")
public class EmployeeResource {
    @EJB
    private Services serv;
    @WebServiceRef(value=BankocashSoapServiceService.class)
    private BankocashSoapService bankoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        ResponseBuilder builder = Response.status(Status.OK);
        List<EmployeeEntity> employeeList = serv.findAllEmployees();
        builder.entity(employeeList);
        return builder.build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployee(@PathParam("id") Integer id) {
        ResponseBuilder builder = Response.status(Status.OK);
        EmployeeEntity employee = serv.findEmployeeById(id);
        if (employee == null) {
            builder = Response.status(Status.BAD_REQUEST);
        } else {
            builder.entity(employee);
        }
        return builder.build();
    }
    
    @GET
    @Path("/{id}/comptes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeComptes(@PathParam("id") Integer id) {
        ResponseBuilder builder = Response.status(Status.OK);
        List<CompteEntity> compteList = bankoService.findCompteByEmployee(id);
        if (compteList == null) {
            builder = Response.status(Status.BAD_REQUEST);
        } else {
            builder.entity(compteList);
        }
        return builder.build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(EmployeeEntity employee) {
        ResponseBuilder builder = Response.status(Status.CREATED);
        if (!employee.getNom().equals("") && !employee.getPrenom().equals("")) {
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
