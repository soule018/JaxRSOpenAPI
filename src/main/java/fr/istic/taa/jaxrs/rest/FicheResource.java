package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.FicheDao;
import fr.istic.taa.jaxrs.domain.Fiche;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;

@Path("/fiche")
@Produces({"application/json", "application/xml"})
public class FicheResource {

    @GET
    @Path("/")
    public List<Fiche> getAllFiche()  {
        FicheDao ficheDao = new FicheDao();
        return ficheDao.findAll();
    }

    @GET
    @Path("/{ficheId}")
    public Fiche getFicheById(@PathParam("ficheId") Long ficheId)  {
        FicheDao ficheDao = new FicheDao();
        return ficheDao.findOne(ficheId);
    }

    @POST
    @Consumes("application/json")
    public Response addFiche(
            @Parameter(description = "Fiche object that needs to be added to the store", required = true) Fiche fiche) {
            FicheDao ficheDao = new FicheDao();
            Fiche fic = ficheDao.createFiche(fiche.getLibelle());
        return Response.ok().entity("SUCCESS "+fic.getId()).build();
    }
}
