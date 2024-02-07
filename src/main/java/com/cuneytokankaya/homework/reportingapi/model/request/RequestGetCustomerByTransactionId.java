package com.cuneytokankaya.homework.reportingapi.model.request;

import lombok.Data;

@Data
public class RequestGetCustomerByTransactionId {
    private String transactionId;
}
