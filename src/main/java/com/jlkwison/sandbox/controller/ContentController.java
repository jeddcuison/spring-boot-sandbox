package com.jlkwison.sandbox.controller;

import com.jlkwison.sandbox.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
public class ContentController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/errorPage")
    public String error(@RequestParam(value="errMsg", required=false,
                        defaultValue="An error was encountered processing your request!") String errMsg, Model model) {
        model.addAttribute("errMsg", errMsg);
        return "errorPage";
    }

    @RequestMapping("/zosWithErr")
    public String simulateError(final HttpServletRequest request, final HttpServletResponse response, final Model model) throws IOException {
        response.setHeader("Content-Disposition","attachment; filename=\"zos.zip\"");
        response.setContentType("application/zip");
        try {
            demoService.zosZipWithErr(response.getOutputStream());
        } catch (RuntimeException e) {
            response.sendError(500, e.getMessage());
        }
        return null;
    }

    @RequestMapping("/noResultEx")
    public String simulateNoResultEx(final HttpServletRequest request, final HttpServletResponse response, final Model model) throws IOException {
        response.setHeader("Content-Disposition","attachment; filename=\"zos.zip\"");
        response.setContentType("application/zip");
        try {
            response.getOutputStream();
            demoService.noResultException();
        } catch (RuntimeException e) {
            response.sendRedirect("/errorPage?errMsg=" + URLEncoder.encode(e.getMessage(), "UTF-8"));
        }
        return null;
    }

}
