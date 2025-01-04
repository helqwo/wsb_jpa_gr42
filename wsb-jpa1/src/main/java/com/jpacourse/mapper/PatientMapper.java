package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.entity.PatientEntity;

public class PatientMapper {
    public static PatientTO mapToTO(final PatientEntity patientEntity)
    {if(patientEntity == null){
        return null;
    }
    final PatientTO patientTO = new PatientTO();
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setId(patientEntity.getId());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setHasAllergy(patientEntity.getHasAllergy());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        return patientTO;
    }
    public static PatientEntity mapToEntity(final PatientTO patientTO)
    {
        if(patientTO == null){
            return null;
        }
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setHasAllergy(patientTO.getHasAllergy());
        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        return patientEntity;
    }
}
