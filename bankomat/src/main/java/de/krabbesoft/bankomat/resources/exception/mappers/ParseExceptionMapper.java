package de.krabbesoft.bankomat.resources.exception.mappers;

import java.text.ParseException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import de.krabbesoft.bankomat.resources.responses.ErrorMessageResponse;

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
