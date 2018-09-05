package com.metacube.advertisementAssignment.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.metacube.advertisementAssignment.facade.AdvertisementFacade;
import com.metacube.advertisementAssignment.model.Advertisement;

/**
 * class containing methods to operate on Advertisement resources
 * Created on September 03, 2018
 */
@Path("/AdvertisementResource")
public class AdvertisementResource {
	AdvertisementFacade advertisementFacade = AdvertisementFacade.getInstance();
	
	@GET
	@Path("/insertIntoAdvertisement/{advertisementTitle}/{advertisementDescription}/{categoryId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String insertIntoAdvertisement(@HeaderParam("Authorization") String authorizationString, 
			@PathParam("advertisementTitle")String advertisementTitle,
			@PathParam("advertisementDescription")String advertisementDescription,
			@PathParam("categoryId")int categoryId
		) {
		
		if (!"GET-2018".equals(authorizationString)) {
			return "error";
			}
		
		String result = null;
		if ( advertisementFacade.addAdvertisement(advertisementTitle, advertisementDescription, categoryId)) {
			result = "Advertisement Added";
			return result;
		}
		return result;
	}
	
	@GET
	@Path("/getAllAdvertisements")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAdvertisements() {
		List<Advertisement> advertisementList = advertisementFacade.getAdvertisements();
		if(advertisementList.size()==0){
		return Response.status(Response.Status.NOT_FOUND).entity("Entity not found").build();
		}else{
		Gson gson = new Gson();

		String advertisementJson=gson.toJson(advertisementList);

		return Response.ok(advertisementJson, MediaType.APPLICATION_JSON).build();
		}
	}
	
	@GET
	@Path("/deleteAdvertisement/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAdvertisement(@PathParam("id")int id) {
		boolean result = advertisementFacade.deleteAdvertisement(id);
		if(result) {
			return Response.ok("deleted !",MediaType.APPLICATION_JSON).build();
		} else {
			return Response.ok("Not deleted !",MediaType.APPLICATION_JSON).build();
		}
	}
	
}
