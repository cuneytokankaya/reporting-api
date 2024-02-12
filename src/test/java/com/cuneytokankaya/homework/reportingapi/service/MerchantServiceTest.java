package com.cuneytokankaya.homework.reportingapi.service;

import com.cuneytokankaya.homework.reportingapi.model.Merchant;
import com.cuneytokankaya.homework.reportingapi.repository.MerchantRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MerchantServiceTest {

    @InjectMocks
    private MerchantService merchantService;

    @Mock
    private MerchantRepository merchantRepository;

    @Test
    void getMerchantById()
    {
        Long id = 1L;
        Merchant dummyMerchant = new Merchant();
        dummyMerchant.setId(id);
        dummyMerchant.setName("Test Merchant");
        Optional<Merchant> optionalMerchant = Optional.of(dummyMerchant);

        when(merchantRepository.findById(id)).thenReturn(optionalMerchant);
        Merchant merchant = merchantService.getMerchantById(id);

        assertThat(merchant.getId())
                .isEqualTo(dummyMerchant.getId());
        assertThat(merchant.getName())
                .isEqualTo(dummyMerchant.getName());

        verify(merchantRepository,times(1)).findById(id);
    }

    @Test
    void saveMerchant()
    {
        Long id = 1L;
        Merchant dummyMerchant = new Merchant();
        dummyMerchant.setId(id);
        dummyMerchant.setName("Test Merchant");

        when(merchantRepository.save(dummyMerchant)).thenReturn(dummyMerchant);
        Merchant merchant = merchantService.saveMerchant(dummyMerchant);

        assertThat(merchant.getId())
                .isEqualTo(dummyMerchant.getId());
        assertThat(merchant.getName())
                .isEqualTo(dummyMerchant.getName());

        verify(merchantRepository,times(1)).save(dummyMerchant);
    }
}