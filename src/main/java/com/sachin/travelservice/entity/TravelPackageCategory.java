package com.sachin.travelservice.entity;

import com.sachin.travelservice.entity.enums.HotelCategory;
import com.sachin.travelservice.entity.enums.PackageCategory;
import com.sachin.travelservice.entity.enums.VehicleCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TravelPackageCategory {
    private PackageCategory packageCategory;
    private HotelCategory hotelCategory;
    private VehicleCategory vehicleCategory;
}
