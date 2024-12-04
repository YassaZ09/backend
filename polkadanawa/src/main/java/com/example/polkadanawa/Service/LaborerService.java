package com.example.polkadanawa.Service;

import com.example.polkadanawa.Model.User;
import com.example.polkadanawa.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaborerService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    // Register a new laborer
    public User registerLaborer(User user, String jobCategory) {
        // Save to general users table
        user.setRole("LABORER");
        User savedUser = userRepository.save(user);

        // Save to the job category-specific table
        String collectionName = "job_category_" + jobCategory.toLowerCase().replace(" ", "_");
        mongoTemplate.insert(savedUser, collectionName);

        return savedUser;
    }

    // Get all laborers for a specific job category
    public List<User> getLaborersByCategory(String jobCategory) {
        String collectionName = "job_category_" + jobCategory.toLowerCase().replace(" ", "_");
        return mongoTemplate.findAll(User.class, collectionName);
    }

    // Delete a laborer from both users and category-specific table
    public void deleteLaborerFromCategory(String userId, String jobCategory) {
        String collectionName = "job_category_" + jobCategory.toLowerCase().replace(" ", "_");

        // Delete from category-specific collection
        User laborer = mongoTemplate.findById(userId, User.class, collectionName);
        if (laborer != null) {
            mongoTemplate.remove(laborer, collectionName);
        }

        // Delete from general users table
        userRepository.deleteById(userId);
    }
}
