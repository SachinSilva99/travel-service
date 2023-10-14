package com.sachin.travelservice.dto.fulldetail;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
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
