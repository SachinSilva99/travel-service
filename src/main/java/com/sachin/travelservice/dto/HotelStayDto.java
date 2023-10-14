package com.sachin.travelservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class HotelStayDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String hotelStayId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String travelId;
    @NotBlank
    private LocalDate hotelStayStartDate;
    @NotBlank
    private LocalDate hotelStayEndDate;
    @NotBlank
    private double hotelStayTotalCost;
    @NotBlank
    private String hotelId;


}
