package com.nutzycraft.backend.controller;

import com.nutzycraft.backend.dto.DashboardStatsDTO;
import com.nutzycraft.backend.dto.ClientDashboardDTO;
import com.nutzycraft.backend.dto.FreelancerDashboardDTO;
import com.nutzycraft.backend.repository.JobRepository;
import com.nutzycraft.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*") // Allow all for development simplicity
@RequiredArgsConstructor
public class DashboardController {

    private final UserRepository userRepository;
    private final JobRepository jobRepository;

    @GetMapping("/stats")
    public ResponseEntity<DashboardStatsDTO> getDashboardStats() {
        long totalUsers = userRepository.count();
        long activeJobs = jobRepository.countByStatus("OPEN"); // Assuming 'OPEN' means active

        // Mocking revenue and disputes for now as per plan
        double revenue = 15400.00;
        long openDisputes = 3;

        DashboardStatsDTO stats = new DashboardStatsDTO(totalUsers, activeJobs, revenue, openDisputes);
        return ResponseEntity.ok(stats);
    }
    @GetMapping("/client")
    public ResponseEntity<ClientDashboardDTO> getClientDashboardStats() {
        // Mock data
        long activeJobs = 3;
        long totalHires = 12;
        double totalSpent = 4250.00;
        long jobViews = 310;

        ClientDashboardDTO stats = new ClientDashboardDTO(activeJobs, totalHires, totalSpent, jobViews);
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/freelancer")
    public ResponseEntity<FreelancerDashboardDTO> getFreelancerDashboardStats() {
        // Mock data
        double totalEarnings = 12450.00;
        long completedJobs = 28;
        long activeJobs = 3;
        double rating = 5.0;

        FreelancerDashboardDTO stats = new FreelancerDashboardDTO(totalEarnings, completedJobs, activeJobs, rating);
        return ResponseEntity.ok(stats);
    }
}
