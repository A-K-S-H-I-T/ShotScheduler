package com.example.ShotScheduler.controller;

import com.example.ShotScheduler.exception.DoctorNotFoundException;
import com.example.ShotScheduler.exception.PatientNotFoundException;
import com.example.ShotScheduler.model.Appointment;
import com.example.ShotScheduler.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity<Object> bookAppointment(@RequestParam("pid") int patientId, @RequestParam("did") int doctorId) throws PatientNotFoundException, DoctorNotFoundException {
        try{
            Appointment bookedAppointment = appointmentService.bookAppointment(patientId, doctorId);
            return new ResponseEntity<>(bookedAppointment, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
