package com.efficom.tpfinal;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

import static java.util.Objects.nonNull;

@Path("boxer")
public class BoxerController {

    @Inject
    private BoxerBean boxerBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/boxers")
    public Response getBoxers() {
        return Response.ok(boxerBean.getBoxers()).build();
    }

    @POST
    @Path("/addNewBoxer")
    public Response addNewBoxer(Boxer boxer) {
        boxerBean.addNewBoxer(boxer);
        return Response.ok("Success 200").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/boxer")
    public Response getBoxer(String firstName) {
        return Response.ok(boxerBean.getBoxerByFirstName(firstName)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBoxer(@PathParam("id") long id) {
        if(boxerBean.deleteBoxer(id)) {
            return Response.ok(boxerBean.getBoxers().size()).build();
        }
        return Response.ok("no exist element !").build();
    }


}
