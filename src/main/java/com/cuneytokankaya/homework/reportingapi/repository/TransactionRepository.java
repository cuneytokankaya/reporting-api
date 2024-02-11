package com.cuneytokankaya.homework.reportingapi.repository;

import com.cuneytokankaya.homework.reportingapi.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long>
{
    public Transaction findByTransactionId(String transactionId);

    @Query(value = "select t from Transaction t WHERE " +
            "t.transactionDate >= :startDate " +
            "and t.transactionDate <= :endDate " +
            "and (:acquirerId is null or t.acquirerId = :acquirerId) " +
            "and (:merchantId is null or t.merchantId = :merchantId)")
    public List<Transaction> getTransactionsReport(@Param("startDate") Date startDate,
                                                   @Param("endDate") Date endDate,
                                                   @Param("acquirerId") Long acquirerId,
                                                   @Param("merchantId") Long merchantId);

    @Query(value = "SELECT t FROM Transaction t WHERE 1=1" +
            "and (:fromDate is null or t.transactionDate >= :fromDate) " +
            "and (:toDate is null or t.transactionDate <= :toDate) " +
            "and (:status is null or t.status = :status) " +
            "and (:operation is null or t.operation = :operation) " +
            "and (:merchantId is null or t.merchantId = :merchantId) " +
            "and (:acquirerId is null or t.acquirerId = :acquirerId) " +
            "and (:paymentMethod is null or t.paymentMethod = :paymentMethod) " +
            "and (:errorCode is null or t.errorCode = :errorCode)")
    public List<Transaction> getTransactionList(Date fromDate,
                                                Date toDate,
                                                String status,
                                                String operation,
                                                Long merchantId,
                                                Long acquirerId,
                                                String paymentMethod,
                                                String errorCode);
}
