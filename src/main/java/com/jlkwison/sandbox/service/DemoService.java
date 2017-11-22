package com.jlkwison.sandbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class DemoService {

    @Autowired
    private WriterService writerService;

    public ByteArrayOutputStream baosZip() {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final ZipOutputStream zos = new ZipOutputStream(baos);
        try {
            zos.putNextEntry(new ZipEntry("testing.txt"));
            writerService.write(zos);
            zos.closeEntry();
            zos.close();
        } catch (final IOException e) {
            throw new DemoServiceException("Error zipping to stream!", e);
        }

        return baos;
    }

    public void zosZip(final OutputStream outputStream) {
        final ZipOutputStream zos = new ZipOutputStream(outputStream);
        try {
            zos.putNextEntry(new ZipEntry("testing.txt"));
            writerService.write(zos);
            zos.closeEntry();
            zos.close();
        } catch (final IOException e) {
            throw new DemoServiceException("Error zipping to stream!", e);
        }
    }

    public void zosZipWithErr(final OutputStream outputStream) {
        try (final ZipOutputStream zos = new ZipOutputStream(outputStream)) {
            zos.putNextEntry(new ZipEntry("testing.txt"));
            writerService.writeWithErr(zos);
        } catch (final IOException e) {
            throw new DemoServiceException("Error zipping to stream!", e);
        }
    }

    public void noResultException() {
        throw new RuntimeException("No results!");
    }

}
