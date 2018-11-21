/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fish.payara.cubappmessenger.resource;

import fish.payara.cubappmessenger.base.User;
import fish.payara.cubappmessenger.service.UserService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author cubsy
 */

@Path("users")
public class UserResource {
    
    UserService uService = new UserService();
    
    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("userId") String id) {
        User u = uService.getUserById(id);
        return Response.status(200).entity(u).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        List<User> u = uService.getUsers();
        return Response.status(200).entity(u).build();
    }
    
    @POST
    @Path("/newuser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewUser(@QueryParam("username") String username, 
            @QueryParam("firstName") String fname, 
            @QueryParam("lastName") String sname) {
        
        User u = new User();
        return Response.status(Status.CREATED).entity(u).build();
        
    }
    
}
