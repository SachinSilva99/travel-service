package com.sachin.travelservice.service;

import com.sachin.travelservice.dto.HotelStayDto;
import com.sachin.travelservice.dto.TravelDTO;
import com.sachin.travelservice.entity.HotelStay;
import com.sachin.travelservice.entity.Travel;
import com.sachin.travelservice.exception.NotFoundException;
import com.sachin.travelservice.exception.UpdateNotAllowedException;
import com.sachin.travelservice.repo.HotelStayRepo;
import com.sachin.travelservice.repo.TravelRepo;
import com.sachin.travelservice.util.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TravelServiceImpl implements TravelService {
    private final TravelRepo travelRepo;
    private final HotelStayRepo hotelStayRepo;
    private final Mapper mapper;

    @Override
    public String createTravel(TravelDTO travelDTO) {
        Travel travel = mapper.toTravel(travelDTO);
        List<HotelStay> hotelStays = travelDTO.getHotelStayDtos().stream()
                .map(mapper::toHotelStay).toList();
        travel.setHotelStays(hotelStays);
        hotelStayRepo.saveAll(hotelStays);
        return travelRepo.save(travel).getTravelId();
    }

    @Override
    public void updateTravel(String travelId, TravelDTO travelDTO) {


        Travel existingTravel = travelRepo.findById(travelId)
                .orElseThrow(() -> new NotFoundException("Travel with ID " + travelId + " not found"));

        LocalDateTime currentDateTime = LocalDateTime.now();

        long hoursDifference = ChronoUnit.HOURS.between(travelDTO.getTravelPlacedDate(), currentDateTime);


        if (hoursDifference > 48) {
            throw new UpdateNotAllowedException("Update is not allowed because the travel was placed more than 48 hours ago.");
        }
        existingTravel.setStartDate(travelDTO.getStartDate());
        existingTravel.setEndDate(travelDTO.getEndDate());
        existingTravel.setNoOfAdults(travelDTO.getNoOfAdults());
        existingTravel.setNoOfChildren(travelDTO.getNoOfChildren());
        existingTravel.setTotalHeadCount(travelDTO.getTotalHeadCount());
        existingTravel.setIsWithPets(travelDTO.getIsWithPets());
        existingTravel.setIsWithGuide(travelDTO.getIsWithGuide());
        existingTravel.setIsCancelled(travelDTO.getIsCancelled());
        existingTravel.setTotalPrice(travelDTO.getTotalPrice());
        existingTravel.setTravelAreas(travelDTO.getTravelAreas());
        existingTravel.setVehicleId(travelDTO.getVehicleId());
        existingTravel.setUserId(travelDTO.getUserId());
        existingTravel.setGuideId(travelDTO.getGuideId());
        existingTravel.setPackageCategory(travelDTO.getPackageCategory());

        List<HotelStay> hotelStays = travelDTO.getHotelStayDtos().stream()
                .map(dto -> {
                    HotelStay hotelStay = mapper.toHotelStay(dto);
                    hotelStay.setTravelId(travelId);
                    return hotelStay;
                }).toList();
        existingTravel.setHotelStays(hotelStays);

        travelRepo.save(existingTravel);
    }

    @Override
    public void delete(String travelId) throws NotFoundException {
        Travel travel = travelRepo.findById(travelId)
                .orElseThrow(() -> new NotFoundException("Travel with ID " + travelId + " not found"));

        hotelStayRepo.deleteAll(travel.getHotelStays());
        travelRepo.delete(travel);
    }

    @Override
    public TravelDTO getTravel(String travelId) {
        Travel travel = travelRepo.findById(travelId)
                .orElseThrow(() -> new NotFoundException("Travel with ID " + travelId + " not found"));
        List<HotelStayDto> hotelStayDtos = travel.getHotelStays().stream().map(mapper::toHotelStayDto).toList();
        TravelDTO travelDto = mapper.toTravelDto(travel);
        travelDto.setHotelStayDtos(hotelStayDtos);
        return travelDto;
    }

}
