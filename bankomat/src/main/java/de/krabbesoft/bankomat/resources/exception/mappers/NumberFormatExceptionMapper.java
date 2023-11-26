package de.krabbesoft.bankomat.resources.exception.mappers;

import de.krabbesoft.bankomat.resources.responses.ErrorMessageResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NumberFormatExceptionMapper implements ExceptionMapper<NumberFormatException> {

	@Override
	public Response toResponse(NumberFormatException exception) {
		return Response
				.status(Status.BAD_REQUEST)
				.entity(new ErrorMessageResponse("Die Eingabe konnte nicht geparsed werden"))
				.build();
	}

}
