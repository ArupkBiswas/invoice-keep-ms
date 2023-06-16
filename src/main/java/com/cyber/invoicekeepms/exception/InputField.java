package com.cyber.invoicekeepms.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputField {

    private final String errorField;
    private final String errorMessage;

    public InputField(String errorField, String errorMessage) {
        this.errorField = errorField;
        this.errorMessage = errorMessage;
    }
}
