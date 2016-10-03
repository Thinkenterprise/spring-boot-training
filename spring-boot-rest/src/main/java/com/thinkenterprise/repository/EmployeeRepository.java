package com.thinkenterprise.repository;

import com.thinkenterprise.domain.employee.Employee;
import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Employee findByStaffNumber(String staffNumber);
}
