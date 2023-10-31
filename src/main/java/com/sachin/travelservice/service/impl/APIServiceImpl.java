package com.sachin.travelservice.service.impl;

import com.sachin.travelservice.dto.UserDTO;
import com.sachin.travelservice.dto.fulldetail.HotelDTO;
import com.sachin.travelservice.dto.fulldetail.HotelStayFullDetailDto;
import com.sachin.travelservice.dto.fulldetail.VehicleDTO;
import com.sachin.travelservice.entity.HotelStay;
import com.sachin.travelservice.entity.Travel;
import com.sachin.travelservice.exception.NotFoundException;
import com.sachin.travelservice.repo.TravelRepo;
import com.sachin.travelservice.service.APIService;
import com.sachin.travelservice.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class APIServiceImpl implements APIService {
    private final TravelRepo travelRepo;

    @Override
    public UserDTO getUserDTO(String apiUrl, String travelId) {
        String userId = travelRepo.findById(travelId)
                .orElseThrow(() -> new NotFoundException("Travel with ID " + travelId + " not found")).getUserId();

        WebClient webClient = WebClient.create(apiUrl + userId);
        Mono<StandardResponse<UserDTO>> standardResponseMono = webClient.get()
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
        StandardResponse<UserDTO> block = standardResponseMono.block();
        if (block == null) {
            throw new NotFoundException(userId + " user not found");
        }
        return block.getData();
    }

    @Override
    public List<HotelStayFullDetailDto> getHotelStayDtos(String hotelApiUrl, String travelId) {
        Travel travel = travelRepo.findById(travelId)
                .orElseThrow(() -> new NotFoundException("Travel with ID " + travelId + " not found"));


        List<HotelStay> hotelStays = travel.getHotelStays();

        return hotelStays.stream().map(hotelStay -> {

            String hotelId = hotelStay.getHotelStayHotelId();
            WebClient webClient = WebClient.create(hotelApiUrl + hotelId);
            Mono<StandardResponse<HotelDTO>> standardResponseMono = webClient.get()
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<>() {
                    });
            StandardResponse<HotelDTO> block = standardResponseMono.block();
            if (block == null) {
                throw new NotFoundException(hotelId + " user not found");
            }
            HotelDTO hotelDTO = block.getData();
            return HotelStayFullDetailDto.builder()
                    .hotelDTO(hotelDTO)
                    .travelId(travelId)
                    .hotelStayEndDate(hotelStay.getHotelStayEndDate())
                    .hotelStayStartDate(hotelStay.getHotelStayStartDate())
                    .hotelStayTotalCost(hotelStay.getHotelStayTotalCost()).build();
        }).toList();
    }

    @Override
    public VehicleDTO getVehcileDto(String vehicleApiUrl, String travelId) throws NotFoundException {
        return null;
    }
}
