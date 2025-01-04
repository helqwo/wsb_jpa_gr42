package com.jpacourse.mapper;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.persistence.entity.DoctorEntity;

public class DoctorMapper {
    public static DoctorTO mapToTO(final DoctorEntity doctorEntity){
        if (doctorEntity == null)
        {
            return null;
        }
        final DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(doctorEntity.getId());
        doctorTO.setDoctorNumber(doctorEntity.getDoctorNumber());
        doctorTO.setEmail(doctorEntity.getEmail());
        doctorTO.setFirstName(doctorEntity.getFirstName());
        doctorTO.setSpecialization(doctorEntity.getSpecialization());
        doctorTO.setTelephoneNumber(doctorEntity.getTelephoneNumber());
        doctorTO.setLastName(doctorEntity.getLastName());
        return doctorTO;
    }
    public static DoctorEntity mapToEntity(final DoctorTO doctorTO)
    {
        if(doctorTO == null)
        {
            return null;
        }
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctorTO.getId());
        doctorEntity.setDoctorNumber(doctorTO.getDoctorNumber());
        doctorEntity.setEmail(doctorTO.getEmail());
        doctorEntity.setFirstName(doctorTO.getFirstName());
        doctorTO.setSpecialization(doctorTO.getSpecialization());
        doctorTO.setTelephoneNumber(doctorTO.getTelephoneNumber());
        doctorTO.setLastName(doctorTO.getFirstName());
        return doctorEntity;
}}
