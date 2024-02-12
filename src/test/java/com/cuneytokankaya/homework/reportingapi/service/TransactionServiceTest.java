package com.cuneytokankaya.homework.reportingapi.service;

import com.cuneytokankaya.homework.reportingapi.model.Transaction;
import com.cuneytokankaya.homework.reportingapi.model.request.RequestGetTransactionList;
import com.cuneytokankaya.homework.reportingapi.model.request.RequestGetTransactionsReport;
import com.cuneytokankaya.homework.reportingapi.model.response.ResponseGetTransactionData;
import com.cuneytokankaya.homework.reportingapi.model.response.ResponseGetTransactionList;
import com.cuneytokankaya.homework.reportingapi.model.response.ResponseGetTransactionsReport;
import com.cuneytokankaya.homework.reportingapi.repository.AcquirerRepository;
import com.cuneytokankaya.homework.reportingapi.repository.CustomerRepository;
import com.cuneytokankaya.homework.reportingapi.repository.MerchantRepository;
import com.cuneytokankaya.homework.reportingapi.repository.TransactionRepository;
import com.cuneytokankaya.homework.reportingapi.util.DataLoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {
    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private MerchantRepository merchantRepository;

    @Mock
    private AcquirerRepository acquirerRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    void getTransactionsReport() throws Exception
    {
        DateFormat dt = new SimpleDateFormat("yyyy-MM-dd");

        List<Transaction> dummyTransactions =
                DataLoader.getDummyTransactions().stream()
                        .filter(transaction -> transaction.getMerchantId() == 1L
                        && transaction.getAcquirerId() == 1L)
                        .collect(Collectors.toList());

        RequestGetTransactionsReport requestGetTransactionsReport =
                new RequestGetTransactionsReport(dt.parse("2024-02-01"),dt.parse("2024-02-10"),1L,1L);

        when(transactionRepository.getTransactionsReport(dt.parse("2024-02-01"),dt.parse("2024-02-10"),1L,1L))
                .thenReturn(dummyTransactions);

        ResponseGetTransactionsReport responseGetTransactionsReport =
                transactionService.getTransactionsReport(requestGetTransactionsReport);

        assertEquals(dummyTransactions.size(), responseGetTransactionsReport.getResponse().get(0).getCount());
        verify(transactionRepository, times(1)).getTransactionsReport(dt.parse("2024-02-01"),dt.parse("2024-02-10"),1L,1L);
    }

    @Test
    void getTransactionList() throws Exception
    {
        List<Transaction> dummyTransactions = DataLoader.getDummyTransactions();

        when(transactionRepository.getTransactionList(null,null,null,null,null,null,null,null))
                .thenReturn(dummyTransactions);

        RequestGetTransactionList requestGetTransactionList = new RequestGetTransactionList(null,null,null,null,null,null,null,null,null,null,1);
        ResponseGetTransactionList responseGetTransactionList = transactionService.getTransactionList(requestGetTransactionList);

        assertEquals(dummyTransactions.size(),responseGetTransactionList.getData().size());
        verify(transactionRepository,times(1)).getTransactionList(null,null,null,null,null,null,null,null);
    }

    @Test
    void getTransactionById() throws Exception
    {
        Transaction dummyTransaction = DataLoader.getDummyTransactions().stream()
                .filter(transaction -> transaction.getTransactionId().equals("1"))
                .findAny().get();

        when(transactionRepository.findByTransactionId("1")).thenReturn(dummyTransaction);

        ResponseGetTransactionData responseGetTransactionData = transactionService.getTransactionById("1");

        assertEquals(responseGetTransactionData.getTransaction().getTransactionId(),dummyTransaction.getTransactionId());
        verify(transactionRepository,times(1)).findByTransactionId("1");
    }
}