package com.cuneytokankaya.homework.reportingapi.service;

//@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {
/*
    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private MerchantRepository merchantRepository;

    @Mock
    AcquirerRepository acquirerRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    void getTransactionsReport() throws Exception
    {

        DateFormat dt = new SimpleDateFormat("yyyy-MM-dd");

        List<Transaction> dummyTransactions =
                TransactionDataUtil.getDummyTransactions().stream()
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
        List<Transaction> dummyTransactions = TransactionDataUtil.getDummyTransactions();

        when(transactionRepository.getTransactionList(null,null,null,null,null,null,null,null,null,null,1))
                .thenReturn(dummyTransactions);

        RequestGetTransactionList requestGetTransactionList = new RequestGetTransactionList(null,null,null,null,null,null,null,null,null,null,1);
        ResponseGetTransactionList responseGetTransactionList = transactionService.getTransactionList(requestGetTransactionList);

        assertEquals(dummyTransactions.size(),responseGetTransactionList.getData().size());
        verify(transactionRepository,times(1)).getTransactionList(null,null,null,null,null,null,null,null,null,null,1);
    }

    @Test
    void getTransactionById() throws Exception
    {
        Transaction dummyTransaction = TransactionDataUtil.getDummyTransactions().stream()
                .filter(transaction -> transaction.getTransactionId().equals("1"))
                .findAny().get();

        when(transactionRepository.findByTransactionId("1")).thenReturn(dummyTransaction);

        ResponseGetTransactionData responseGetTransactionData = transactionService.getTransactionById("1");

        assertEquals(responseGetTransactionData.getTransaction().getTransactionId(),dummyTransaction.getTransactionId());
        verify(transactionRepository,times(1)).findByTransactionId("1");
    }

 */
}