package de.krabbesoft.bankomat.resources;

import java.text.ParseException;
import java.util.Locale;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.krabbesoft.bankomat.business.Bankomat;
import de.krabbesoft.bankomat.business.InputParser;
import de.krabbesoft.bankomat.model.Stueckelung;
import de.krabbesoft.bankomat.resources.responses.StueckelungResponse;

@Path("stueckelung")
public class CalculatorResource {

	@Inject
	private Bankomat bankomat;

	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStueckelung(@QueryParam("value") String value) throws ParseException {
		InputParser.ParseResult result = InputParser.parse(Locale.GERMANY, value);
		Stueckelung stueckelung = bankomat.berechneStueckelung(result.euro(), result.cent());

		return Response.ok(StueckelungResponse.of(stueckelung)).build();
	}

}
