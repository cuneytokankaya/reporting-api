package com.cuneytokankaya.homework.reportingapi.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ResponseLogin {
    private String status;
    private String token;
}
