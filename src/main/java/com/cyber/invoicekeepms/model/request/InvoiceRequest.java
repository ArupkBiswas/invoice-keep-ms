package com.cyber.invoicekeepms.model.request;

import com.cyber.invoicekeepms.util.ErrorMessages;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceRequest {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invId;
    @NotNull(message = ErrorMessages.CLIENT_NAME_NOT_NULL)
    private String clientName;
    @Pattern(regexp = "^[a-zA-Z0-9.@_]", message = ErrorMessages.INVALID_EMAIL)
    @NotNull(message = ErrorMessages.CLIENT_EMAIL_NOT_NULL)
    private String clientEmail;
    @NotNull(message = ErrorMessages.CLIENT_ADDRESS_NOT_NULL)
    private String clientAddress;
    @NotNull(message = ErrorMessages.CLIENT_CITY_NOT_NULL)
    private String clientCity;
    @NotNull(message = ErrorMessages.CLIENT_PIN_CODE_NOT_NULL)
    private Integer clientPinCode;
    @NotNull(message = ErrorMessages.CLIENT_PHONE_NUMBER_NOT_NULL)
    private String clientPhoneNumber;
    private String createdBy;
    private Timestamp createdOn;
    private String modifiedBy;
    private Timestamp modifiedOn;
}
