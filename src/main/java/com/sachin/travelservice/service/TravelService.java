package com.sachin.travelservice.service;

import com.sachin.travelservice.dto.TravelDTO;

public interface TravelService {
    String createTravel(TravelDTO travelDTO);

    void updateTravel(String travelId, TravelDTO travelDTO);
}
