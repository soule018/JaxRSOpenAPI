package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.UserDao;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;

@Path("/user")
@Produces({"application/json", "application/xml"})
public class UserResource {

    @GET
    @Path("/")
    public List<User> getAllUser()  {
        UserDao userDao = new UserDao();
        return userDao.findAll();
    }

    @GET
    @Path("/{userId}")
    public User getUserById(@PathParam("userId") Long userId)  {
        UserDao userDao = new UserDao();
        return userDao.findOne(userId);
    }

    @POST
    @Consumes("application/json")
    public Response addUser(
            @Parameter(description = "User object that needs to be added to the store", required = true) User user) {
     UserDao userDao = new UserDao();
      User userF = userDao.createUser(user.getName());

        return Response.ok().entity("SUCCESS "+userF.getId()).build();
    }
}

