package com.cuneytokankaya.homework.reportingapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "transactionId")
    private String transactionId;
    @Column(name = "transactionDate")
    private Date transactionDate;
    @Column(name = "transactionAmount")
    private BigDecimal transactionAmount;
    @Column(name = "transactionCurrency")
    private String transactionCurrency;
    @Column(name = "ipn")
    private String ipn;
    @Column(name = "referenceNo")
    private String referenceNo;
    @Column(name = "status")
    private String status;
    @Column(name = "channel")
    private String channel;
    @Column(name = "chainId")
    private String chainId;
    @Column(name = "operation")
    private String operation;
    @Column(name = "paymentMethod")
    private String paymentMethod;
    @Column(name = "code")
    private String code;
    @Column(name = "message")
    private String message;
    @Column(name = "refundable")
    private boolean refundable;
    @Column(name = "errorCode")
    private String errorCode;
    @Column(name = "merchantId")
    private Long merchantId;
    @Column(name = "customerId")
    private Long customerId;
    @Column(name = "acquirerId")
    private Long acquirerId;
    @Column(name = "agentId")
    private Long agentId;
    @Column(name = "billingAddressId")
    private Long billingAddressId;
    @Column(name = "shippingAddressId")
    private Long shippingAddressId;
    @Column(name = "createdAt")
    private Date createdAt;
    @Column(name = "updatedAt")
    private Date updatedAt;
}
