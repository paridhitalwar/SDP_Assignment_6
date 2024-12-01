/**
 * Name: Paridhi Talwar
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/27/2024
 * File Name: Driver.java
 * Description: This class represents a driver in the delivery system.
 * It implements the Observer interface to receive delivery requests.
 */
package edu.bu.met.cs665.models;

import java.util.Objects;

/**
 * Represents a Driver who observes delivery requests.
 */
public class Driver implements Observer {

    private Vehicles vehicles;
    private int id;

    public Driver(Vehicles vehicle) {
        this.vehicles = vehicle;
        // Generate a unique ID using the IdGenerator singleton
        this.id = IdGenerator.getInstance().generateId();
    }

    // New constructor to accept vehicle and a predefined id
    public Driver(Vehicles vehicle, int id) {
        this.vehicles = vehicle;
        this.id = id;
    }

    /**
     * Updates driver with delivery order.
     * @param deliveryRequest the delivery order to be processed.
     */
    @Override
    public void update(DeliveryRequest deliveryRequest) {
        // Print the delivery request to check if it's printed as expected
        System.out.println("Driver " + id + " received new delivery request: " + deliveryRequest);
        // Adding a debug statement
        System.out.println("Update method executed for driver: " + id + " with request: " + deliveryRequest);
    }

    /**
     * Gets the vehicle of the driver.
     *
     * @return the vehicle
     */
    public Vehicles getVehicles() {
        return vehicles;
    }

    /**
     * Sets the vehicle of the driver.
     *
     * @param vehicles the vehicle to set
     */
    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * Gets the unique id of the driver.
     *
     * @return the unique id of the driver
     */
    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicles);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Driver other = (Driver) obj;
        return Objects.equals(vehicles, other.vehicles);
    }

    @Override
    public String toString() {
        return "Driver [vehicles=" + vehicles + ", id=" + id + "]";
    }
}
