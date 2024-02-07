package com.cuneytokankaya.homework.reportingapi.repository;

import com.cuneytokankaya.homework.reportingapi.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository
{
    public Customer getCustomerById(Long id)
    {
        Optional<Customer> filteredCustomer= getDummyCustomers()
                .stream()
                .filter(merchant -> merchant.getId().equals(id))
                .findAny();

        return filteredCustomer.isPresent() ? filteredCustomer.get() : null;
    }

    public List<Customer> getDummyCustomers()
    {
        Customer c1 = new Customer();
        c1.setId(1L);
        c1.setNumber("111");
        c1.setIssueNumber("111");
        c1.setEmail("customer1@email");
        c1.setGender("M");
        c1.setBirthday(new Date());
        c1.setCreatedAt(new Date());

        Customer c2 = new Customer();
        c2.setId(2L);
        c2.setNumber("222");
        c2.setIssueNumber("222");
        c2.setEmail("customer2@email");
        c2.setGender("M");
        c2.setBirthday(new Date());
        c2.setCreatedAt(new Date());

        Customer c3 = new Customer();
        c3.setId(3L);
        c3.setNumber("333");
        c3.setIssueNumber("333");
        c3.setEmail("customer3@email");
        c3.setGender("M");
        c3.setBirthday(new Date());
        c3.setCreatedAt(new Date());

        Customer c4 = new Customer();
        c4.setId(4L);
        c4.setNumber("444");
        c4.setIssueNumber("444");
        c4.setEmail("customer4@email");
        c4.setGender("M");
        c4.setBirthday(new Date());
        c4.setCreatedAt(new Date());

        Customer c5 = new Customer();
        c5.setId(5L);
        c5.setNumber("555");
        c5.setIssueNumber("555");
        c5.setEmail("customer5@email");
        c5.setGender("M");
        c5.setBirthday(new Date());
        c5.setCreatedAt(new Date());

        return Arrays.asList(c1,c2,c3,c4,c5);
    }
}
