package com.jpacourse.dto;

import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

public class VisitTO {

    private Long id;

    private String description;

    private LocalDateTime time;
    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    private VisitToDoctorTO visitToDoctor;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setVisitToDoctor(VisitToDoctorTO visitToDoctor) {
        this.visitToDoctor = visitToDoctor;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public VisitToDoctorTO getVisitToDoctor() {
        return visitToDoctor;
    }
}
