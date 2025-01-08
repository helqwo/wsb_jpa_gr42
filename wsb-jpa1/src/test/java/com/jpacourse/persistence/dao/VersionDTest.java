package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;


import javax.persistence.EntityManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.Assert.assertThrows;
import javax.persistence.OptimisticLockException;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackages = "com.jpacourse")
public class VersionDTest {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private VisitDao visitDao;

    @Test
    public void testOptimisticLocking() {


        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Iwona");
        patient.setLastName("Sylwester");
        patient.setHasAllergy(false);
        patient.setDateOfBirth(LocalDate.of(1989, 1, 1));
        patient.setPatientNumber("89");
        patient.setTelephoneNumber("987654987");
        entityManager.persist(patient);


        VisitEntity visit = new VisitEntity();
        visit.setDescription("Initial Visit");
        visit.setDoctorId(1L);
        visit.setTime(LocalDateTime.now());
        visit.setPatient(patient);
        visitDao.save(visit);


        entityManager.flush();
        entityManager.clear();


        VisitEntity visitInTransaction1 = entityManager.find(VisitEntity.class, visit.getId());
        VisitEntity visitInTransaction2 = entityManager.find(VisitEntity.class, visit.getId());


        visitInTransaction1.setDescription("Updated by Transaction 1");


        var versionBeforeSave1 = visitInTransaction1.getVersion();
        assertEquals("Version should be 0", 0, versionBeforeSave1.intValue());


        visitDao.update(visitInTransaction1);
        entityManager.flush();


        visitInTransaction2.setDescription("Updated by Transaction 2");


        var versionBeforeSave2 = visitInTransaction2.getVersion();
        assertEquals("Version should be 1 before save", 1, versionBeforeSave2.intValue());


    }}