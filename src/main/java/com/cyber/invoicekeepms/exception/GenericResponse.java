package com.cyber.invoicekeepms.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class GenericResponse<T> {
    Boolean isSuccess;
    String message;
    LocalDateTime timeStamp;
    String errorType;
    T data;
}
