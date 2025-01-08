package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.rest.exception.EntityNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    @Transactional
    public void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime visitDate, String description) {

        PatientEntity patient = entityManager.find(PatientEntity.class, patientId);
        if (patient == null) {
            throw new EntityNotFoundException(patientId);
        }

        VisitEntity visit = new VisitEntity();
        visit.setDoctorId(doctorId);
        visit.setDescription(description);
        visit.setTime(visitDate);

        patient.addVisit(visit);

        entityManager.merge(patient);
    }
    @Override
    public List<PatientEntity> findPatientsByLastName(String lastName) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "select p from PatientEntity p where p.lastName = :lastName",
                PatientEntity.class
        );
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }
    @Override
    public List<PatientEntity> findPatientsWithMoreThanXVisits(int x) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "select p from PatientEntity p where size(p.visits) > :x ",
                PatientEntity.class
        );
        query.setParameter("x", x);
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithAllergy() {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "select p from PatientEntity p where p.hasAllergy = true",
                PatientEntity.class
        );

        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithAllergyLike(boolean value) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "select p from PatientEntity p where p.hasAllergy = :value",
                PatientEntity.class
        );
        query.setParameter("value", value);
        return query.getResultList();
    }






}
