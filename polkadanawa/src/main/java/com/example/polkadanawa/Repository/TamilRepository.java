package com.example.polkadanawa.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.polkadanawa.Model.Tamil;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TamilRepository extends MongoRepository<Tamil, String> {
    List<Tamil> findByTopic(String topic);
    Tamil findByKey(String key);
}
