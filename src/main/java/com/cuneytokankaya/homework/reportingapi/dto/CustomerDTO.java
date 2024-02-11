package com.cuneytokankaya.homework.reportingapi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerDTO {
    private Long id;
    private String number;
    private String issueNumber;
    private String email;
    private String gender;
    private Date birthday;
    private int expiryMonth;
    private int expiryYear;
    private int startMonth;
    private int startYear;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
}
