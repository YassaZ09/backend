package com.example.polkadanawa.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "bookings")
public class Booking {
    @Id
    private String id;
    private String jobId; // Reference to Job ID
    private String customerId; // Reference to User ID
    private String laborerId; // Reference to User ID
    private String jobCategoryId;
    private String bookingDate;
    private String date;
    private String status; // "CONFIRMED", "CANCELLED", "COMPLETED"
}
