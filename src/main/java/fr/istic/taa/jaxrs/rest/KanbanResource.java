package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.KanbanDao;
import fr.istic.taa.jaxrs.domain.Kanban;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;

@Path("/kanban")
@Produces({"application/json", "application/xml"})
public class KanbanResource {

    @GET
    @Path("/")
    public List<Kanban> getAllKanbans(){
        KanbanDao kbdao = new KanbanDao();
        return kbdao.findAll();
    }
    @GET
    @Path("/{kanbanId}")
    public Kanban getKanbanById(@PathParam("kanbanId") Long kanbanId)  {
        KanbanDao kanbanDao = new KanbanDao();
        return kanbanDao.findOne(kanbanId) ;
    }

    @POST
    @Consumes("application/json")
    public Response addKanban(
            @Parameter(description = "Kanban object that needs to be added to the store", required = true) Kanban kanban) {
        KanbanDao kanbanDao = new KanbanDao();
        Kanban kb = kanbanDao.createKanban(kanban.getName());
        return Response.ok().entity("SUCCESS "+kb.getId()).build();
    }
}

