package com.cuneytokankaya.homework.reportingapi.repository;

import com.cuneytokankaya.homework.reportingapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
