package com.sachin.travelservice.entity;

import com.sachin.travelservice.entity.enums.HotelCategory;
import com.sachin.travelservice.entity.enums.PackageCategory;
import com.sachin.travelservice.entity.enums.VehicleCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class PackageCategoryDetail {
    @Id
    // this id will be used in reference of PackageCategoryDetail
    private String PackageCategoryDetailId;
    private PackageCategory packageCategory;
    private HotelCategory hotelCategory;
    private VehicleCategory vehicleCategory;
}
