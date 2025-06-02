package com.example.ShotScheduler.service;

import com.example.ShotScheduler.exception.DoctorNotFoundException;
import com.example.ShotScheduler.model.Doctor;
import com.example.ShotScheduler.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }


    public Doctor getDoctor(int id) throws DoctorNotFoundException {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if(doctor.isEmpty()) {
            throw new DoctorNotFoundException("Invalid doctor Id");
        }else{
            return doctor.get();
        }
    }
}
