package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;

import java.util.List;

public interface PatientService {
    PatientTO findPatientById(Long id);

    void deletePatient(Long id);

    List<VisitTO> findAllVisitsByPatientID(Long id);
}
