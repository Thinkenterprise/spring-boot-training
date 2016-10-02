package com.thinkenterprise.domain.employee;

public interface EmployeeRepository {

    Employee findByStaffNumber(String staffNumber);
}
