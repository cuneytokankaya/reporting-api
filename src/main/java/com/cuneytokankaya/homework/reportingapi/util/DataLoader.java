package com.cuneytokankaya.homework.reportingapi.util;

import com.cuneytokankaya.homework.reportingapi.model.Acquirer;
import com.cuneytokankaya.homework.reportingapi.model.Customer;
import com.cuneytokankaya.homework.reportingapi.model.Merchant;
import com.cuneytokankaya.homework.reportingapi.model.Transaction;
import com.cuneytokankaya.homework.reportingapi.repository.AcquirerRepository;
import com.cuneytokankaya.homework.reportingapi.repository.CustomerRepository;
import com.cuneytokankaya.homework.reportingapi.repository.MerchantRepository;
import com.cuneytokankaya.homework.reportingapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private AcquirerRepository acquirerRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        transactionRepository.saveAll(getDummyTransactions());
        merchantRepository.saveAll(getDummyMerchants());
        acquirerRepository.saveAll(getDummyAcquirers());
        customerRepository.saveAll(getDummyCustomers());
    }

    public static List<Merchant> getDummyMerchants()
    {
        Merchant m1 =  new Merchant();
        m1.setName("Ali Kaya");
        m1.setEmail("ali.kaya@email");
        m1.setPassword("ali.kaya");
        m1.setAddress("Istanbul");

        Merchant m2 =  new Merchant();
        m2.setName("Veli Kaya");
        m2.setEmail("veli.kaya@email");
        m2.setPassword("veli.kaya");
        m2.setAddress("Istanbul");

        Merchant m3 =  new Merchant();
        m3.setName("Can Kaya");
        m3.setEmail("can.kaya@email");
        m3.setPassword("can.kaya");
        m3.setAddress("Istanbul");

        Merchant m4=  new Merchant();
        m4.setName("Canan Kaya");
        m4.setEmail("canan.kaya@email");
        m4.setPassword("canan.kaya");
        m4.setAddress("Istanbul");

        Merchant m5=  new Merchant();
        m5.setName("Dilek Kaya");
        m5.setEmail("dilek.kaya@email");
        m5.setPassword("dilek.kaya");
        m5.setAddress("Istanbul");

        return Arrays.asList(m1,m2,m3,m4,m5);
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

    public List<Acquirer> getDummyAcquirers()
    {
        Acquirer a1 = new Acquirer();
        a1.setId(1L);
        a1.setCode("1");
        a1.setName("Acquirer 1");
        a1.setType("1");

        Acquirer a2 = new Acquirer();
        a2.setId(2L);
        a2.setCode("2");
        a2.setName("Acquirer 2");
        a2.setType("2");

        Acquirer a3 = new Acquirer();
        a3.setId(3L);
        a3.setCode("3");
        a3.setName("Acquirer 3");
        a3.setType("3");

        Acquirer a4 = new Acquirer();
        a4.setId(4L);
        a4.setCode("4");
        a4.setName("Acquirer 4");
        a4.setType("4");

        Acquirer a5 = new Acquirer();
        a5.setId(5L);
        a5.setCode("5");
        a5.setName("Acquirer 5");
        a5.setType("5");

        return Arrays.asList(a1,a2,a3,a4,a5);
    }

    public List<Customer> getDummyCustomers()
    {
        Customer c1 = new Customer();
        c1.setNumber("Customer 1");
        c1.setIssueNumber("1");
        c1.setEmail("customer1@email");
        c1.setGender("M");
        c1.setBirthday(new Date());
        c1.setCreatedAt(new Date());

        return Arrays.asList(c1);
    }

}
