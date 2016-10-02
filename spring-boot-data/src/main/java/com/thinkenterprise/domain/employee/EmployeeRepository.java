package com.thinkenterprise.domain.employee;

import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Employee findByStaffNumber(String staffNumber);
}
