package com.cuneytokankaya.homework.reportingapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "number")
    private String number;
    @Column(name = "issueNumber")
    private String issueNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private String gender;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "expiryMonth")
    private int expiryMonth;
    @Column(name = "expiryYear")
    private int expiryYear;
    @Column(name = "startMonth")
    private int startMonth;
    @Column(name = "startYear")
    private int startYear;
    @Column(name = "createdAt")
    private Date createdAt;
    @Column(name = "updatedAt")
    private Date updatedAt;
    @Column(name = "deletedAt")
    private Date deletedAt;
    }

