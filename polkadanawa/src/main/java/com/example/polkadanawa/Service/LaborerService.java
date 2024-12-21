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

    public User registerLaborer(User user, String jobCategory) {
        User savedUser = userRepository.save(user);

        String collectionName = "job_category_" + jobCategory.toLowerCase().replace(" ", "_");
        mongoTemplate.insert(savedUser, collectionName);

        return savedUser;
    }

    public List<User> getLaborersByCategory(String jobCategory) {
        String collectionName = "job_category_" + jobCategory.toLowerCase().replace(" ", "_");
        return mongoTemplate.findAll(User.class, collectionName);
    }

    public void deleteLaborerFromCategory(String userId, String jobCategory) {
        String collectionName = "job_category_" + jobCategory.toLowerCase().replace(" ", "_");

        User laborer = mongoTemplate.findById(userId, User.class, collectionName);
        if (laborer != null) {
            mongoTemplate.remove(laborer, collectionName);
        }

        userRepository.deleteById(userId);
    }
}
