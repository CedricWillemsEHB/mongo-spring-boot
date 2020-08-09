package com.opencodez.repository;

import com.opencodez.model.Map;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MapRepository extends MongoRepository<Map, String> {
    Map findFirstByX(int i);
}
