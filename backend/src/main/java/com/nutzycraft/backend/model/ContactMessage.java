package com.nutzycraft.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "contact_messages")
@Data
public class ContactMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;
    private String name;
    private String email;
    private String category;
    private String message;

    private LocalDateTime submittedAt;

    public ContactMessage() {
        this.submittedAt = LocalDateTime.now();
    }
}
