package com.example.ShotScheduler.repository;

import com.example.ShotScheduler.model.Dose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoseRepository extends JpaRepository<Dose, Integer> {
}
