package fr.imie.woa_mvc.ecommerce.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import fr.imie.woa_mvc.ecommerce.persistance.ProductEntity;
import fr.imie.woa_mvc.ecommerce.service.ServiceProducts;

/** Resource to use REST for Products.
 * @author imie
 */
@RequestScoped
@Path("/products")
public class ProductResource {
    /** Service for Products.
     */
    @EJB private ServiceProducts servProducts;
    
    /** Get the list of all the products.
     * @return Response for the request, containing Product List if no error.
     */
    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    public Response getAllProducts() {
        ResponseBuilder builder = Response.status(Status.OK);
        try {
            List<ProductEntity> productList = servProducts.findAllProducts();
            builder.entity(productList);
        } catch(EJBException e) {
            builder = Response.status(Status.BAD_REQUEST);
        }
        return builder.build();
    }
    
    /** Creates a new Product.
     * @param productToAdd New Product.
     * @return Product as represented in persistance.
     */
    @POST
    @Consumes(value=MediaType.APPLICATION_JSON)
    @Produces(value=MediaType.APPLICATION_JSON)
    public Response createProduct(ProductEntity productToAdd) {
        ResponseBuilder builder = Response.status(Status.CREATED);
        try {
            ProductEntity productCreated = servProducts.addProduct(productToAdd);
            builder.entity(productCreated);
        } catch(EJBException e) {
            builder = Response.status(Status.BAD_REQUEST);
        }
        return builder.build();
    }
    
    /** Updates a Product.
     * @param productToUpdate New Product.
     * @return Product as represented in persistence once modified.
     */
    @PUT
    @Consumes(value=MediaType.APPLICATION_JSON)
    @Produces(value=MediaType.APPLICATION_JSON)
    public Response updateProduct(ProductEntity productToUpdate) {
        ResponseBuilder builder = Response.status(Status.OK);
        try {
            ProductEntity productUpdated = servProducts.updateProduct(productToUpdate);
            builder.entity(productUpdated);
        } catch(EJBException e) {
            builder = Response.status(Status.BAD_REQUEST);
        }
        return builder.build();
    }
    
    /** Deletes a product in persistence.
     * @param productToDelete Product to be removed
     * @return Response with nothing.l
     */
    @DELETE
    @Consumes(value=MediaType.APPLICATION_JSON)
    public Response deleteProduct(ProductEntity productToDelete) {
        ResponseBuilder builder = Response.status(Status.OK);
        try {
            servProducts.removeProduct(productToDelete);
        } catch(EJBException e) {
            builder = Response.status(Status.BAD_REQUEST);
        }
        return builder.build();
    } 
}
