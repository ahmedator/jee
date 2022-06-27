package com.efficom.tpfinal;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

import static java.util.Objects.nonNull;

public class BoxerController {

    BoxerDao boxerDao = new BoxerDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/boxers")
    public Response getCrewMember() {
        return Response.ok(boxerDao.getAllBoxers()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/addNewBoxer")
    public Response addNewBoxer(String lastName, String firstName) {
        if (nonNull(lastName) && nonNull(firstName)) {

            boxerDao.addBoxer(Boxer.builder()
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
        boxerDao.deleteBoxer(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }


}
