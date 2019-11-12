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

@Api(value = "/products", description = "Endpoint to Track Service")
@Path("/products")
public class ProductServices {

    private ProductManager pm;

    public ProductServices() {
        this.pm = ProductManagerImp.getInstance();
        if (pm.size()==0) {
            this.pm.addTrack("La Barbacoa", "Georgie Dann");
            this.pm.addTrack("Despacito", "Luis Fonsi");
            this.pm.addTrack("Enter Sandman", "Metallica");
        }


    }

    @GET
    @ApiOperation(value = "get all Products", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTracks() {

        List<Product> tracks = this.pm.findAll();

        GenericEntity<List<Track>> entity = new GenericEntity<List<Track>>(tracks) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "get a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Track.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrack(@PathParam("id") String id) {
        Track t = this.pm.getTrack(id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response deleteTrack(@PathParam("id") String id) {
        Product t = this.pm.getTrack(id);
        if (t == null) return Response.status(404).build();
        else this.pm.deleteTrack(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateTrack(Product product) {

        Product t = this.pm.updateTrack(track);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Product.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })


    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newProduct(Product product) {

        if (product.getSinger()==null || product.getTitle()==null)  return Response.status(500).entity(product).build();
        this.pm.addTrack(product);
        return Response.status(201).entity(product).build();
    }

}