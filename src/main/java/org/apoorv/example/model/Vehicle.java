package org.apoorv.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apoorv.example.enums.VehicleType;

@Getter
@Setter
@AllArgsConstructor
public class Vehicle {
    private String plateNo;
    private VehicleType vehicleType;
}
