package com.sachin.travelservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sachin.travelservice.validations.GuideIdRequired;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@GuideIdRequired
public class TravelDTO {
    @JsonIgnore
    private String travelId;
    @FutureOrPresent
    private LocalDate startDate;
    @FutureOrPresent
    private LocalDate endDate;
    @NotEmpty(message = "Travel areas cannot be empty")
    private List<String> travelAreas;
    @NotEmpty(message = "hotels cannot be empty")
    private List<String> hotels;
    @Min(value = 1, message = "The number of adults must be at least 1")
    private int noOfAdults;
    @Min(value = 0, message = "The number of children must be 0 or greater than 0")
    private int noOfChildren;
    @Min(value = 1, message = "Total Head Counts must be at least 1")
    private int totalHeadCount;
    private Boolean isWithPets;
    private Boolean isWithGuide;
    private Boolean isCancelled;
    private String guideId;
    private double totalPrice;
    private List<String> hotelStayIds;
    private String vehicleId;
    private String packageCategoryId;
    private String userId;
}
