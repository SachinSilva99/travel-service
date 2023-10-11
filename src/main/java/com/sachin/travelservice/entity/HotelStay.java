package com.sachin.travelservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class HotelStay {
    @Id
    private String hotelStayId;

    @Field("travelId")
    private String travelId;
    private LocalDate hotelStayStartDate;
    private LocalDate hotelStayEndDate;
    private double hotelStayTotalCost;
    private String hotelId;
}
