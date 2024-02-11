package com.cuneytokankaya.homework.reportingapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "merchant")
@Data
@NoArgsConstructor
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "address")
    private String address;

    public Merchant(String email,String password){
        this.email =email;
        this.password = password;
    }
}
