/**
 * Name: Paridhi Talwar
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/27/2024
 * File Name: Shop.java
 * Description: This class represents a shop that acts as the Observable in the delivery system.
 * It manages delivery requests and notifies registered drivers.
 */
package edu.bu.met.cs665.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The Shop class implements the Observables interface and manages a list of drivers
 * (observers) and delivery requests.
 */
public class Shop implements Observables {

    private List<Observer> drivers;
    private DeliveryRequest deliveryRequest;

    /**
     * Constructs a new Shop with an empty list of drivers.
     */
    public Shop() {
        super();
        this.drivers = new ArrayList<>();
    }

    /**
     * Returns the current delivery request.
     *
     * @return the current delivery request
     */
    public DeliveryRequest getDeliveryRequest() {
        return deliveryRequest;
    }

    /**
     * Adds a driver to the list of observers.
     *
     * @param driver the driver to be added
     * @throws IllegalArgumentException if the driver is null or already registered
     */
    @Override
    public void addObserver(Observer driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null");
        }
        // Check if the driver is already in the list
        if (!drivers.contains(driver)) {
            drivers.add(driver);
        } else {
            // Optionally, you can print a warning or log that the driver is already registered
            System.out.println("Driver " + driver + " is already registered.");
        }
    }


    /**
     * Removes a driver from the list of observers.
     *
     * @param driver the driver to be removed
     * @throws IllegalArgumentException if the driver is null or not registered
     */
    @Override
    public void removeObserver(Observer driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null");
        }
        // Check if the driver is in the list before trying to remove it
        if (drivers.contains(driver)) {
            drivers.remove(driver);
        } else {
            // Optionally, log a message or handle the case where the driver isn't registered
            System.out.println("Driver " + driver + " not registered, cannot remove.");
        }
    }


    /**
     * Alerts all registered observers about a delivery request.
     *
     * @throws IllegalStateException if no drivers are registered or the delivery request is null
     */
    @Override
    public void alertObservers() {
        // Check if no drivers are registered
        if (drivers.isEmpty()) {
            System.out.println("Warning: No drivers are registered to receive the delivery request.");
            return;  // Optionally return or handle as needed
        }

        // Check if deliveryRequest is null
        if (deliveryRequest == null) {
            throw new IllegalStateException("Cannot alert observers: Delivery request is null.");
        }

        // Debugging output: Check how many drivers are notified
        System.out.println("Notifying " + drivers.size() + " drivers about the new delivery request.");

        // Alert all registered drivers with the delivery request
        for (Observer driver : drivers) {
            System.out.println("Notifying Driver " + ((Driver) driver).getId()); // Debugging output to check which drivers are being notified
            driver.update(this.deliveryRequest);
        }
    }



    /**
     * Creates a new delivery request with the specified item and destination.
     *
     * @param item the item to be delivered
     * @param destination the delivery destination
     * @throws IllegalArgumentException if the item or destination is null
     */
    public void createDeliveryRequest(String item, String destination) {
        if (item == null || destination == null) {
            throw new IllegalArgumentException("Item and destination cannot be null");
        }
        this.deliveryRequest = new DeliveryRequest(item, destination);
    }
}
