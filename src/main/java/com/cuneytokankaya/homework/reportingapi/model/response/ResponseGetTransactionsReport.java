package com.cuneytokankaya.homework.reportingapi.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class ResponseGetTransactionsReport
{
    private String status;
    private List<ResponseGetTransactionsReportItem> response;
}
