package com.sachin.travelservice.repo;

import com.sachin.travelservice.entity.Travel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TravelRepo extends MongoRepository<Travel, String> {
    Travel findByUserId(String userId);
    Travel findByHotelStaysHotelStayId(String hotelStayId);
    List<Travel> findAllByHotelStaysHotelStayStartDateBetween(
            LocalDate startDate,
            LocalDate endDate
    );
    List<Travel> findAllByHotelStaysHotelStayEndDateBetween(
            LocalDate startDate,
            LocalDate endDate
    );
}
