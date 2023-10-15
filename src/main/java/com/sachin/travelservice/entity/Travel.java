package com.sachin.travelservice.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Travel {

    @Id
    private String travelId;
    @FutureOrPresent
    private LocalDate startDate;
    @FutureOrPresent
    private LocalDate endDate;


    @Min(value = 1, message = "The number of adults must be at least 1")
    private int noOfAdults;
    @Max(value = 10, message = "The number of adults cannot exceed 10")
    private int noOfChildren;
    @Min(value = 1, message = "The total head count must be at least 1")
    private int totalHeadCount;
    @NotNull
    private Boolean isWithPets;
    @NotNull
    private Boolean isWithGuide;
    @NotNull
    private boolean isCancelled;

    private boolean isApprovedByAdmin;

    @NotEmpty
    private String bankSlipImg;

    @DecimalMin(value = "1.0", message = "The total price must be greater than or equal to 1")
    private double travelTotalPrice;

    @NotNull
    private LocalDate travelPlacedDate;

    @DBRef
    private List<HotelStay> hotelStays;

    @DBRef
    private TravelPackageCategory packageCategory;

    @NotEmpty
    private List<String> travelAreas = new ArrayList<>();

    @NotBlank
    private String vehicleId;

    @NotBlank
    private String userId;
    private String guideId;

}

