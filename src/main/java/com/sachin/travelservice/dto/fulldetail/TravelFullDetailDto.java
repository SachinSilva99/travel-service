package com.sachin.travelservice.dto.fulldetail;

import com.sachin.travelservice.dto.UserDTO;
import com.sachin.travelservice.entity.TravelPackageCategory;
import jakarta.validation.constraints.*;
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
public class TravelFullDetailDto {

    @NotEmpty
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
    @NotNull
    private Boolean isWithPets;

    @NotNull
    private Boolean isWithGuide;
    @NotNull
    private Boolean isCancelled;
    private String guideId;

    @DecimalMin(value = "1.0", message = "Total price Counts must be at least 1.0")
    private double totalPrice;

    @NotNull
    private LocalDate travelPlacedDate;

    @NotEmpty
    private List<HotelStayFullDetailDto> hotelStayDtos;

    @NotEmpty
    private VehicleDTO vehicleDTO;

    @NotEmpty
    private TravelPackageCategory packageCategory;

    @NotEmpty
    private UserDTO userDto;
}
