package com.example.ShotScheduler.service;

import com.example.ShotScheduler.model.Patient;
import com.example.ShotScheduler.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
