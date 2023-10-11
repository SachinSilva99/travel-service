package com.sachin.travelservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sachin.travelservice.entity.TravelPackageCategory;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TravelDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String travelId;
    @FutureOrPresent
    private LocalDate startDate;
    @FutureOrPresent
    private LocalDate endDate;
    @NotEmpty(message = "Travel areas cannot be empty")
    private List<String> travelAreas;

    @Min(value = 1, message = "The number of adults must be at least 1")
    private int noOfAdults;
    @Min(value = 0, message = "The number of children must be 0 or greater than 0")
    private int noOfChildren;
    @Min(value = 1, message = "Total Head Counts must be at least 1")
    private int totalHeadCount;
    private Boolean isWithPets;
    @NotNull
    private Boolean isWithGuide;
    @NotNull
    private Boolean isCancelled;
    private String guideId;
    private double totalPrice;
    @NotNull
    private LocalDate travelPlacedDate;
    @NotEmpty
    private List<HotelStayDto> hotelStayDtos;

    @NotEmpty
    private String vehicleId;

    @NotEmpty
    private TravelPackageCategory packageCategory;
    @NotEmpty
    private String userId;
}
