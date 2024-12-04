package com.example.polkadanawa.Service;

import com.example.polkadanawa.Model.*;
import com.example.polkadanawa.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    @Autowired
    private BookingRepository bookingRepository;

    // Register a new customer
    public User registerCustomer(User user) {
        user.setRole("CUSTOMER");
        return userRepository.save(user);
    }

    // Get all job categories (for customers to choose from)
    public List<JobCategory> getAllJobCategories() {
        return jobCategoryRepository.findAll();
    }

    // View laborers by job category
    public List<User> getLaborersByCategory(String categoryId) {
        JobCategory category = jobCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Job category not found"));

        // Fetch laborers associated with the job category
        return userRepository.findByRoleAndLocation("LABORER", category.getName());
    }


    // Book a laborer
    public Booking bookLaborer(Booking booking) {
        // Ensure the laborer exists
        User laborer = userRepository.findById(booking.getLaborerId())
                .orElseThrow(() -> new RuntimeException("Laborer not found"));

        if (!laborer.getRole().equals("LABORER") || !laborer.isAvailable()) {
            throw new RuntimeException("Laborer is not available");
        }

        // Save the booking
        return bookingRepository.save(booking);
    }

    // Get customer bookings
    public List<Booking> getBookingsByCustomer(String customerId) {
        return bookingRepository.findByCustomerId(customerId);
    }

    // Cancel a booking
    public void cancelBooking(String bookingId, String customerId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        if (!booking.getCustomerId().equals(customerId)) {
            throw new RuntimeException("Unauthorized to cancel this booking");
        }

        bookingRepository.deleteById(bookingId);
    }
}
