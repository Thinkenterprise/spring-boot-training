package com.thinkenterprise.domain.core;

import org.springframework.data.annotation.Id;

import java.math.BigInteger;

public class AbstractDocument {
    @Id
    private BigInteger id;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }
}

