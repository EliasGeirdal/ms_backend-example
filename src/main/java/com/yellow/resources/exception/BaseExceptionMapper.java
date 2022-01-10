package com.yellow.resources.exception;

import com.yellow.service.exception.Sid;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.UUID;

public class BaseExceptionMapper implements ExceptionMapper<RuntimeException> {

    @Override
    public Response toResponse(RuntimeException exception) {
        return Response.status(500)
                .entity(new RestError(Sid.INTERNAL_SERVER_ERROR,
                        exception.getMessage(),
                        UUID.randomUUID().toString()))
                .build();
    }
}
