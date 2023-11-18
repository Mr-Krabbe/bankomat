package de.krabbesoft.bankomat.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("stueckelung")
public class CalculatorResource {
	
	@GET
	@Path("{value}")
	@Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
	public String getStueckelung(@PathParam("value") String value) {
		return """
				{
				"Dein Wert" : "%s"
				}
				
				"""
				.formatted(value);
	}

}
