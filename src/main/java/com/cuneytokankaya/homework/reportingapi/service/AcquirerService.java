package com.cuneytokankaya.homework.reportingapi.service;

import com.cuneytokankaya.homework.reportingapi.model.Acquirer;
import com.cuneytokankaya.homework.reportingapi.repository.AcquirerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AcquirerService {

    @Autowired
    private AcquirerRepository acquirerRepository;

    public Acquirer getAcquirerById(Long id)
    {
        Optional<Acquirer> acquirer = acquirerRepository.findById(id);

        return acquirer.isPresent() ? acquirer.get() : null;
    }
}

