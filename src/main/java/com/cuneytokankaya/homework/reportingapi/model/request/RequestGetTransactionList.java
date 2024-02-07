package com.cuneytokankaya.homework.reportingapi.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
@AllArgsConstructor
public class RequestGetTransactionList
{
    private Date fromDate;
    private Date toDate;
    private String status;
    private String operation;
    private Long merchantId;
    private Long acquirerId;
    private String paymentMethod;
    private String errorCode;
    private String filterField;
    private String filterValue;
    private int page;
}
