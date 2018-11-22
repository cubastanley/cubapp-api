/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fish.payara.cubappmessenger.resource;

import fish.payara.cubappmessenger.base.User;
import fish.payara.cubappmessenger.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import org.glassfish.jersey.server.mvc.Viewable;

/**
 *
 * @author cubsy
 */

@Path("users")
public class UserResource {
    
    UserService uService = new UserService();
    
    /*@GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("userId") String id) {
        User u = uService.getUserById(id);
        return Response.status(200).entity(u).build();
    }*/
    
    @GET
    @Path("/{userId}")
    public Viewable getUserById(@PathParam("userId") String id) {
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("username", uService.getUserById(id).getUsername());
        userInfo.put("firstname", uService.getUserById(id).getFirstName());
        userInfo.put("lastname", uService.getUserById(id).getLastName());
        return new Viewable("/test", userInfo);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        List<User> u = uService.getAllUsers();
        return Response.status(200).entity(u).build();
    }
    
    /*@POST
    @Path("/newuser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewUser(@QueryParam("username") String username, 
            @QueryParam("firstName") String fname, 
            @QueryParam("lastName") String sname) {
        
        User u = new User(username, fname, sname);
        return Response.status(Status.CREATED).entity(uService.addUser(u)).build();
        
    }*/
    
    @POST
    @Path("/newuser")
    public Response addNewUser(@FormParam("username") String username, 
            @FormParam("firstname") String fname, 
            @FormParam("lastname") String sname,
            @Context UriInfo uriInfo) {
        
        UriBuilder builder = uriInfo.getBaseUriBuilder();
        builder.path("/users/"+username);
        
        User u = new User(username, fname, sname);
        uService.addUser(u);
        return Response.seeOther(builder.build()).build();
        
    }
    
}
