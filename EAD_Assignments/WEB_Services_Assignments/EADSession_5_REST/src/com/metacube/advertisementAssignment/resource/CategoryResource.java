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
import com.metacube.advertisementAssignment.facade.CategoryFacade;
import com.metacube.advertisementAssignment.model.Category;

/**
 * class containing method performing operations on category resources
 * created on September 03, 2018
 */
@Path("/CategoryResource")
public class CategoryResource {
	CategoryFacade categoryFacade = CategoryFacade.getInstance();
	
	@GET
	@Path("/insertIntoCategory/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String insertIntoCategory(@HeaderParam("Authorization") String authorizationString, @PathParam("name")String name) {
		
		if (!"GET-2018".equals(authorizationString)) {
			return "error";
			}
		
		String result = null;
		if ( categoryFacade.addCatgeory(name)) {
			result = "Category Added";
			return result;
		}
		return result;
	}
	
	@GET
	@Path("/getAllCategories")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCategories() {
		List<Category> categoryList = categoryFacade.getAllCategories();
		if(categoryList.size()==0){
		return Response.status(Response.Status.NOT_FOUND).entity("Entity not found").build();
		}else{
		Gson gson = new Gson();

		String categoryJson=gson.toJson(categoryList);

		return Response.ok(categoryJson, MediaType.APPLICATION_JSON).build();
		}
	}
	
	@GET
	@Path("/UpdateCategory/{id}/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCategory(@PathParam("id") int id,@PathParam("name") String name) {
		if(id==0 || name == null){
			return Response.serverError().entity("input parameters cannot be blank").build();
		}
		if(categoryFacade.updateCategory(name, id))
		{
			return Response.ok("Successfully Updated", MediaType.APPLICATION_JSON).build();
		}
		else{
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not Created").build();
		}
	}
	
}
