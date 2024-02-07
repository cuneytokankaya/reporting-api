package com.cuneytokankaya.homework.reportingapi.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestLogin {
    private String email;
    private String password;
}
