package com.jpacourse.mapper;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.dto.VisitToDoctorTO;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.MedicalTreatmentEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;

public class VisitToDoctorMapper {
    public static VisitToDoctorTO mapToTO(DoctorEntity doctorEntity, PatientEntity patientEntity, VisitEntity visitEntity, MedicalTreatmentEntity medicalTreatmentEntity){
        VisitToDoctorTO visitToDoctorTO = new VisitToDoctorTO();
        visitToDoctorTO.setVisit(VisitMapper.mapToTO(visitEntity));
        visitToDoctorTO.setPatient(PatientMapper.mapToTO(patientEntity));
        visitToDoctorTO.setDoctor(DoctorMapper.mapToTO(doctorEntity));
        visitToDoctorTO.setMedicalTreatment(MedicalTreatmentMapper.mapToTO(medicalTreatmentEntity));

        return visitToDoctorTO;
}}
