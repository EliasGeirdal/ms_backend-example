package com.yellow.resources.exception;

import com.yellow.service.exception.BadRequestException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.UUID;

public class BadRequestMapper implements ExceptionMapper<BadRequestException> {

    @Override
    public Response toResponse(BadRequestException exception) {
        return Response.status(400)
                .entity(new RestError(exception.getSid(),
                        exception.getMessage(),
                        UUID.randomUUID().toString()))
                .build();
    }
}
