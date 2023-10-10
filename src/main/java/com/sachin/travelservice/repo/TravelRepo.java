package com.sachin.travelservice.repo;

import com.sachin.travelservice.entity.Travel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepo extends MongoRepository<Travel, String> {
    Travel findByUserId(String userId);
}
