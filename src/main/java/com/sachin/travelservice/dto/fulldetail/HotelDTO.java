package com.sachin.travelservice.dto.fulldetail;

import com.sachin.travelservice.entity.enums.HotelCategory;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelDTO {

    @NotBlank
    private String hotel_id;

    @NotBlank
    private String hotel_name;

    @NotNull
    private HotelCategory hotelCategory;

    @NotBlank
    private String hotelLocation;

    @NotBlank
    private String hotelLocationCoordinates;

    @Email
    private String hotelEmail;

    @NotBlank
    private String hotelContactNumber;

    @NotNull
    private Boolean isHotelPetsAllowed;

    @NotNull
    private Boolean isHotelCancellationCriteriaFree;

    private double hotelCancellationCost;

    @NotBlank
    private String hotelRemarks;

    @NotEmpty
    private List<String> hotelImagesStrings = new ArrayList<>();

    @NotEmpty
    private List<HotelPackageDTO> hotelPackageDTOS = new ArrayList<>();

}
