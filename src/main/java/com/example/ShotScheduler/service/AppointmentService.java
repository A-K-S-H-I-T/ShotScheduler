package com.example.ShotScheduler.service;

import com.example.ShotScheduler.Enum.AppointmentStatus;
import com.example.ShotScheduler.dto.response.AppointmentResponse;
import com.example.ShotScheduler.dto.response.PatientResponse;
import com.example.ShotScheduler.exception.DoctorNotFoundException;
import com.example.ShotScheduler.exception.PatientNotFoundException;
import com.example.ShotScheduler.model.Appointment;
import com.example.ShotScheduler.model.Doctor;
import com.example.ShotScheduler.model.Patient;
import com.example.ShotScheduler.repository.AppointmentRepository;
import com.example.ShotScheduler.repository.DoctorRepository;
import com.example.ShotScheduler.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired private AppointmentRepository appointmentRepository;
    @Autowired private PatientRepository patientRepository;
    @Autowired private DoctorRepository doctorRepository;

    public AppointmentResponse bookAppointment(int patientId, int doctorId) throws PatientNotFoundException, DoctorNotFoundException {
        Optional<Patient> patient = patientRepository.findById(patientId);
        if(patient.isEmpty()){
            throw new PatientNotFoundException("Invalid patient Id!");
        }
        Patient patience = patient.get();
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        if(doctor.isEmpty()){
            throw new DoctorNotFoundException("Invalid doctor Id!");
        }
        Doctor doc = doctor.get();

        //Book Appointment
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(UUID.randomUUID().toString());
        appointment.setAppointmentStatus(AppointmentStatus.BOOKED);
        appointment.setDoctor(doc);
        appointment.setPatient(patience);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        AppointmentResponse appointmentResponse = new AppointmentResponse();
        appointmentResponse.setAppointmentId(savedAppointment.getAppointmentId());
        appointmentResponse.setAppointmentStatus(savedAppointment.getAppointmentStatus());
        appointmentResponse.setAppointmentDate(savedAppointment.getAppointmentDate());
        appointmentResponse.setDoctorName(savedAppointment.getDoctor().getName());

        Patient savedPatient = savedAppointment.getPatient();
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setFirstName(savedPatient.getFirstName());
        patientResponse.setLastName(savedPatient.getLastName());
        patientResponse.setEmail(savedPatient.getEmail());
        patientResponse.setVaccinated(savedPatient.isVaccinated());
        appointmentResponse.setPatientResponse(patientResponse);

        return appointmentResponse;
    }
}
