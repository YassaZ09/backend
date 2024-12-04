package com.example.polkadanawa.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "job_category_details")
public class JobCategoryDetail {
    @Id
    private String id;
    private String jobTitle;       // Specific job under the category
    private String categoryId;     // Foreign Key from JobCategory
    private String details;
}
