package com.nutzycraft.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDashboardDTO {
    private long activeJobs;
    private long totalHires;
    private double totalSpent;
    private long jobViews;
}
