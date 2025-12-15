package com.nutzycraft.backend.dto;

import lombok.Data;

@Data
public class ContactDTO {
    private String role;
    private String name;
    private String email;
    private String category;
    private String message;
}
