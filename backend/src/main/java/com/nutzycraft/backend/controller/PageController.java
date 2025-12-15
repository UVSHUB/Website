package com.nutzycraft.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "forward:/index.html";
    }

    @GetMapping("/about")
    public String about() {
        return "forward:/about.html";
    }

    @GetMapping("/services")
    public String services() {
        return "forward:/services.html";
    }

    @GetMapping("/contact")
    public String contact() {
        return "forward:/contact.html";
    }

    @GetMapping("/portfolio")
    public String portfolio() {
        return "forward:/portfolio.html";
    }

    @GetMapping("/how-it-works")
    public String howItWorks() {
        return "forward:/how-it-works.html";
    }

    @GetMapping("/pricing")
    public String pricing() {
        return "forward:/pricing.html";
    }

    @GetMapping("/legal")
    public String legal() {
        return "forward:/legal.html";
    }

    @GetMapping("/login")
    public String login() {
        return "forward:/login.html";
    }

    @GetMapping("/register")
    public String register() {
        return "forward:/register.html";
    }

    @GetMapping("/register-freelancer")
    public String registerFreelancer() {
        return "forward:/register-freelancer.html";
    }

    @GetMapping("/verify-email")
    public String verifyEmail() {
        return "forward:/verify-email.html";
    }

    @GetMapping("/forgot-password")
    public String forgotPasswordPage() {
        return "forward:/forgot-password.html";
    }

    @GetMapping("/reset-password")
    public String resetPasswordPage() {
        return "forward:/reset-password.html";
    }

    @GetMapping("/post-job")
    public String postJob() {
        return "forward:/post-job.html";
    }

    @GetMapping("/admin-login")
    public String adminLogin() {
        return "forward:/admin-login.html";
    }

    @GetMapping("/admin-register")
    public String adminRegister() {
        return "forward:/admin-register.html";
    }

}
