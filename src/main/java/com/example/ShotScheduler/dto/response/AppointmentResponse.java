package com.example.ShotScheduler.dto.response;

import com.example.ShotScheduler.Enum.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AppointmentResponse {
    private String appointmentId;
    private Date appointmentDate;
    private AppointmentStatus appointmentStatus;

    private PatientResponse patientResponse;

    private String doctorName;
}
