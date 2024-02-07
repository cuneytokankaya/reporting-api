package com.cuneytokankaya.homework.reportingapi.repository;

import com.cuneytokankaya.homework.reportingapi.model.Transaction;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class TransactionRepository {

    public Transaction getTransactionById(String transactionId) throws Exception
    {
        List<Transaction> dummyTransactions = getDummyTransactions();
        Optional<Transaction> filteredTransaction = dummyTransactions.stream()
                .filter(transaction -> transaction.getTransactionId().equals(transactionId))
                .findAny();

        return filteredTransaction.isPresent() ? filteredTransaction.get() : null;
    }

    public List<Transaction> getTransactionsReport(Date startDate, Date endDate, Long acquirerId, Long merchantId) throws Exception
    {
        List<Transaction> dummyTransactions = getDummyTransactions();

        return dummyTransactions
                .stream()
                .filter(transaction ->
                           transaction.getTransactionDate().getTime() >= startDate.getTime()
                        && transaction.getTransactionDate().getTime() <= endDate.getTime()
                        && transaction.getAcquirerId() == (acquirerId == null ? transaction.getAcquirerId() : acquirerId)
                        && transaction.getMerchantId() == (merchantId == null ? transaction.getMerchantId() : merchantId)
                ).collect(Collectors.toList());
    }

    public List<Transaction> getTransactionList(Date fromDate,
                                                Date toDate,
                                                String status,
                                                String operation,
                                                Long merchantId,
                                                Long acquirerId,
                                                String paymentMethod,
                                                String errorCode,
                                                String filterField,
                                                String filterValue,
                                                int page) throws Exception
    {
        List<Transaction> dummyTransactions = getDummyTransactions();

        return dummyTransactions
                .stream()
                .filter(transaction ->
                                   transaction.getTransactionDate().getTime() >= (fromDate == null ? Double.MIN_VALUE : fromDate.getTime())
                                && transaction.getTransactionDate().getTime() <= (toDate == null ? Double.MAX_VALUE : toDate.getTime())
                                && transaction.getAcquirerId() == (acquirerId == null ? transaction.getAcquirerId() : acquirerId)
                                && transaction.getMerchantId() == (merchantId == null ? transaction.getMerchantId() : merchantId)
                                && transaction.getStatus().equals(status == null ? transaction.getStatus() : status)
                                && transaction.getOperation().equals(operation == null ? transaction.getOperation() : operation)
                                && transaction.getPaymentMethod().equals(paymentMethod == null ? transaction.getPaymentMethod() : paymentMethod)
                                && transaction.getErrorCode().equals(errorCode == null ? transaction.getErrorCode() : errorCode)
                )
                .skip((page-1)*2)
                .limit(2)
                .collect(Collectors.toList());
    }

    private List<Transaction> getDummyTransactions() throws  Exception
    {
        DateFormat dt = new SimpleDateFormat("yyyy-MM-dd");

        Transaction t1 = new Transaction();
        t1.setTransactionId("1");
        t1.setTransactionDate(dt.parse("2024-02-01"));
        t1.setTransactionAmount(new BigDecimal("100"));
        t1.setTransactionCurrency("EUR");
        t1.setIpn("true");
        t1.setReferenceNo("123456");
        t1.setStatus("WAITING");
        t1.setChannel("CREDITCARD");
        t1.setPaymentMethod("CREDITCARD");
        t1.setChainId("123");
        t1.setOperation("DIRECT");
        t1.setCode("10");
        t1.setMessage("MESSAGE");
        t1.setRefundable(true);
        t1.setErrorCode("1");
        t1.setMerchantId(1L);
        t1.setCustomerId(1L);
        t1.setAcquirerId(1L);
        t1.setAgentId(1L);
        t1.setBillingAddressId(1L);
        t1.setShippingAddressId(1L);
        t1.setCreatedAt(new Date());
        t1.setUpdatedAt(new Date());

        Transaction t2 = new Transaction();
        t2.setTransactionId("2");
        t2.setTransactionDate(dt.parse("2024-02-02"));
        t2.setTransactionAmount(new BigDecimal("200"));
        t2.setTransactionCurrency("USD");
        t2.setIpn("true");
        t2.setReferenceNo("223456");
        t2.setStatus("WAITING");
        t2.setChannel("CREDITCARD");
        t2.setPaymentMethod("CREDITCARD");
        t2.setChainId("223");
        t2.setOperation("DIRECT");
        t2.setCode("20");
        t2.setMessage("MESSAGE");
        t2.setRefundable(true);
        t2.setErrorCode("2");
        t2.setMerchantId(2L);
        t2.setCustomerId(2L);
        t2.setAcquirerId(2L);
        t2.setAgentId(2L);
        t2.setBillingAddressId(2L);
        t2.setShippingAddressId(2L);
        t2.setCreatedAt(new Date());
        t2.setUpdatedAt(new Date());

        Transaction t3 = new Transaction();
        t3.setTransactionId("3");
        t3.setTransactionDate(dt.parse("2024-02-03"));
        t3.setTransactionAmount(new BigDecimal("300"));
        t3.setTransactionCurrency("GBP");
        t3.setIpn("true");
        t3.setReferenceNo("323456");
        t3.setStatus("WAITING");
        t3.setChannel("CREDITCARD");
        t3.setPaymentMethod("CREDITCARD");
        t3.setChainId("323");
        t3.setOperation("DIRECT");
        t3.setCode("30");
        t3.setMessage("MESSAGE");
        t3.setRefundable(true);
        t3.setErrorCode("3");
        t3.setMerchantId(3L);
        t3.setCustomerId(3L);
        t3.setAcquirerId(3L);
        t3.setAgentId(3L);
        t3.setBillingAddressId(3L);
        t3.setShippingAddressId(3L);
        t3.setCreatedAt(new Date());
        t3.setUpdatedAt(new Date());

        Transaction t4 = new Transaction();
        t4.setTransactionId("4");
        t4.setTransactionDate(dt.parse("2024-02-04"));
        t4.setTransactionAmount(new BigDecimal("400"));
        t4.setTransactionCurrency("GBP");
        t4.setIpn("true");
        t4.setReferenceNo("423456");
        t4.setStatus("WAITING");
        t4.setChannel("CREDITCARD");
        t4.setPaymentMethod("CREDITCARD");
        t4.setChainId("423");
        t4.setOperation("DIRECT");
        t4.setCode("40");
        t4.setMessage("MESSAGE");
        t4.setRefundable(true);
        t4.setErrorCode("4");
        t4.setMerchantId(4L);
        t4.setCustomerId(4L);
        t4.setAcquirerId(4L);
        t4.setAgentId(4L);
        t4.setBillingAddressId(4L);
        t4.setShippingAddressId(4L);
        t4.setCreatedAt(new Date());
        t4.setUpdatedAt(new Date());

        Transaction t5 = new Transaction();
        t5.setTransactionId("5");
        t5.setTransactionDate(dt.parse("2024-02-05"));
        t5.setTransactionAmount(new BigDecimal("500"));
        t5.setTransactionCurrency("USD");
        t5.setIpn("true");
        t5.setReferenceNo("523456");
        t5.setStatus("WAITING");
        t5.setChannel("CREDITCARD");
        t5.setPaymentMethod("CREDITCARD");
        t5.setChainId("523");
        t5.setOperation("DIRECT");
        t5.setCode("50");
        t5.setMessage("MESSAGE");
        t5.setRefundable(true);
        t5.setErrorCode("5");
        t5.setMerchantId(5L);
        t5.setCustomerId(5L);
        t5.setAcquirerId(5L);
        t5.setAgentId(5L);
        t5.setBillingAddressId(5L);
        t5.setShippingAddressId(5L);
        t5.setCreatedAt(new Date());
        t5.setUpdatedAt(new Date());

        return Arrays.asList(
                t1,t2,t3,t4,t5
        );
    }

}
