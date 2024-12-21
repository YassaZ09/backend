package com.example.polkadanawa.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "reviews")
public class Review {
    @Id
    private String id;
    private String laborerId; // Reference to User ID
    private String customerId; // Reference to User ID
    private String jobId; // Reference to Job ID
    private int rating; // 1 to 5 stars
    private String comments;
    private String reviewDate;
}
