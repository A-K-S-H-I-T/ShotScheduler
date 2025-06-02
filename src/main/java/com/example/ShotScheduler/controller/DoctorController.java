package com.example.ShotScheduler.controller;

import com.example.ShotScheduler.exception.DoctorNotFoundException;
import com.example.ShotScheduler.model.Doctor;
import com.example.ShotScheduler.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    @GetMapping("/get")
    public Doctor getDoctor(@RequestParam("id") int id) throws DoctorNotFoundException {
        return doctorService.getDoctor(id);
    }

}
