package com.efficom.tpfinal;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.UUID;

import static java.util.Objects.nonNull;

@Path("Fights")
public class FightController {

    @Inject
    private FightBean fightBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFights() {
        return Response.ok(fightBean.getAllFight()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addNewFight")
    public Response addNewFight(Fight fight) {
        fightBean.addNewFight(fight);
        return Response.ok(200).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBoxer(@PathParam("id") UUID id) {
        fightBean.deleteFight(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
