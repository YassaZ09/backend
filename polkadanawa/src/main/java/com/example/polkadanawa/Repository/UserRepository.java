package com.example.polkadanawa.Repository;

import com.example.polkadanawa.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByAttendingLocations(String location);
    List<User> findUsersByAttendingJobs(String categoryId);
}