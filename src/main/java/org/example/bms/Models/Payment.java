package org.example.bms.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.example.bms.Models.Enums.PaymentMode;
import org.example.bms.Models.Enums.PaymentStatus;

@Getter
@Setter
@Entity

public class Payment extends BaseModel{

    private int amount;
    private String transactionID;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;

    @OneToOne
    private Ticket ticket;
}
