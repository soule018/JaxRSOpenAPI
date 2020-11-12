package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.SectionDao;
import fr.istic.taa.jaxrs.domain.Section;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;

@Path("/section")
@Produces({"application/json", "application/xml"})
public class SectionResource {

    @GET
    @Path("/")
    public List<Section> getAllSection()  {
        SectionDao sectionDao = new SectionDao();
        return sectionDao.findAll();
    }

    @GET
    @Path("/{sectionId}")
    public Section getSectionById(@PathParam("sectionId") Long sectionId)  {
        SectionDao sectionDao = new SectionDao();
        return sectionDao.findOne(sectionId);
    }

    @POST
    @Consumes("application/json")
    public Response addSection(
            @Parameter(description = "Section object that needs to be added to the store", required = true) Section section) {
        SectionDao sectionDao = new SectionDao();
        Section sect = sectionDao.createSection(section.getName());
        return Response.ok().entity("SUCCESS "+sect.getId()).build();
    }
}

