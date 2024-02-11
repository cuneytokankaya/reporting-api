package com.cuneytokankaya.homework.reportingapi.service;

import com.cuneytokankaya.homework.reportingapi.model.Merchant;
import com.cuneytokankaya.homework.reportingapi.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MerchantService
{
    @Autowired
    private MerchantRepository merchantRepository;

    public Merchant getMerchantById(Long id)
    {
        Optional<Merchant> merchant = merchantRepository.findById(id);

        return merchant.isPresent() ? merchant.get() : null;
    }

    public Merchant saveMerchant(Merchant merchant)
    {
        return merchantRepository.save(merchant);
    }
}
