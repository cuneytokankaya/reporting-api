package com.cuneytokankaya.homework.reportingapi.model.response;

import com.cuneytokankaya.homework.reportingapi.model.Acquirer;
import com.cuneytokankaya.homework.reportingapi.model.Customer;
import com.cuneytokankaya.homework.reportingapi.model.Merchant;
import com.cuneytokankaya.homework.reportingapi.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ResponseGetTransactionData
{
    private Transaction transaction;
    private Customer customer;
    private Merchant merchant;
    private Acquirer acquirer;
}
