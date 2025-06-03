package com.example.ShotScheduler.service;

import com.example.ShotScheduler.Enum.Gender;
import com.example.ShotScheduler.dto.request.PatientRequest;
import com.example.ShotScheduler.dto.response.PatientResponse;
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

    public PatientResponse addPatient(PatientRequest patientRequest) {
        //convert DTO to model/entity
        Patient patient = new Patient();
        patient.setFirstName(patientRequest.getFirstName());
        patient.setLastName(patientRequest.getLastName());
        patient.setAge(patientRequest.getAge());
        patient.setEmail(patientRequest.getEmail());
        patient.setMobileNumber(patientRequest.getMobileNumber());
        patient.setGender(patientRequest.getGender());

//        patient.setDateOfBirth(patientRequest.getDateOfBirth());

        Patient savedPatient = patientRepository.save(patient);

        //Convert model to response-DTO

        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setFirstName(savedPatient.getFirstName());
        patientResponse.setLastName(savedPatient.getLastName());
        patientResponse.setEmail(savedPatient.getEmail());
        patientResponse.setVaccinated(savedPatient.isVaccinated());
        return patientResponse;
    }

    public PatientResponse getPatient(int id) throws PatientNotFoundException {
        //Optional is a inbuilt class in java
        // (if object is null isEmpty will be true otherwise it will return the object)
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isEmpty()) {
            throw new PatientNotFoundException("Invalid patient id");
        }else{
            Patient patient = patientOptional.get();
            PatientResponse patientResponse = new PatientResponse();
            patientResponse.setFirstName(patient.getFirstName());
            patientResponse.setLastName(patient.getLastName());
            patientResponse.setEmail(patient.getEmail());
            patientResponse.setVaccinated(patient.isVaccinated());
            return patientResponse;
        }
    }
}
