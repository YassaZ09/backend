package com.example.polkadanawa.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "notifications")
public class Notification {
    @Id
    private String id;
    private String userId; // Reference to User ID
    private String message;
    private String timestamp;
    private boolean isRead;

}