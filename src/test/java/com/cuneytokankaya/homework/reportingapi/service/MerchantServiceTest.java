package com.cuneytokankaya.homework.reportingapi.service;

import com.cuneytokankaya.homework.reportingapi.repository.MerchantRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MerchantServiceTest {

    @InjectMocks
    private MerchantService merchantService;

    @Mock
    private MerchantRepository merchantRepository;

    /*
    @Test
    void getMerchantById()
    {
        Long id = 1L;
        Merchant merchantDummy = new Merchant();
        merchantDummy.setId(id);
        merchantDummy.setName("Test");

        when(merchantRepository.getMerchantById(id)).thenReturn(merchantDummy);
        Merchant merchant = merchantService.getMerchantById(id);

        assertThat(merchant.getId())
                .isEqualTo(id);
        verify(merchantRepository,times(1)).getMerchantById(id);
    }

     */
}