package com.example.polkadanawa.Repository;

import com.example.polkadanawa.Model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository  extends MongoRepository<Job, String> {
    List<Job> findByStatus(String status);
    List<Job> findByCategoryId(String categoryId);
}
