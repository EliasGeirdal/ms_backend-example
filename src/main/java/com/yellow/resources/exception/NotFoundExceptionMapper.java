package com.yellow.resources.exception;

import com.yellow.service.exception.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.UUID;

public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException exception) {
        return Response.status(404)
                .entity(new RestError(exception.getSid(), exception.getMessage(), UUID.randomUUID().toString()))
                .build();
    }
}
