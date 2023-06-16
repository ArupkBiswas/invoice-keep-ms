package com.cyber.invoicekeepms.service;

import com.cyber.invoicekeepms.exception.base.InputFieldException;
import com.cyber.invoicekeepms.model.request.InvoiceRequest;
import com.cyber.invoicekeepms.model.dto.InvoiceDTO;
import com.cyber.invoicekeepms.repository.dao.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    public InvoiceDTO addInvoice(InvoiceRequest invoiceRequest) {
        try{
            InvoiceDTO invoiceDTOList  = InvoiceDTO.builder()
                    .invId(invoiceRequest.getInvId())
                    .clientName(invoiceRequest.getClientName())
                    .clientEmail(invoiceRequest.getClientEmail())
                    .clientAddress(invoiceRequest.getClientAddress())
                    .clientCity(invoiceRequest.getClientCity())
                    .clientPhoneNumber(invoiceRequest.getClientPhoneNumber())
                    .clientPinCode(Integer.valueOf(invoiceRequest.getClientPinCode()))
                    .createdBy(invoiceRequest.getCreatedBy())
                    .createdOn(invoiceRequest.getCreatedOn())
                    .modifiedBy(invoiceRequest.getModifiedBy())
                    .modifiedOn(invoiceRequest.getModifiedOn())
                    .build();

            return invoiceRepository.save(invoiceDTOList);

        } catch (Exception ex) {
            throw new DataIntegrityViolationException(ex.getLocalizedMessage());
        }

    }

    public List<InvoiceDTO> getInvoiceWithId(String id) throws InputFieldException {
        final  List<InvoiceDTO> specificInvoice = invoiceRepository.findByinvId(id);
        if (specificInvoice.isEmpty()) {
            throw new InputFieldException("Invoice Id", "Please enter a valid invoice id");
        }
        else
            return specificInvoice;
    }
    public List<InvoiceDTO> getAllInvoices() {
        return invoiceRepository.findAll();
    }

}
