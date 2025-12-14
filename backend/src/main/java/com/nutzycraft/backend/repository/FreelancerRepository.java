package com.nutzycraft.backend.repository;

import com.nutzycraft.backend.entity.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {
    List<Freelancer> findByTitleContaining(String title);
}
