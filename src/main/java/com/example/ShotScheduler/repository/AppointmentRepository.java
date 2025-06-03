package com.example.ShotScheduler.repository;

import com.example.ShotScheduler.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
