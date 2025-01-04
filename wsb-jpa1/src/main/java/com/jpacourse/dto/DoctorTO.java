package com.jpacourse.dto;

import com.jpacourse.persistence.enums.Specialization;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class DoctorTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String telephoneNumber;

    private String email;

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

    public void setDoctorNumber(String doctorNumber) {
        this.doctorNumber = doctorNumber;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
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

    public String getDoctorNumber() {
        return doctorNumber;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    private String doctorNumber;

    private Specialization specialization;}
