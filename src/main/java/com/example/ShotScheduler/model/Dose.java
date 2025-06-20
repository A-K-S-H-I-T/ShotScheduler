package com.example.ShotScheduler.model;

import com.example.ShotScheduler.Enum.VaccineBrand;
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
public class Dose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String serialNumber; // UUID

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private VaccineBrand vaccineBrand;

    @CreationTimestamp
    private Date dateOfVaccination;

    @OneToOne  //1 patient -> 1 dose
    @JoinColumn //create foreign key column -> patient - id
    Patient patient;

}
