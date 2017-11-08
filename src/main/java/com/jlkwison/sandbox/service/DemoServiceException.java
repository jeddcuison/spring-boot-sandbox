package com.jlkwison.sandbox.service;

import java.io.IOException;

public class DemoServiceException extends RuntimeException {

    public DemoServiceException(final String msg, final IOException e) {
        super(msg, e);
    }

}
