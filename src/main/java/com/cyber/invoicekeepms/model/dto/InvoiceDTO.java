package com.cyber.invoicekeepms.model.dto;

import com.cyber.invoicekeepms.util.ErrorMessages;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serial;
import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="invoice_main", schema= "invoices")
public class InvoiceDTO {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", nullable = false)
    private UUID id;

//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoiceSequence")
//    @SequenceGenerator(name = "invoiceSequence", sequenceName = "inv_id", initialValue = 5, allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inv_id", columnDefinition = "serial", nullable = false)
    private Integer invId;

    @Column(name = "client_name", nullable = false)
    private String clientName;

    //@Pattern(regexp = "^[a-zA-Z0-9.@_]", message = ErrorMessages.INVALID_EMAIL)
    @Column(name = "client_email", nullable = false)
    private String clientEmail;

    @Column(name = "client_address", nullable = false)
    private String clientAddress;

    @Column(name = "client_city", nullable = false)
    private String clientCity;

    @Column(name = "client_pincode", nullable = false)
    private Integer clientPinCode;

    @Column(name = "client_phonenumber", nullable = false)
    private String clientPhoneNumber;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Timestamp createdOn;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_on")
    private Timestamp modifiedOn;

}
