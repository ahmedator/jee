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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/boxer")
    public Response getBoxer(String firstName) {
        return Response.ok(boxerBean.getBoxerByFirstName(firstName)).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addNewBoxer")
    public Response addNewBoxer(String lastName, String firstName) {
        if (nonNull(lastName) && nonNull(firstName)) {

            boxerBean.addNewBoxer(Boxer.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .build());

            return Response.ok(200).build();
        } else {
            return Response.status(403).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBoxer(@PathParam("id") UUID id) {
        boxerBean.deleteBoxer(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }


}
