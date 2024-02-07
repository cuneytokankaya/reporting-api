package com.cuneytokankaya.homework.reportingapi.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ResponseError {
    HttpStatus status;
    String message;
}
