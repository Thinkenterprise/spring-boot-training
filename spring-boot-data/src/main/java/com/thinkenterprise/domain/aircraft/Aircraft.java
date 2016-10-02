package com.thinkenterprise.domain.aircraft;

import com.thinkenterprise.domain.core.AbstractEntity;

import javax.persistence.Entity;


@Entity
public class Aircraft extends AbstractEntity {

    private String type;

    private String registration;

    public Aircraft() {
        super();
    }

    public Aircraft(String type, String registration) {
        super();
        this.type = type;
        this.registration = registration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
}
