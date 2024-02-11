package com.cuneytokankaya.homework.reportingapi.model.response;

import com.cuneytokankaya.homework.reportingapi.model.Merchant;
import lombok.Data;

@Data
public class ResponseGetMerchantById {
    private Merchant merchant;
}
