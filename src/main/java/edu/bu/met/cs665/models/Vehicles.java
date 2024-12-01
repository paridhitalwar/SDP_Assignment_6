/**
 * Name: Paridhi Talwar
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/27/2024
 * File Name: Vehicles.java
 * Description: This class serves as a base class for different types of vehicles in the delivery system.
 */
package edu.bu.met.cs665.models;

public abstract class Vehicles {

    /**
     * Abstract class representing a Vehicle.
     */
    private String VehiclesType;

    /**
     * Constructor for Vehicle.
     *
     * @param VehiclesType the type of vehicle
     */
    public Vehicles(String VehiclesType) {
        this.VehiclesType = VehiclesType;
    }

    /**
     * Gets the type of the vehicle.
     *
     * @return the vehicle type
     */
    public String getVehiclesType() {
        return VehiclesType;
    }

    @Override
    public String toString() {
        return "Vehicle [VehiclesType=" + VehiclesType + "]";
    }

}
