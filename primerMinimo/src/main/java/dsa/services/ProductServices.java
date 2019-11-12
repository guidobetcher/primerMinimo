package dsa.services;

import dsa.main.ProductManager;
import dsa.main.ProductManagerImp;
import dsa.models.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/products", description = "Endpoint to Product Service")
@Path("/products")
public class ProductServices {

    private ProductManager pm;

    public ProductServices() {
        this.pm = ProductManagerImp.getInstance();
        if (pm.size()==0) {
            this.pm.addProduct("Caña de pescar", 14.6, 10);

            this.pm.addProduct("Mapa", 10, 2);

            this.pm.addProduct("Botas de agua", 25.5879,1);
        }


    }

    @GET
    @ApiOperation(value = "get all Products", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {

        List<Product> Products = this.pm.findAll();

        GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(Products) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "get a Product", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") String id) {
        Product t = this.pm.getProduct(id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Product", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") String id) {
        Product t = this.pm.getProduct(id);
        if (t == null) return Response.status(404).build();
        else this.pm.deleteProduct(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a Product", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @Path("/")
    public Response updateProduct(Product product) {

        Product t = this.pm.updateProduct(Product);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Product", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Product.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })


    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newProduct(Product product) {

        if (product.getSinger()==null || product.getTitle()==null)  return Response.status(500).entity(product).build();
        this.pm.addProduct(product);
        return Response.status(201).entity(product).build();
    }

}