package com.cuneytokankaya.homework.reportingapi.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ResponseGetTransactionsReportItem
{
    private int count;
    private BigDecimal total;
    private String currency;
}
