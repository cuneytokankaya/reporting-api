package com.cuneytokankaya.homework.reportingapi.controller;

import com.cuneytokankaya.homework.reportingapi.model.request.RequestGetTransactionsReport;
import com.cuneytokankaya.homework.reportingapi.model.response.ResponseError;
import com.cuneytokankaya.homework.reportingapi.model.response.ResponseGetTransactionsReport;
import com.cuneytokankaya.homework.reportingapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3/transactions")
public class TransactionsController {

    @Autowired
    public TransactionService transactionService;

    @PostMapping("/report")
    public ResponseEntity getTransactionsReport(@Validated @RequestBody RequestGetTransactionsReport requestReport)
    {
        try {
            ResponseGetTransactionsReport response =  transactionService.getTransactionsReport(requestReport);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            ResponseError responseError = new ResponseError(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
        }
    }
}
