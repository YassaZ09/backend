package com.example.polkadanawa.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "jobs")
public class Job {
    @Id
    private String id;
    private String title;
    private String customerId; // Reference to User ID
    private String laborerId; // Reference to User ID (if assigned)
    private String categoryId; // Reference to JobCategory ID
    private String description; // Job details
    private String location; // Job location in lat,lng format
    private String status; // "PENDING", "ASSIGNED", "COMPLETED"
    private double price; // Job price
    private String scheduledTime; // Scheduled time for the job

}
