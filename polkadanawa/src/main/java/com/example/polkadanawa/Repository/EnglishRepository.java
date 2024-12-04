package com.example.polkadanawa.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.polkadanawa.Model.English;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EnglishRepository extends MongoRepository<English, String> {
    List<English> findByTopic(String topic);
    English findByKey(String key);
}
