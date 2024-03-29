package com.cuneytokankaya.homework.reportingapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "acquirer")
@Data
public class Acquirer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    @Column(name = "type")
    private String type;
}
