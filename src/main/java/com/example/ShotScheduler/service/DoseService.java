package com.example.ShotScheduler.service;

import com.example.ShotScheduler.Enum.VaccineBrand;
import com.example.ShotScheduler.exception.PatientNotFoundException;
import com.example.ShotScheduler.model.Dose;
import com.example.ShotScheduler.model.Patient;
import com.example.ShotScheduler.repository.DoseRepository;
import com.example.ShotScheduler.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;

    @Autowired
    PatientRepository patientRepository;

    public Dose addDose(int patientId, VaccineBrand vaccineBrand) throws PatientNotFoundException {
        //check whether patient id is valid or not
        Optional<Patient> getPatient = patientRepository.findById(patientId);
        if(getPatient.isEmpty()) {
            throw new PatientNotFoundException("Invalid Patient id");
        }
        Patient patient = getPatient.get();
        if(patient.isVaccinated()){
            throw new RuntimeException("Patient is already Vaccinated");
        }

        patient.setVaccinated(true);

        Dose dose = new Dose();
        dose.setVaccineBrand(vaccineBrand);
        dose.setSerialNumber(UUID.randomUUID().toString());
        dose.setPatient(patient); // setting FKey
        patientRepository.save(patient);
        return doseRepository.save(dose);
    }



}
