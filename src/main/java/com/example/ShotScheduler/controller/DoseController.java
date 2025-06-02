package com.example.ShotScheduler.controller;

import com.example.ShotScheduler.Enum.VaccineBrand;
import com.example.ShotScheduler.exception.PatientNotFoundException;
import com.example.ShotScheduler.model.Dose;
import com.example.ShotScheduler.service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    DoseService doseService;

    @PostMapping("/vaccinate")
    public Dose addDose(@RequestParam("id") int patientId, @RequestParam("vaccineType") VaccineBrand vaccineType) throws PatientNotFoundException {
        return doseService.addDose(patientId, vaccineType);
    }

}
