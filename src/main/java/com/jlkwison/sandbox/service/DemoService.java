package com.jlkwison.sandbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class DemoService {

    @Autowired
    private WriterService writerService;

    public ByteArrayOutputStream zipIt() {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final ZipOutputStream zos = new ZipOutputStream(baos);
        try {
            zos.putNextEntry(new ZipEntry("testing.txt"));
            writerService.write(zos);
            zos.closeEntry();
        } catch (final IOException e) {
            throw new DemoServiceException("Error zipping to stream!", e);
        }

        return baos;
    }

}
