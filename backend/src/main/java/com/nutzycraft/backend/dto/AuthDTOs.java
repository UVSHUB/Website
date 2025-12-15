package com.nutzycraft.backend.dto;

import lombok.Data;

public class AuthDTOs {

    @Data
    public static class ClientRegisterRequest {
        private String fullName;
        private String email;
        private String password;
        private String companyName;
        private String industry;
    }

    @Data
    public static class FreelancerRegisterRequest {
        private String fullName;
        private String email;
        private String password;
        // Add specific freelancer fields if needed
    }

    @Data
    public static class LoginRequest {
        private String email;
        private String password;
    }

    @Data
    public static class ForgotPasswordRequest {
        private String email;
    }

    @Data
    public static class ResetPasswordRequest {
        private String token;
        private String newPassword;
    }

    @Data
    public static class VerifyRequest {
        private String email;
        private String code;
    }

    @Data
    public static class GoogleLoginRequest {
        private String token;
        private String role; // "CLIENT" or "FREELANCER" (optional if user exists)
    }
}
