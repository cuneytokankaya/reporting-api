package com.cuneytokankaya.homework.reportingapi.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Merchant {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String address;

    public Merchant(String email,String password){
        this.email =email;
        this.password = password;
    }
}
