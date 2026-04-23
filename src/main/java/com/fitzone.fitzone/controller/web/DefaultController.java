package com.fitzone.fitzone.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class DefaultController {

    @GetMapping("/home")
    public String homePage() {
        return "web/home";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin/admin";
    }

    @GetMapping("/default")
    public String getMethodName(HttpServletRequest request) {
        if (request.isUserInRole("ADMIN")) {
            return "redirect:/admin";
        } else
            return "redirect:/home";
    }

}
