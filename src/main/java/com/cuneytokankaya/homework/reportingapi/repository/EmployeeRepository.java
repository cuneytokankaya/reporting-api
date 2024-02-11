package com.cuneytokankaya.homework.reportingapi.repository;

import com.cuneytokankaya.homework.reportingapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
