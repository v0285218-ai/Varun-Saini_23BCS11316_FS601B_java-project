package com.example.studentregistration.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "Login"; // Loads templates/Login.html
    }

    @GetMapping("/studentDashboard")
    public String studentDashboard() {
        return "studentDashboard";
    }

    @GetMapping("/adminDashboard")
    public String adminDashboard() {
        return "adminDashboard";
    }
}
