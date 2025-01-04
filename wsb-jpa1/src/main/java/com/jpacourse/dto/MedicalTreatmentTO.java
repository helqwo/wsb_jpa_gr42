package com.jpacourse.dto;

import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.TreatmentType;

public class MedicalTreatmentTO {


    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public TreatmentType getType() {
        return type;
    }

    public VisitEntity getVisitEntity() {
        return visitEntity;
    }
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(TreatmentType type) {
        this.type = type;
    }

    public void setVisitEntity(VisitEntity visitEntity) {
        this.visitEntity = visitEntity;
    }

    private String description;


    private TreatmentType type;


    private VisitEntity visitEntity;
}
