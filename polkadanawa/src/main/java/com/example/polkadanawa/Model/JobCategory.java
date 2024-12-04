package com.example.polkadanawa.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "job_categories")
public class JobCategory {
    @Id
    private String id;
    private String name;        // e.g., Tree Cutting, Plumbing
    private String description; // e.g., Description of the category
    private String tableName;   // Name of the dynamically created table
}
