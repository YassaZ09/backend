
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
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update fields based on the User model
        existingUser.setFirstName(user.getFirstName());
        existingUser.setSecondName(user.getSecondName());
        existingUser.setFullNameWithInitials(user.getFullNameWithInitials());
        existingUser.setPrimaryPhone(user.getPrimaryPhone());
        existingUser.setSecondaryPhone(user.getSecondaryPhone());
        existingUser.setDrivingLicenseNo(user.getDrivingLicenseNo());
        existingUser.setAttendingJobs(user.getAttendingJobs());
        existingUser.setAttendingLocations(user.getAttendingLocations());
        existingUser.setFine(user.getFine());
        existingUser.setGuardian(user.getGuardian());
        existingUser.setTermsAccepted(user.isTermsAccepted());

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
        JobCategory savedCategory = jobCategoryRepository.save(jobCategory);
        String dynamicTableName = "job_category_" + savedCategory.getName().toLowerCase().replace(" ", "_");
        savedCategory.setTableName(dynamicTableName);

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
        JobCategory category = jobCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        job.setCategoryId(category.getId());
        return jobRepository.save(job);
    }

    public List<Object> getJobsByCategory(String categoryId) {
        JobCategory category = jobCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

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