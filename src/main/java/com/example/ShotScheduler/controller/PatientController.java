package com.example.ShotScheduler.controller;

import com.example.ShotScheduler.dto.request.PatientRequest;
import com.example.ShotScheduler.dto.response.PatientResponse;
import com.example.ShotScheduler.exception.PatientNotFoundException;
import com.example.ShotScheduler.model.Patient;
import com.example.ShotScheduler.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity<Object> addPatient(@RequestBody PatientRequest patientRequest) {
        try{
            PatientResponse patientResponse = patientService.addPatient(patientRequest);
            return new ResponseEntity<>(patientResponse, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/get")
    public PatientResponse getPatient(@RequestParam("id") int id) throws PatientNotFoundException {
        return patientService.getPatient(id);
    }

}
