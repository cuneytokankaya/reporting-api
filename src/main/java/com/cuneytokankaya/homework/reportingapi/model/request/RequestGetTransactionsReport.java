package com.cuneytokankaya.homework.reportingapi.model.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class RequestGetTransactionsReport
{
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;
    private Long merchantId;
    private Long acquirerId;
}
