package com.arktek.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.simple.JSONObject;

import com.arktek.common.NumberUtils;
import com.arktek.common.impl.NumberUtilsImpl;
import com.google.common.base.Preconditions;

/**
 * Resource class for number utilities.
 */
@Path("/numbers")
public class NumberUtilsResource {

	private NumberUtils numberUtils = new NumberUtilsImpl();
	
	@GET
	@Path("palindrome")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public Response getPalindrome(@QueryParam("number") long number) {
		
		Preconditions.checkArgument(number > 0, "Number %d must be positive", number);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("number", number);
		jsonObject.put("palindrome", numberUtils.getPalindrome(number));
		return Response.status(Status.OK).entity(jsonObject.toString()).build();
	}
	
	@GET
	@Path("reverse")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public Response getReverse(@QueryParam("number") long number) {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("number", number);
		jsonObject.put("reverse", numberUtils.reverse(number));
		return Response.status(Status.OK).entity(jsonObject.toString()).build();
	}
	
	@GET
	@Path("verifyPrime")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public Response isPrime(@QueryParam("number") long number) {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("number", number);
		jsonObject.put("is prime", numberUtils.isPrime(number));
		return Response.status(Status.OK).entity(jsonObject.toString()).build();
	}
}
