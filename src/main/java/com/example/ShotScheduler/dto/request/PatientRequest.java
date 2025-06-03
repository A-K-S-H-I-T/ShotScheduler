package com.example.ShotScheduler.dto.request;

import com.example.ShotScheduler.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientRequest {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private Date dateOfBirth;
    private String mobileNumber;
    private String email;
}
