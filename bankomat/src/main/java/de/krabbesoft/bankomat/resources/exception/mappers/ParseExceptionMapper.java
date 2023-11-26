package de.krabbesoft.bankomat.resources.exception.mappers;

import java.text.ParseException;

import de.krabbesoft.bankomat.resources.responses.ErrorMessageResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ParseExceptionMapper implements ExceptionMapper<ParseException> {

	@Override
	public Response toResponse(ParseException exception) {
		return Response
				.status(Status.BAD_REQUEST)
				.entity(new ErrorMessageResponse("Die Eingabe konnte nicht geparsed werden"))
				.build();
	}

}
