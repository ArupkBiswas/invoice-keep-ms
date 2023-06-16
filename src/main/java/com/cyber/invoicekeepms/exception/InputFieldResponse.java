package com.cyber.invoicekeepms.exception;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Builder
public class InputFieldResponse {
    private List<InputField> errors;
    private Date timestamp;
    private String errorType;
    private String errorDetails;
}
