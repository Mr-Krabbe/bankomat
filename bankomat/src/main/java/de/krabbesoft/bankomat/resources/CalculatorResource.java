package de.krabbesoft.bankomat.resources;

import java.text.ParseException;
import java.util.Locale;

import de.krabbesoft.bankomat.business.Bankomat;
import de.krabbesoft.bankomat.business.InputParser;
import de.krabbesoft.bankomat.model.Stueckelung;
import de.krabbesoft.bankomat.resources.responses.ErrorMessageResponse;
import de.krabbesoft.bankomat.resources.responses.StueckelungResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("stueckelung")
@Tag(name = "Stückelung von Beträgen")
public class CalculatorResource {

	@Inject
	private Bankomat bankomat;

	@Operation(
			summary = "Stückelt einen Betrag in Einzelwerte", 
			description = "Übergeben wird der Betrag, der in Einzelwerte gestückelt werden soll. Der Gesamtbetrag wird "
					+ "immer so gestückelt, dass die größtmöglichen Scheine bzw. Münzen zuerst genommen werden. "
					+ "Damit wird erreicht, dass möglichst wenige Scheine und Münzen benötigt werden.", 
			responses = {
					@ApiResponse(
							responseCode = "200", 
							description = "Der Betrag konnte erfolgreich gestückelt werden", 
							content = @Content(schema = @Schema(implementation = StueckelungResponse.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "Es liegt ein Fehler bei der Benutzereingabe vor", 
							content = @Content(schema = @Schema(implementation = ErrorMessageResponse.class)))
	})
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStueckelung(@QueryParam("value") String value) throws ParseException {
		InputParser.ParseResult result = InputParser.parse(Locale.GERMANY, value);
		Stueckelung stueckelung = bankomat.berechneStueckelung(result.euro(), result.cent());

		return Response.ok(StueckelungResponse.of(stueckelung)).build();
	}

}
