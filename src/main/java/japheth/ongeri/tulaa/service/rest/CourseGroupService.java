package japheth.ongeri.tulaa.service.rest;

import io.swagger.annotations.Api;
import japheth.ongeri.tulaa.service.dto.ReverseAlpha;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Api
@Path("/japheth/ongeri/tulaa/")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Service
public class CourseGroupService {


    @POST
    @Path("reverseAlpha")
    public Response getReversedAlpha(ReverseAlpha reverseAlpha) {
        Response response;
        try {
            response = Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }
}