package com.thinkenterprise.domain.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
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
