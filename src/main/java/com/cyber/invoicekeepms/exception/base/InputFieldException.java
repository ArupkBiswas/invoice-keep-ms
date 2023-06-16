package com.cyber.invoicekeepms.exception.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InputFieldException extends Exception{
    private static final long serialVersionUID = 4L;

    private final String errorField;
    private final String errorMessage;
}
