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

    public List<JobCategory> getAllJobCategories() {
        return jobCategoryRepository.findAll();
    }

    public List<User> getUsersByLocation(String location) {
        List<User> users = userRepository.findByAttendingLocations(location);
        if (users.isEmpty()) {
            throw new RuntimeException("No users found for the location: " + location);
        }
        return users;
    }

    public User registerCustomer(User user) {
        // Save user logic
        return userRepository.save(user);
    }
    public List<User> getLaborersByCategory(String categoryId) {
        // Logic to fetch laborers based on job category
        return userRepository.findUsersByAttendingJobs(categoryId);
    }

    public Booking bookLaborer(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByCustomer(String customerId) {
        return bookingRepository.findByCustomerId(customerId);
    }

    public void cancelBooking(String bookingId, String customerId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        if (!booking.getCustomerId().equals(customerId)) {
            throw new RuntimeException("Unauthorized to cancel this booking");
        }

        bookingRepository.deleteById(bookingId);
    }
}
