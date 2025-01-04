package com.jpacourse.service;

import com.jpacourse.dto.DoctorTO;

public interface DoctorService {
    public DoctorTO findById(final Long id);
}
