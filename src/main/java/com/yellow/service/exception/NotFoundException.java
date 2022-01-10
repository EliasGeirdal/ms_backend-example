package com.yellow.service.exception;

public class NotFoundException extends RuntimeException {
    private Sid sid;

    public NotFoundException(Sid sid, String message, Throwable cause) {
        super(message, cause);
        this.sid = sid;
    }

    public Sid getSid() {
        return sid;
    }
}
