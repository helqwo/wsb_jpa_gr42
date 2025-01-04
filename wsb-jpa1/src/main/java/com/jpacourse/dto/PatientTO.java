package com.jpacourse.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class PatientTO implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private  String telephoneNumber;
    private String email;
    private String patientNumber;
    private LocalDate dateOfBirth;
    private boolean hasAllergy;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setHasAllergy(boolean hasAllergy) {
        this.hasAllergy = hasAllergy;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean getHasAllergy() {
        return hasAllergy;
    }



}
