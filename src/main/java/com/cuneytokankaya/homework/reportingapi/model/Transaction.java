package com.cuneytokankaya.homework.reportingapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Transaction {
    private String transactionId;
    private Date transactionDate;
    private BigDecimal transactionAmount;
    private String transactionCurrency;
    private String ipn;
    private String referenceNo;
    private String status;
    private String channel;
    private String chainId;
    private String operation;
    private String paymentMethod;
    private String code;
    private String message;
    private boolean refundable;
    private String errorCode;
    private Long merchantId;
    private Long customerId;
    private Long acquirerId;
    private Long agentId;
    private Long billingAddressId;
    private Long shippingAddressId;
    private Date createdAt;
    private Date updatedAt;
}
