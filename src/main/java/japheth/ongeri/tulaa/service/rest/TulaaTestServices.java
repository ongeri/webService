package japheth.ongeri.tulaa.service.rest;

import io.swagger.annotations.Api;
import japheth.ongeri.tulaa.operations.StringReverser;
import japheth.ongeri.tulaa.operations.TripletSumsAndPythgorean;
import japheth.ongeri.tulaa.service.dto.ReverseAlphaDTO;
import japheth.ongeri.tulaa.service.dto.TripletsDTO;
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
public class TulaaTestServices {

    @POST
    @Path("reverseAlpha")
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
    public Response getTripletSums(TripletsDTO tripletsDTO) {
        Response response;
        try {
            TripletSumsAndPythgorean tripletSumsAndPythgorean = new TripletSumsAndPythgorean();
            tripletsDTO.setResultCount(tripletSumsAndPythgorean.countTriplets(new HashSet<>(tripletsDTO.getDistinctIntegers()), tripletsDTO.getSumValue()));
            response = Response.ok(tripletsDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

    @POST
    @Path("pythagoreanTriplets")
    public Response checkPythagoreanTriplets(TripletsDTO tripletsDTO) {
        Response response;
        try {
            TripletSumsAndPythgorean tripletSumsAndPythgorean = new TripletSumsAndPythgorean();
            tripletsDTO.setHasPythagoreanTriplets(tripletSumsAndPythgorean.findPythagoreanTriplets(tripletsDTO.getDistinctIntegers()));
            response = Response.ok(tripletsDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }
}