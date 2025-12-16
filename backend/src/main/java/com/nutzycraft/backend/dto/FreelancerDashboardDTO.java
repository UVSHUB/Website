package com.nutzycraft.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FreelancerDashboardDTO {
    private double totalEarnings;
    private long completedJobs;
    private long activeJobs;
    private double rating;
}
