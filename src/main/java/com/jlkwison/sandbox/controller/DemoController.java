package com.jlkwison.sandbox.controller;

import com.jlkwison.sandbox.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/baosZip")
    public void baosZip(final HttpServletResponse response) {
        response.setHeader("Content-Disposition","attachment; filename=\"baos.zip\"");
        response.setContentType("application/zip");

        final ByteArrayOutputStream baos = demoService.baosZip();
        try {
            response.getOutputStream().write(baos.toByteArray());
            baos.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/zosZip")
    public void zosZip(final HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition","attachment; filename=\"zos.zip\"");
        response.setContentType("application/zip");
        demoService.zosZip(response.getOutputStream());
    }
    
}
