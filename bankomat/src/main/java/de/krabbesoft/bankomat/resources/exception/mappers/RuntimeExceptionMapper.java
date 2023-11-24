package de.krabbesoft.bankomat.resources.exception.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import de.krabbesoft.bankomat.resources.responses.ErrorMessageResponse;

@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {

	@Override
	public Response toResponse(RuntimeException exception) {
		return Response
				.status(Status.BAD_REQUEST)
				.entity(new ErrorMessageResponse(exception.getLocalizedMessage()))
				.build();
	}

}
