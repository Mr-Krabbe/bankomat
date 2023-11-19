package de.krabbesoft.bankomat.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.krabbesoft.bankomat.business.Bankomat;
import de.krabbesoft.bankomat.model.Stueckelung;

@Path("stueckelung")
public class CalculatorResource {
	
	@Inject
	private Bankomat bankomat;
	
	@GET
	@Path("{value}")
	@Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
	public String getStueckelung(@PathParam("value") String value) {
		Stueckelung stueckelung = bankomat.berechneStueckelung(230, 50);
		
		System.out.println(stueckelung);
		// TODO: check if we received a valid numeric value. The string could be anything. Want to use the validation API?
		return """
				{
				"Dein Wert" : "%s"
				}
				
				"""
				.formatted(value);
		
		// TODO: return an appropriate json string by converting the 'Stueckelung' object into a json
	}

}
