package com.cyber.invoicekeepms.repository.dao;

import com.cyber.invoicekeepms.model.dto.InvoiceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceDTO, String> {
    public List<InvoiceDTO> findAll();
    public List<InvoiceDTO> findByinvId(String invId);

}
