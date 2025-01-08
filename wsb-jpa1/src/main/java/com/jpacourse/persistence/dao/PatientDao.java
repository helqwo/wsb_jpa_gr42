package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {
    void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime visitDate, String description);

    List<PatientEntity> findPatientsByLastName(String lastName);

    List<PatientEntity> findPatientsWithMoreThanXVisits(int x);

    List<PatientEntity> findPatientsWithAllergy();

    List<PatientEntity> findPatientsWithAllergyLike(boolean value);

}
