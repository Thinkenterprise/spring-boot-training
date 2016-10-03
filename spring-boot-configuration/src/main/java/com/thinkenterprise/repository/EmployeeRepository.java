package com.thinkenterprise.repository;

import com.thinkenterprise.domain.employee.Employee;

public interface EmployeeRepository {

    Employee findByStaffNumber(String staffNumber);
}
