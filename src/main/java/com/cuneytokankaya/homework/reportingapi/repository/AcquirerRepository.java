package com.cuneytokankaya.homework.reportingapi.repository;

import com.cuneytokankaya.homework.reportingapi.model.Acquirer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcquirerRepository extends JpaRepository<Acquirer,Long> {
}
