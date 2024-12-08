package com.jpacourse.persistence.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	private PatientEntity patient;
	public PatientEntity getPatient(){return patient;}
	public void setPatient(PatientEntity patient){this.patient=patient;}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCTOR_ID")
	private DoctorEntity doctor;
	public DoctorEntity getDoctor(){return doctor;}
	public void setDoctor(DoctorEntity doctor){this.doctor=doctor;}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

}
