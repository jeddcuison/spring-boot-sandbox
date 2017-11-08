package com.jlkwison.sandbox.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;

@Service
public class WriterService {

    public void write(final OutputStream out) throws IOException {
        out.write("The quick brown fox jumped over the lazy dog!".getBytes());
    }

}
