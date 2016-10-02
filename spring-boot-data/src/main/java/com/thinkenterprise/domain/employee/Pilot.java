package com.thinkenterprise.domain.employee;

import javax.persistence.Entity;


@Entity
public class Pilot extends Role {

    private String certificateNumber;

    private String[] allowedAircraft;

    public Pilot() {
        super("Pilot");
    }


    public Pilot(String certificateNumber, String[] allowedAircraft) {
        super("Pilot");
        this.certificateNumber = certificateNumber;
        this.allowedAircraft = allowedAircraft;
    }


    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String[] getAllowedAircraft() {
        return allowedAircraft;
    }

    public void setAllowedAircraft(String[] allowedAircraft) {
        this.allowedAircraft = allowedAircraft;
    }
}
