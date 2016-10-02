package com.thinkenterprise.domain.employee;

import com.thinkenterprise.domain.core.AbstractEntity;

public class Employee extends AbstractEntity {

    private String staffNumber;
    private String lastName;
    private String firstName;

    private Role role;


    public Employee() {
        super();
    }

    public Employee(String staffNumber) {
        super();
        this.staffNumber = staffNumber;
    }

    public Employee(String staffNumber, String firstName, String lastName) {
        super();
        this.staffNumber = staffNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
