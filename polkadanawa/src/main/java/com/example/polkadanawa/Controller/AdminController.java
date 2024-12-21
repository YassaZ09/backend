package com.example.polkadanawa.Controller;


import com.example.polkadanawa.Model.*;
import com.example.polkadanawa.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        // Validate fields like nicOrPassport, guardian, etc.
        return adminService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        // Validate and update new fields as needed
        return adminService.updateUser(id, user);
    }



    // User Management
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

//    @PostMapping("/users")
//    public User createUser(@RequestBody User user) {
//        return adminService.createUser(user);
//    }
//
//    @PutMapping("/users/{id}")
//    public User updateUser(@PathVariable String id, @RequestBody User user) {
//        return adminService.updateUser(id, user);
//    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String id) {
        adminService.deleteUser(id);
    }

    // Job Category Management
    @GetMapping("/job-categories")
    public List<JobCategory> getAllJobCategories() {
        return adminService.getAllJobCategories();
    }

    @PostMapping("/job-categories")
    public JobCategory createJobCategory(@RequestBody JobCategory jobCategory) {
        return adminService.createJobCategory(jobCategory);
    }

    @PutMapping("/job-categories/{id}")
    public JobCategory updateJobCategory(@PathVariable String id, @RequestBody JobCategory jobCategory) {
        return adminService.updateJobCategory(id, jobCategory);
    }

    @DeleteMapping("/job-categories/{id}")
    public void deleteJobCategory(@PathVariable String id) {
        adminService.deleteJobCategory(id);
    }

    // Job Management
    @GetMapping("/jobs")
    public List<Job> getAllJobs() {
        return adminService.getAllJobs();
    }

    @DeleteMapping("/jobs/{id}")
    public void deleteJob(@PathVariable String id) {
        adminService.deleteJob(id);
    }

    // Booking Management
    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return adminService.getAllBookings();
    }

    @DeleteMapping("/bookings/{id}")
    public void deleteBooking(@PathVariable String id) {
        adminService.deleteBooking(id);
    }

    // Payment Management
    @GetMapping("/payments")
    public List<Payment> getAllPayments() {
        return adminService.getAllPayments();
    }
}
