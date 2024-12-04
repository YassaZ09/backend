package com.example.polkadanawa.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String role; // "LABORER" or "CUSTOMER"
    private boolean isAvailable; // For laborers
    private double rating; // Average rating for laborers
    private String location; // Live location in lat,lng format


}
