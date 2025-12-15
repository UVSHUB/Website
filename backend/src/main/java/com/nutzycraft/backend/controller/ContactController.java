package com.nutzycraft.backend.controller;

import com.nutzycraft.backend.dto.ContactDTO;
import com.nutzycraft.backend.model.ContactMessage;
import com.nutzycraft.backend.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    @PostMapping
    public ResponseEntity<?> submitContactForm(@RequestBody ContactDTO contactDTO) {
        try {
            ContactMessage message = new ContactMessage();
            message.setRole(contactDTO.getRole());
            message.setName(contactDTO.getName());
            message.setEmail(contactDTO.getEmail());
            message.setCategory(contactDTO.getCategory());
            message.setMessage(contactDTO.getMessage());

            contactMessageRepository.save(message);

            return ResponseEntity
                    .ok(Map.of("message", "We have received your request. A support agent will contact you shortly."));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(Map.of("error", "Failed to submit request. Please try again."));
        }
    }
}
