package com.example.polkadanawa.Repository;

import com.example.polkadanawa.Model.JobCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobCategoryRepository extends MongoRepository<JobCategory, String> {
}
