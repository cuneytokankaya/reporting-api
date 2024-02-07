package com.cuneytokankaya.homework.reportingapi.model;

import lombok.Data;

@Data
public class
CustomerAddress {
    private Long id;
    private Long customerId;
    /**
     * BILLING,SHIPPING
     */
    private String type;
    private String title;
    private String firstName;
    private String lastName;
    private String company;
    private String city;
    private String state;
    private String address;
}
