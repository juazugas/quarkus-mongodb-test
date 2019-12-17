package org.acme.mongodb.panache;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/fruits")
public class FruitResource {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> getFruits() {
        return Fruit.findAll().list();
    }

    @GET
    @Path("edible")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> getAllEdible() {
        return Fruit.findRipe();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Fruit saveFruit(Fruit fruit) {
        fruit.persist();
        return fruit;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Fruit updateFruit(Fruit fruit) {
        fruit.update();
        return fruit;
    }

}