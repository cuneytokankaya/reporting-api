package com.cuneytokankaya.homework.reportingapi.service;

import com.cuneytokankaya.homework.reportingapi.model.Merchant;
import com.cuneytokankaya.homework.reportingapi.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {

        @Autowired
        public MerchantRepository merchantRepository;

        public Merchant getMerchantById(Long id)
        {
             return merchantRepository.getMerchantById(id);
        }

}
