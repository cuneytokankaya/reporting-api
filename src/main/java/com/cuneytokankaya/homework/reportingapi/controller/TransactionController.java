package com.cuneytokankaya.homework.reportingapi.controller;

import com.cuneytokankaya.homework.reportingapi.model.request.RequestGetTransactionById;
import com.cuneytokankaya.homework.reportingapi.model.request.RequestGetTransactionList;
import com.cuneytokankaya.homework.reportingapi.model.response.ResponseError;
import com.cuneytokankaya.homework.reportingapi.model.response.ResponseGetTransactionData;
import com.cuneytokankaya.homework.reportingapi.model.response.ResponseGetTransactionList;
import com.cuneytokankaya.homework.reportingapi.service.TransactionService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3/transaction")
public class TransactionController
{
    @Autowired
    public TransactionService transactionService;

    @PostMapping("/list")
    public ResponseEntity getTransactionList(@Validated @RequestBody RequestGetTransactionList requestGetTransactionList, @Nullable  @RequestParam Integer page)
    {
        try {
            if(page != null)
                requestGetTransactionList.setPage(page);

            ResponseGetTransactionList response =  transactionService.getTransactionList(requestGetTransactionList);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            ResponseError responseError = new ResponseError(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
        }
    }

    @PostMapping
    public ResponseEntity getTransactionById(@RequestBody RequestGetTransactionById requestGetTransactionById)
    {
        try {
            ResponseGetTransactionData response =  transactionService.getTransactionById(requestGetTransactionById.getTransactionId());
            return ResponseEntity.ok(response);
        }catch (Exception e){
            ResponseError responseError = new ResponseError(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
        }
    }

}
