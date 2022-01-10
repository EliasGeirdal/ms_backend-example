package com.yellow.resources.exception;

import com.yellow.service.exception.Sid;

public class RestError {
    private final Sid sid;
    private final String message;
    private final String traceId;

    public RestError(Sid sid, String message, String traceId) {
        this.sid = sid;
        this.message = message;
        this.traceId = traceId;
    }

    public Sid getSid() {
        return sid;
    }

    public String getMessage() {
        return message;
    }

    public String getTraceId() {
        return traceId;
    }
}
