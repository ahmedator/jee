package com.efficom.tpfinal;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
public class UserController {

    @Inject
    private UserBean userBean;

    @POST
    @Path("/register")
    public Response register(User user){
        userBean.addNewUser(user);
        return Response.ok("Success 200").build();
    }

    @POST
    @Path("/connect")
    public Response connector(@HeaderParam("Authorization") String basicAuthorization){
        userBean.connectUser(basicAuthorization);
        return Response.ok("Success 200").build();
    }


}
