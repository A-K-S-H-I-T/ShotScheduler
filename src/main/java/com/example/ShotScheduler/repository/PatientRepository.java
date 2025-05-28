package com.example.ShotScheduler.repository;

import com.example.ShotScheduler.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
