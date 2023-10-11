package com.sachin.travelservice.dto.fulldetail;


import com.sachin.travelservice.dto.enums.vehicle.VehicleCategory;
import com.sachin.travelservice.dto.enums.vehicle.VehicleFuelType;
import com.sachin.travelservice.dto.enums.vehicle.VehicleTransmission;
import com.sachin.travelservice.dto.enums.vehicle.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VehicleDTO {

    private String vehicleId;

    private String vehicleBrand;

    private VehicleCategory vehicleCategory;

    private VehicleFuelType vehicleFuelType;

    private double vehicleFuelConsumption;

    private Boolean vehicleIsHybrid;

    private int vehicleNoOfSeats;

    private VehicleType vehicleType;

    private VehicleTransmission vehicleTransmission;

    private String vehicleRemarks;

    private List<String> vehicleImagesStrings = new ArrayList<>();
}
