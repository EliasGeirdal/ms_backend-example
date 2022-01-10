package com.yellow.resources.exception;

import com.yellow.service.exception.InternalServerException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.UUID;

public class InternalSeverExceptionMapper implements ExceptionMapper<InternalServerException> {
    @Override
    public Response toResponse(InternalServerException exception) {
        return Response.status(500)
                .entity(
                        new RestError(exception.getSid(),
                                exception.getMessage(),
                                UUID.randomUUID().toString()))
                .build();
    }
}
