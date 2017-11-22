package com.jlkwison.sandbox.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;

@Service
public class WriterService {

    public void write(final OutputStream out) throws IOException {

        for (long l = 0; l < 10000000; l++) {
            out.write("The quick brown fox jumped over the lazy dog! The quick brown fox jumped over the lazy dog! The quick brown fox jumped over the lazy dog! The quick brown fox jumped over the lazy dog! The quick brown fox jumped over the lazy dog! The quick brown fox jumped over the lazy dog! The quick brown fox jumped over the lazy dog! The quick brown fox jumped over the lazy dog! The quick brown fox jumped over the lazy dog!".getBytes());
            out.flush();
        }

    }

    public void writeWithErr(final OutputStream out) throws IOException {

        for (long l = 0; l < 10000000; l++) {
            out.write("The quick brown fox jumped over the lazy dog! The quick brown fox jumped over the lazy dog! The quick brown fox jumped over the lazy dog! The quick brown fox jumped over the lazy dog! The quick brown fox jumped over the lazy dog! The quick brown fox jumped over the lazy dog! The quick brown fox jumped over the lazy dog! The quick brown fox jumped over the lazy dog! The quick brown fox jumped over the lazy dog!".getBytes());
            out.flush();
            if (l == 1000000) {
                throw new RuntimeException("Simulating an error while writing to output stream!");
            }
        }

    }

}
