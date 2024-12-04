package com.example.polkadanawa.Service;

import com.example.polkadanawa.Model.*;
import com.example.polkadanawa.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    // User Management
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        existingUser.setRole(user.getRole());
        return userRepository.save(existingUser);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    // Job Category Management
    public List<JobCategory> getAllJobCategories() {
        return jobCategoryRepository.findAll();
    }

    public JobCategory createJobCategory(JobCategory jobCategory) {
        // Save Job Category in the main collection
        JobCategory savedCategory = jobCategoryRepository.save(jobCategory);

        // Generate a dynamic table (collection) name
        String dynamicTableName = "job_category_" + savedCategory.getName().toLowerCase().replace(" ", "_");
        savedCategory.setTableName(dynamicTableName);

        // Create the dynamic collection in MongoDB
        if (!mongoTemplate.collectionExists(dynamicTableName)) {
            mongoTemplate.createCollection(dynamicTableName);
        }

        return jobCategoryRepository.save(savedCategory);
    }

    public JobCategory updateJobCategory(String id, JobCategory jobCategory) {
        JobCategory existingCategory = jobCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        existingCategory.setName(jobCategory.getName());
        existingCategory.setDescription(jobCategory.getDescription());
        return jobCategoryRepository.save(existingCategory);
    }

    public void deleteJobCategory(String id) {
        JobCategory category = jobCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Drop the dynamic collection if it exists
        if (mongoTemplate.collectionExists(category.getTableName())) {
            mongoTemplate.dropCollection(category.getTableName());
        }

        jobCategoryRepository.deleteById(id);
    }

    // Job Management
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job createJob(Job job, String categoryId) {
        // Ensure the category exists
        JobCategory category = jobCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Set the category ID
        job.setCategoryId(category.getId());
        return jobRepository.save(job);
    }

    public List<Object> getJobsByCategory(String categoryId) {
        // Ensure the category exists
        JobCategory category = jobCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Fetch jobs from the category's dynamic table
        return mongoTemplate.findAll(Object.class, category.getTableName());
    }

    public void deleteJob(String id) {
        jobRepository.deleteById(id);
    }

    // Booking Management
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public void deleteBooking(String id) {
        bookingRepository.deleteById(id);
    }

    // Payment Management
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
