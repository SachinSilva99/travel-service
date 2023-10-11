package com.sachin.travelservice.service;

import com.sachin.travelservice.dto.TravelDTO;
import com.sachin.travelservice.exception.NotFoundException;

public interface TravelService {
    String createTravel(TravelDTO travelDTO);

    void updateTravel(String travelId, TravelDTO travelDTO) throws NotFoundException;

    void delete(String travelId) throws NotFoundException;

    TravelDTO getTravel(String travelId);
}
