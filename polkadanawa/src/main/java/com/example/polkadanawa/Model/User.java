package com.example.polkadanawa.Model;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;

    // Personal Details
    private String nicOrPassport;       // NIC or Passport
    private String firstName;           // First Name
    private String secondName;          // Second Name
    private String fullNameWithInitials; // Full Name with initials
    private String dateOfBirth;         // Date of Birth

    // Address
    private String temporaryAddress;    // Temporary Address
    private String permanentAddress;    // Permanent Address

    // Contact Details
    private String primaryPhone;        // Primary TP No.
    private String secondaryPhone;      // Secondary TP No.

    // Job Preferences
    private List<String> attendingJobs; // List of Job IDs (from `jobs` collection)
    private String drivingLicenseNo;    // Driving License Number (optional)

    // Locations and Payment
    private List<String> attendingLocations; // List of attending cities/districts
    private double fine;                 // Fine amount for attending jobs

    // Guardian Details
    private String guardian;            // Guardian's Name and Contact Info as a String

    // Terms and Conditions
    private boolean termsAccepted;      // Acceptance of Terms and Conditions
}
