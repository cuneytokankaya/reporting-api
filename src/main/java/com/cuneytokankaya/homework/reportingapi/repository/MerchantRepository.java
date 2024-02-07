package com.cuneytokankaya.homework.reportingapi.repository;

import com.cuneytokankaya.homework.reportingapi.model.Merchant;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class MerchantRepository {

    public Merchant getMerchantByEmail(String email)
    {
        Optional<Merchant> filteredMerchant = getDummyMerchants()
                .stream()
                .filter(merchant -> merchant.getEmail().equals(email))
                .findAny();

        return filteredMerchant.isPresent() ? filteredMerchant.get() : null;
    }

    public Merchant getMerchantById(Long id)
    {
        Optional<Merchant> filteredMerchant = getDummyMerchants()
                .stream()
                .filter(merchant -> merchant.getId().equals(id))
                .findAny();

        return filteredMerchant.isPresent() ? filteredMerchant.get() : null;
    }

    private List<Merchant> getDummyMerchants()
    {
        Merchant m1 =  new Merchant();
        m1.setId(1L);
        m1.setName("Ali Kaya");
        m1.setEmail("ali.kaya@email");
        m1.setPassword("ali.kaya");
        m1.setAddress("Istanbul");

        Merchant m2 =  new Merchant();
        m2.setId(2L);
        m2.setName("Veli Kaya");
        m2.setEmail("veli.kaya@email");
        m2.setPassword("veli.kaya");
        m2.setAddress("Istanbul");

        Merchant m3 =  new Merchant();
        m3.setId(3L);
        m3.setName("Can Kaya");
        m3.setEmail("can.kaya@email");
        m3.setPassword("can.kaya");
        m3.setAddress("Istanbul");

        Merchant m4=  new Merchant();
        m4.setId(4L);
        m4.setName("Canan Kaya");
        m4.setEmail("canan.kaya@email");
        m4.setPassword("canan.kaya");
        m4.setAddress("Istanbul");

        Merchant m5=  new Merchant();
        m5.setId(4L);
        m5.setName("Dilek Kaya");
        m5.setEmail("dilek.kaya@email");
        m5.setPassword("dilek.kaya");
        m5.setAddress("Istanbul");

        return Arrays.asList(m1,m2,m3,m4,m5);
    }

}
