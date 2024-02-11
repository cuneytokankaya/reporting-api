package com.cuneytokankaya.homework.reportingapi.service;

import com.cuneytokankaya.homework.reportingapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

}
