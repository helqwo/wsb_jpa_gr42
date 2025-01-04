package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.mapper.VisitMapper;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class PatientServiceImpl implements PatientService
{
    private final PatientDao patientDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public PatientTO findPatientById(Long id) {
        PatientEntity patientEntity = patientDao.findOne(id);

        return PatientMapper.mapToTO(patientEntity);

    }

    @Override
    @Transactional
    public void deletePatient(Long id){

        String jpql = "DELETE FROM VisitEntity v WHERE v.patient.id = :patientId";
        entityManager.createQuery(jpql)
                .setParameter("patientId", id)
                .executeUpdate();

        PatientEntity patientEntity = patientDao.findOne(id);
        patientDao.delete(patientEntity);
    }

    @Override
    public List<VisitTO> findAllVisitsByPatientID(Long id) {
        PatientEntity patientEntity = patientDao.findOne(id);

        if (patientEntity == null) {
            return null;
        }

        return patientEntity.getVisits().stream()
                .map(VisitMapper::mapToTO)
                .collect(Collectors.toList());

    }

}
