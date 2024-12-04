package com.example.polkadanawa.Controller;

import com.example.polkadanawa.Model.*;
import com.example.polkadanawa.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Register a customer
    @PostMapping("/register")
    public User registerCustomer(@RequestBody User user) {
        return customerService.registerCustomer(user);
    }

    // Get all job categories
    @GetMapping("/job-categories")
    public List<JobCategory> getAllJobCategories() {
        return customerService.getAllJobCategories();
    }

    // View laborers by job category
    @GetMapping("/laborers/{categoryId}")
    public List<User> getLaborersByCategory(@PathVariable String categoryId) {
        return customerService.getLaborersByCategory(categoryId);
    }

    // Book a laborer
    @PostMapping("/book")
    public Booking bookLaborer(@RequestBody Booking booking) {
        return customerService.bookLaborer(booking);
    }

    // Get customer bookings
    @GetMapping("/{customerId}/bookings")
    public List<Booking> getBookingsByCustomer(@PathVariable String customerId) {
        return customerService.getBookingsByCustomer(customerId);
    }

    // Cancel a booking
    @DeleteMapping("/{customerId}/bookings/{bookingId}")
    public String cancelBooking(@PathVariable String customerId, @PathVariable String bookingId) {
        customerService.cancelBooking(bookingId, customerId);
        return "Booking canceled successfully";
    }
}
