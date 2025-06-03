package com.example.ShotScheduler.controller;

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
    public ResponseEntity<String> addPatient(@RequestBody Patient patient) {
        try{
            patientService.addPatient(patient);
            return new ResponseEntity<>("Patient Added Successfully", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/get")
    public Patient getPatient(@RequestParam("id") int id) throws PatientNotFoundException {
        return patientService.getPatient(id);
    }

}
