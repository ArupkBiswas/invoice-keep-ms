package com.cyber.invoicekeepms.exception.handler;

import com.cyber.invoicekeepms.exception.GenericResponse;
import com.cyber.invoicekeepms.exception.InputField;
import com.cyber.invoicekeepms.exception.InputFieldResponse;
import com.cyber.invoicekeepms.exception.base.InputFieldException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String INPUT_FILED_EXCEPTION = "InputFieldException";
    private static final String DUPLICATE_RECORD_EXCEPTION = "DuplicateRecordException";

    /**  **/

//    @ExceptionHandler(InputFieldException.class)
//    public final ResponseEntity<Object> duplicateRecordException(InputFieldException ex, WebRequest request) {
//        List<InputField> errorMap = new ArrayList<>();
//
//        errorMap.add(new InputField(ex.getErrorField(), ex.getErrorMessage()));
//
//        InputFieldResponse exceptionResponse = InputFieldResponse.builder()
//                .errors(errorMap)
//                .timestamp(new Date())
//                .errorType(DUPLICATE_RECORD_EXCEPTION)
//                .errorDetails("Record Already Exists in the Database")
//                .build();
//
//        GenericResponse<Object> genericErrorResponse = GenericResponse.builder()
//                .isSuccess(false).
//                data(exceptionResponse).
//                timeStamp(LocalDateTime.now())
//                .errorType(DUPLICATE_RECORD_EXCEPTION)
//                .message("Error during request execution")
//                .build();
//
//        return new ResponseEntity<>(genericErrorResponse, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(InputFieldException.class)
    public final ResponseEntity<Object> inputFieldException(InputFieldException ex, WebRequest request) {
        List<InputField> errorMap = new ArrayList<>();

        errorMap.add(new InputField(ex.getErrorField(), ex.getErrorMessage()));

        InputFieldResponse exceptionResponse = InputFieldResponse.builder()
                .errors(errorMap)
                .timestamp(new Date())
                .errorType(INPUT_FILED_EXCEPTION)
                .errorDetails("Searching parameter not present in the database")
                .build();

        GenericResponse<Object> genericErrorResponse = GenericResponse.builder()
                .isSuccess(false).
                data(exceptionResponse).
                timeStamp(LocalDateTime.now())
                .errorType(INPUT_FILED_EXCEPTION)
                .message("Error during request execution")
                .build();

        return new ResponseEntity<>(genericErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
