package com.cuneytokankaya.homework.reportingapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchantDTO
{
    private Long id;
    private String name;
    private String email;
    private String password;
    private String address;

    public MerchantDTO(String email,String password){
        this.email =email;
        this.password = password;
    }
}

