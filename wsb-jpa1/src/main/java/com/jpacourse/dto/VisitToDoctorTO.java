package com.jpacourse.dto;

public class VisitToDoctorTO
{
    private DoctorTO doctor;

    private VisitTO visit;

    public PatientTO getPatient() {
        return patient;
    }

    public MedicalTreatmentTO getMedicalTreatment() {
        return medicalTreatment;
    }

    public void setPatient(PatientTO patient) {
        this.patient = patient;
    }

    public void setMedicalTreatment(MedicalTreatmentTO medicalTreatment) {
        this.medicalTreatment = medicalTreatment;
    }

    private PatientTO patient;
    private MedicalTreatmentTO medicalTreatment;

    public DoctorTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorTO doctor) {
        this.doctor = doctor;
    }

    public void setVisit(VisitTO visit) {
        this.visit = visit;
    }

    public VisitTO getVisit() {
        return visit;
    }
}
