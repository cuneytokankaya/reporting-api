package com.cuneytokankaya.homework.reportingapi.service;

import com.cuneytokankaya.homework.reportingapi.model.Transaction;
import com.cuneytokankaya.homework.reportingapi.model.request.RequestGetTransactionList;
import com.cuneytokankaya.homework.reportingapi.model.request.RequestGetTransactionsReport;
import com.cuneytokankaya.homework.reportingapi.model.response.*;
import com.cuneytokankaya.homework.reportingapi.repository.AcquirerRepository;
import com.cuneytokankaya.homework.reportingapi.repository.CustomerRepository;
import com.cuneytokankaya.homework.reportingapi.repository.MerchantRepository;
import com.cuneytokankaya.homework.reportingapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    public TransactionRepository transactionRepository;

    @Autowired
    public MerchantRepository merchantRepository;

    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public AcquirerRepository acquirerRepository;

    public ResponseGetTransactionsReport getTransactionsReport(RequestGetTransactionsReport requestGetTransactionsReport)
            throws Exception
    {
        List<Transaction> transactionList = transactionRepository.getTransactionsReport(
                requestGetTransactionsReport.getStartDate(),
                requestGetTransactionsReport.getEndDate(),
                requestGetTransactionsReport.getAcquirerId(),
                requestGetTransactionsReport.getMerchantId()
        );

        ResponseGetTransactionsReport responseGetTransactionsReport = new ResponseGetTransactionsReport();
        if(transactionList != null && transactionList.size()>0)
        {
            List<ResponseGetTransactionsReportItem> responseGetTransactionsReportItems = new ArrayList<>();
            Map<String, List<Transaction>> transactionsByCurrency = transactionList
                                .stream().collect(Collectors.groupingBy(transaction -> transaction.getTransactionCurrency()));

            for (Map.Entry<String,List<Transaction>> transactionsByCurrencyItem: transactionsByCurrency.entrySet())
            {
                responseGetTransactionsReportItems.add(
                        new ResponseGetTransactionsReportItem(
                                transactionsByCurrencyItem.getValue().size(),
                                transactionsByCurrencyItem.getValue().stream()
                                        .map(Transaction::getTransactionAmount)
                                        .reduce(BigDecimal.ZERO,BigDecimal::add),
                                transactionsByCurrencyItem.getKey())
                );
            }
            responseGetTransactionsReport.setResponse(responseGetTransactionsReportItems);
            responseGetTransactionsReport.setStatus("APPROVED");
        }

        return responseGetTransactionsReport;
    }

    public ResponseGetTransactionList getTransactionList(RequestGetTransactionList requestGetTransactionList) throws Exception {

        List<Transaction> transactionList = transactionRepository.getTransactionList(
                requestGetTransactionList.getFromDate(),
                requestGetTransactionList.getToDate(),
                requestGetTransactionList.getStatus(),
                requestGetTransactionList.getOperation(),
                requestGetTransactionList.getMerchantId(),
                requestGetTransactionList.getAcquirerId(),
                requestGetTransactionList.getPaymentMethod(),
                requestGetTransactionList.getErrorCode(),
                requestGetTransactionList.getFilterField(),
                requestGetTransactionList.getFilterValue(),
                requestGetTransactionList.getPage()
        );

        ResponseGetTransactionList responseGetTransactionList = new ResponseGetTransactionList();
        if(transactionList != null && transactionList.size()>0)
        {
            responseGetTransactionList.setCurrentPage(requestGetTransactionList.getPage());
            responseGetTransactionList.setFrom(requestGetTransactionList.getPage() * 2 - 1);
            responseGetTransactionList.setTo(((requestGetTransactionList.getPage()-1) * 2) + transactionList.size());
            responseGetTransactionList.setPerPage(2);

            List<ResponseGetTransactionData> responseGetTransactionDataList = new ArrayList<>();
            for (Transaction transaction: transactionList)
            {
                //TODO : for icinde serviceCall yapiyorum, data source um dummy kayitlar
                ResponseGetTransactionData responseGetTransactionData = getTransactionById(transaction.getTransactionId());
                responseGetTransactionDataList.add(responseGetTransactionData);
            }
            responseGetTransactionList.setData(responseGetTransactionDataList);
        }

        return responseGetTransactionList;
    }

    public ResponseGetTransactionData getTransactionById(String transactionId)
            throws Exception
    {
        Transaction transaction = transactionRepository.getTransactionById(transactionId);

        ResponseGetTransactionData responseGetTransactionData = new ResponseGetTransactionData();
        if(transaction != null )
        {
            //TODO : transaction modeli diğer modellerle iliskili olmalidir
            responseGetTransactionData.setTransaction(transaction);
            responseGetTransactionData.setMerchant(merchantRepository.getMerchantById(transaction.getMerchantId()));
            responseGetTransactionData.setAcquirer(acquirerRepository.getAcquirerById(transaction.getAcquirerId()));
            responseGetTransactionData.setCustomer(customerRepository.getCustomerById(transaction.getCustomerId()));
        }

        return responseGetTransactionData;
    }
}
