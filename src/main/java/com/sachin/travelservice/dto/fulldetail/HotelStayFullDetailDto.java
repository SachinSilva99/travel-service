package com.sachin.travelservice.dto.fulldetail;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class HotelStayFullDetailDto {
    @NotBlank
    private HotelDTO hotelDTO;

    @NotBlank
    private String travelId;
    @NotBlank
    private LocalDate hotelStayStartDate;
    @NotBlank
    private LocalDate hotelStayEndDate;
    @NotBlank
    private double hotelStayTotalCost;
}
