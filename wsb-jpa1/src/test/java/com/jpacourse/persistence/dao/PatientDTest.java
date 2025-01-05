package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackages = "com.jpacourse")
public class PatientDTest {
    @Autowired
    private PatientDao patientDao;

    @Autowired
    private EntityManager entityManager;


//    @Test
//    public void testAddVisitToPatient() {
//        // Arrange
//        PatientEntity patient = new PatientEntity();
//        patient.setFirstName("John");
//        patient.setLastName("Doe");
//        patient.setHasAllergy(false);
//        patient.setDateOfBirth(LocalDate.of(1990, 1, 1));
//        patient.setPatientNumber("sadsadasda");
//        patient.setTelephoneNumber("sdasdadada");
//        entityManager.persist(patient);
//        entityManager.flush();
//
//        Long doctorId = 1L;
//        LocalDateTime visitDate = LocalDateTime.now();
//        String description = "Routine checkup";
//
//        // Act
//        patientDao.addVisitToPatient(patient.getId(), doctorId, visitDate, description);
//
//        // Assert
//        PatientEntity updatedPatient = entityManager.find(PatientEntity.class, patient.getId());
//        assertNotNull(updatedPatient);
//        assertEquals(1, updatedPatient.getVisits().size());
//
//        VisitEntity visit = updatedPatient.getVisits().get(0);
//        assertEquals(doctorId, visit.getDoctor());
//        assertEquals(visitDate, visit.getTime());
//        assertEquals(description, visit.getDescription());
//        assertEquals(updatedPatient, visit.getPatient());
//    }

    @Test
    public void testAddVisitToPatient() {
        // given
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Iwona");
        patient.setLastName("Sylwester");
        patient.setHasAllergy(false);
        patient.setDateOfBirth(LocalDate.of(1989, 1, 1));
        patient.setPatientNumber("89");
        patient.setTelephoneNumber("987654987");
        entityManager.persist(patient);
        entityManager.flush();

        Long doctorId = 1L;
        LocalDateTime visitDate = LocalDateTime.now();
        String description = "Wizyta posylwestrowa";

        // when
        patientDao.addVisitToPatient(patient.getId(), doctorId, visitDate, description);

        // then
        PatientEntity updatedPatient = entityManager.find(PatientEntity.class, patient.getId());
        assertNotNull(updatedPatient);
        assertEquals(1, updatedPatient.getVisits().size());

        VisitEntity visit = updatedPatient.getVisits().get(0);
        assertEquals(doctorId, visit.getDoctorId());
        assertEquals(visitDate, visit.getTime());
        assertEquals(description, visit.getDescription());
        assertEquals(updatedPatient, visit.getPatient());
    }
}
