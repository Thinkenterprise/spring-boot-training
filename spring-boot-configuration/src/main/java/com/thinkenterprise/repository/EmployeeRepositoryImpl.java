package com.thinkenterprise.repository;

import com.thinkenterprise.domain.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Autowired
    private List<Employee> employeeList;

    @Override
    public Employee findByStaffNumber(String staffNumber) {
        return employeeList.stream().filter(
                employee -> employee.getStaffNumber().equals(staffNumber))
                .findFirst().get();
    }
}
