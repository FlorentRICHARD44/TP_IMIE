package fr.imie.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.imie.entities.SiteEntity;
import fr.imie.service.Services;

@RequestScoped
@Path("/sites")
public class SiteResource {
    // TODO Gérer les session timeout, en général exception NumberFormatException sur "login" au lieu de Id
    @EJB
    private Services serv;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SiteEntity> getAllSites() {
        return serv.findAllSites();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public SiteEntity getSite(@PathParam("id") Integer id) {
        return serv.findSiteById(id);
        // Manage error (id doesn't exist)
    }
    
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public SiteEntity saveSite(@PathParam("id") Integer id,
                               SiteEntity site) {
        if (id != -1) {
            site.setId(id);
        }
        return serv.save(site);
        // TODO Manage status code;
    }
    
    @DELETE
    @Path("/{id}")
    public void deleteSite(@PathParam("id") Integer id) {
        SiteEntity site = new SiteEntity();
        site.setId(id);
        serv.remove(site);
        // TODO Manage delete refused
    }
}
