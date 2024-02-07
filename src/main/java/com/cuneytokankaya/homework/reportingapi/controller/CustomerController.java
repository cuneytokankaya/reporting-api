package com.cuneytokankaya.homework.reportingapi.controller;

import com.cuneytokankaya.homework.reportingapi.model.request.RequestGetCustomerByTransactionId;
import com.cuneytokankaya.homework.reportingapi.model.response.ResponseError;
import com.cuneytokankaya.homework.reportingapi.model.response.ResponseGetCustomerByTransactionId;
import com.cuneytokankaya.homework.reportingapi.model.response.ResponseGetTransactionData;
import com.cuneytokankaya.homework.reportingapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3/client")
public class CustomerController {

    @Autowired
    public TransactionService transactionService;

    @PostMapping
    public ResponseEntity getCustomerByTransactionId(@RequestBody RequestGetCustomerByTransactionId requestGetCustomerByTransactionId)
    {
        try {
            ResponseGetTransactionData response =  transactionService.getTransactionById(requestGetCustomerByTransactionId.getTransactionId());
            ResponseGetCustomerByTransactionId responseGetCustomerByTransactionId = new ResponseGetCustomerByTransactionId();
            if(response != null)
            {
                responseGetCustomerByTransactionId.setCustomer(response.getCustomer());
            }

            return ResponseEntity.ok(responseGetCustomerByTransactionId);
        }catch (Exception e){
            ResponseError responseError = new ResponseError(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
        }
    }
}
