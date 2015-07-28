/**
 * 
 */
package fr.imie.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import fr.imie.entities.EmployeeEntity;
import fr.imie.entities.ProjectEntity;
import fr.imie.services.Services;

/**
 * @author imie
 *
 */
@RequestScoped
@Path("/project")
public class ProjectResource {
    @EJB
    private Services serv;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("employee") @DefaultValue("-1") Integer employee_id) {
        ResponseBuilder builder = Response.status(Status.OK);
        List<ProjectEntity> projectList = null;
        if (employee_id == -1) {
            projectList = serv.findAllProjects();
            builder.entity(projectList);
        } else {
            EmployeeEntity employee = serv.findEmployeeById(employee_id);
            if (employee == null) {
                builder = Response.status(Status.BAD_REQUEST);
            } else {
                projectList = employee.getProjects();
                builder.entity(projectList);
            }
        }
        return builder.build();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(@PathParam("id") Integer id) {
        ResponseBuilder builder = Response.status(Status.OK);
        ProjectEntity project = serv.findProjectById(id);
        if (project == null) {
            builder = Response.status(Status.BAD_REQUEST);
        } else {
            builder.entity(project);
        }
        return builder.build();
    }
}
