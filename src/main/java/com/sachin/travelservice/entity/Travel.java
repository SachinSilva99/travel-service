package com.sachin.travelservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Travel {
    @Id
    private String travelId;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<String> travelAreas;
    private List<String> hotels;
    private int noOfAdults;
    private int noOfChildren;
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

