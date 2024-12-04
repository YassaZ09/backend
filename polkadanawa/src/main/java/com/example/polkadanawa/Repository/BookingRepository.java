package com.example.polkadanawa.Repository;

import com.example.polkadanawa.Model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {
    List<Booking> findByStatus(String status);
    List<Booking> findByCustomerId(String customerId);
}
