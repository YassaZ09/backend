package com.example.polkadanawa.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "payments")
public class Payment {
    @Id
    private String id;
    private String bookingId; // Reference to Booking ID
    private String paymentMethod; // "CREDIT_CARD", "DEBIT_CARD", "UPI"
    private double amount;
    private String paymentDate;
    private String status; // "SUCCESS", "FAILED"

}
