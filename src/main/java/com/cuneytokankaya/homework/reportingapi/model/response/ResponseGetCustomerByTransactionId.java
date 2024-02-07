package com.cuneytokankaya.homework.reportingapi.model.response;

import com.cuneytokankaya.homework.reportingapi.model.Customer;
import lombok.Data;

@Data
public class ResponseGetCustomerByTransactionId {
    private Customer customer;
}
