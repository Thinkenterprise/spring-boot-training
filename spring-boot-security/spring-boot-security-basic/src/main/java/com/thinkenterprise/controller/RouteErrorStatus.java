package com.thinkenterprise.controller;


public class RouteErrorStatus {
    private long functionalErrorCode;
    private String functionalErrorMessage;

    public RouteErrorStatus(long functionalErrorCode, String functionalErrorMessage) {
        this.functionalErrorCode = functionalErrorCode;
        this.functionalErrorMessage = functionalErrorMessage;
    }

    public long getFunctionalErrorCode() {
        return functionalErrorCode;
    }

    public void setFunctionalErrorCode(long functionalErrorCode) {
        this.functionalErrorCode = functionalErrorCode;
    }

    public String getFunctionalErrorMessage() {
        return functionalErrorMessage;
    }

    public void setFunctionalErrorMessage(String functionalErrorMessage) {
        this.functionalErrorMessage = functionalErrorMessage;
    }
}
