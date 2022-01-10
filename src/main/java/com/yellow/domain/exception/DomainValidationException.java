package com.yellow.domain.exception;

import com.yellow.service.exception.Sid;

public class DomainValidationException extends Exception {
    private Sid sid;

    public DomainValidationException(Sid sid, String errorMEssage) {
        super(errorMEssage);
        this.sid = sid;
    }

    public Sid getSid() {
        return sid;
    }
}
