package com.thinkenterprise.domain.employee;


public class CabinAttendant extends Role {

    private int rank;

    public CabinAttendant() {
        super("CabinAttendant");
    }


    public CabinAttendant(int rank) {
        super("CabinAttendant");
        this.rank = rank;
    }


    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
