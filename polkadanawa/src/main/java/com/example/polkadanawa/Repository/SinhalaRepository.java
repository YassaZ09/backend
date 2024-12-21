package com.example.polkadanawa.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.polkadanawa.Model.Sinhala;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SinhalaRepository extends MongoRepository<Sinhala, String> {
    List<Sinhala> findByTopic(String topic);

}
