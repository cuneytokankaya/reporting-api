package com.cuneytokankaya.homework.reportingapi.service;

import com.cuneytokankaya.homework.reportingapi.model.Employee;
import com.cuneytokankaya.homework.reportingapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
}
