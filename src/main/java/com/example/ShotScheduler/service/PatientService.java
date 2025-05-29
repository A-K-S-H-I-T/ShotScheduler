package com.example.ShotScheduler.service;

import com.example.ShotScheduler.exception.PatientNotFoundException;
import com.example.ShotScheduler.model.Patient;
import com.example.ShotScheduler.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient getPatient(int id) throws PatientNotFoundException {
        //Optional is a inbuilt class in java
        // (if object is null isEmpty will be true otherwise it will return the object)
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isEmpty()) {
            throw new PatientNotFoundException("Invalid patient id");
        }else{
            return patientOptional.get();
        }
    }
}
