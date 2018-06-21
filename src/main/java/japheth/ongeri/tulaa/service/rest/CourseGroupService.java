package japheth.ongeri.tulaa.service.rest;

import io.swagger.annotations.Api;
import japheth.ongeri.tulaa.operations.StringReverser;
import japheth.ongeri.tulaa.operations.TripletSums;
import japheth.ongeri.tulaa.service.dto.ReverseAlphaDTO;
import japheth.ongeri.tulaa.service.dto.TripletSumsDTO;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashSet;


@Api
@Path("/japheth/ongeri/tulaa/")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Service
public class CourseGroupService {

    @POST
    @Path("reverseAlphaDTO")
    public Response getReversedAlpha(ReverseAlphaDTO reverseAlphaDTO) {
        Response response;
        try {
            StringReverser stringReverser = new StringReverser();
            reverseAlphaDTO.setOutputString(stringReverser.reverseString(reverseAlphaDTO.getInputString()));
            response = Response.ok(reverseAlphaDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

    @POST
    @Path("tripletSums")
    public Response getTripletSums(TripletSumsDTO tripletSumsDTO) {
        Response response;
        try {
            TripletSums tripletSums = new TripletSums();
            tripletSumsDTO.setResultCount(tripletSums.countTriplets(new HashSet<>(tripletSumsDTO.getDistinctIntegers()), tripletSumsDTO.getSumValue()));
            response = Response.ok(tripletSumsDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }
}