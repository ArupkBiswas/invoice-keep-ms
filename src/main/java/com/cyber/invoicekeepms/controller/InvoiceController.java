package com.cyber.invoicekeepms.controller;

import com.cyber.invoicekeepms.exception.GenericResponse;
import com.cyber.invoicekeepms.exception.base.InputFieldException;
import com.cyber.invoicekeepms.model.request.InvoiceRequest;
import com.cyber.invoicekeepms.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping(value = "/addInvoice", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Object>> addInvoice(@RequestBody InvoiceRequest invoiceRequest) {
        return ResponseEntity.ok(GenericResponse.builder()
                .isSuccess(true)
                .message("Data fetched")
                .timeStamp(LocalDateTime.now())
                .data(invoiceService.addInvoice(invoiceRequest))
                .build());
    }

    @GetMapping(value = "/fetchInvoice/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Object>> fetchInvoiceWithId(@PathVariable("id") final String id) throws InputFieldException {
        return ResponseEntity.ok(GenericResponse.builder()
                .isSuccess(true)
                .message("Data fetched")
                .timeStamp(LocalDateTime.now())
                .data(invoiceService.getInvoiceWithId(id))
                .build());
    }

    @GetMapping(value = "/fetchInvoices", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Object>> fetchAllInvoices() {
        return ResponseEntity.ok(GenericResponse.builder()
                        .isSuccess(true)
                        .message("Data fetched")
                        .timeStamp(LocalDateTime.now())
                        .data(invoiceService.getAllInvoices())
                        .build());
    }
}
