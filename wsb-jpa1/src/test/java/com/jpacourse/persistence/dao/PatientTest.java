package com.jpacourse.persistence.dao;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.dao.PatientDao;

import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.Specialization;
import com.jpacourse.persistence.enums.TreatmentType;
import com.jpacourse.service.PatientService;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PatientTest {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private PatientService patientService;

    @Autowired
    private EntityManager entityManager;

    private PatientEntity patientEntityOne(){
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setHasAllergy(false);
        patientEntity.setPatientNumber("1");
        patientEntity.setEmail("zlachmurka@gmail.com");
        patientEntity.setFirstName("Barbara");
        patientEntity.setLastName("Rozowa");
        patientEntity.setTelephoneNumber("123456789");
        patientEntity.setDateOfBirth(LocalDate.of(1999,11,12));

        return patientEntity;
    }

    private DoctorEntity doctorEntityOne(){
        DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setFirstName("Mariola");
        doctorEntity.setLastName("Szalon");
        doctorEntity.setEmail("szalomszalom@gmail.com");
        doctorEntity.setTelephoneNumber("987654321");
        doctorEntity.setSpecialization(Specialization.DERMATOLOGIST);
        doctorEntity.setDoctorNumber("1");

        return doctorEntity;
    }

    private VisitEntity visitEntityOne(){
        VisitEntity visitEntity = new VisitEntity();
        DoctorEntity doctorEntity = doctorEntityOne();
        entityManager.persist(doctorEntity);

        visitEntity.setDescription("Wizyta laryngologiczna");
        visitEntity.setDoctor(doctorEntity);
        visitEntity.setTime(LocalDateTime.now());
        visitEntity.setPatient(patientEntityOne());

        return visitEntity;
    }

    @Test
    public void shouldFindPatientById() {
        // given
        PatientEntity patientEntity = patientEntityOne();
        patientDao.save(patientEntity);

        // when
        PatientTO patientTO = patientService.findPatientById(patientEntity.getId());

        // then
        assertNotNull(patientTO);

        assertEquals(patientEntity.getId(), patientTO.getId());
        assertEquals(patientEntity.getFirstName(), patientTO.getFirstName());
        assertEquals(patientEntity.getLastName(), patientTO.getLastName());
        assertEquals(patientEntity.getTelephoneNumber(), patientTO.getTelephoneNumber());
        assertEquals(patientEntity.getEmail(), patientTO.getEmail());
        assertEquals(patientEntity.getPatientNumber(),  patientTO.getPatientNumber());
        assertEquals(patientEntity.getDateOfBirth(), patientTO.getDateOfBirth());
        assertEquals(patientEntity.getHasAllergy(), patientTO.getHasAllergy());
    }

    @Test
    public void shouldCascadeDeletePatient() {
        // given
        PatientEntity patientEntity = patientEntityOne();
        patientDao.save(patientEntity);

        VisitEntity visitEntity = visitEntityOne();
        visitEntity.setPatient(patientEntity);

        // when
        patientService.deletePatient(patientEntity.getId());

        // then
        PatientTO patientTO = patientService.findPatientById(patientEntity.getId());
        assertNull(patientTO);

        List<VisitEntity> visits = entityManager.createQuery("SELECT v from VisitEntity v WHERE v.patient.id = :patientId", VisitEntity.class).setParameter("patientId", patientEntity.getId()).getResultList();

        assertTrue(visits.isEmpty());

        DoctorEntity doctorEntity = entityManager.find(DoctorEntity.class, visitEntity.getDoctor().getId());
        assertNotNull(doctorEntity);
    }

    @Test
    public void shouldListVisitsByPatientId() {
        // given
        Long patientId = 1L;

        // when
        List<VisitTO> visits = patientService.findAllVisitsByPatientID(patientId);

        // then
        assertNotNull(visits);
        assertEquals(1, visits.size());
    }

}
