package com.sachin.travelservice.entity;

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
    private VehicleCategory vehicleCategory;
}
