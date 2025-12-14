package com.nutzycraft.backend.controller;

import com.nutzycraft.backend.entity.Freelancer;
import com.nutzycraft.backend.repository.FreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/freelancers")
@CrossOrigin(origins = "*")
public class FreelancerController {

    @Autowired
    private FreelancerRepository freelancerRepository;

    @GetMapping
    public List<Freelancer> getAllFreelancers() {
        return freelancerRepository.findAll();
    }
}
