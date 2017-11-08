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

    @RequestMapping("/zip")
    public void zip(final HttpServletResponse response) {
        response.setHeader("Content-Disposition","attachment; filename=\"demo.zip\"");
        response.setContentType("application/zip");

        final ByteArrayOutputStream baos = demoService.zipIt();
        try {
            response.getOutputStream().write(baos.toByteArray());
            baos.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
    
}
