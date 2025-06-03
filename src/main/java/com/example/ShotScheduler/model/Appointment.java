package com.example.ShotScheduler.model;

import com.example.ShotScheduler.Enum.AppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String appointmentId;

    @Column(nullable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(nullable = false)
    @CreationTimestamp
    private Date appointmentDate;

    @Column(nullable = false)
    private AppointmentStatus appointmentStatus;

    @ManyToOne //many appoint with same doctors
    @JoinColumn
    Doctor doctor;

    @OneToOne //many appointment for 1 patient (case: 2 or more dose)
    @JoinColumn
    Patient patient;

}
