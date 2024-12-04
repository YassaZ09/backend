package com.example.polkadanawa.Repository;

import com.example.polkadanawa.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
    List<User> findByRole(String role); // To filter customers or laborers
    // Find laborers by availability and location (optional use case)
    List<User> findByRoleAndIsAvailable(String role, boolean isAvailable);

    // Find laborers by role and category (location in this case)
    List<User> findByRoleAndLocation(String role, String location);
}