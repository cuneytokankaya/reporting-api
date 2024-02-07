package com.cuneytokankaya.homework.reportingapi.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
public class ResponseGetTransactionList
{
    private int perPage;
    private int currentPage;
    private String nextPageUrl;
    private String prevPageUrl;
    private int from;
    private int to;
    private List<ResponseGetTransactionData> data;

}
