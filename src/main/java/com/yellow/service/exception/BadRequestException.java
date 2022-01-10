package com.yellow.service.exception;

public class BadRequestException extends RuntimeException {
    private Sid sid;

    public BadRequestException(Sid sid, String message) {
        super(message);
        this.sid = sid;
    }

    public BadRequestException(Sid sid, String message, Throwable cause) {
        super(message, cause);
        this.sid = sid;
    }

    public Sid getSid() {
        return sid;
    }
}
