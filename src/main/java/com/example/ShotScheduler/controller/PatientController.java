package com.example.ShotScheduler.controller;

import com.example.ShotScheduler.exception.PatientNotFoundException;
import com.example.ShotScheduler.model.Patient;
import com.example.ShotScheduler.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @GetMapping("/get")
    public Patient getPatient(@RequestParam("id") int id) throws PatientNotFoundException {
        return patientService.getPatient(id);
    }

}
