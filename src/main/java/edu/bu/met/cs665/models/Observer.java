/**
 * Name: Paridhi Talwar
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/27/2024
 * File Name: Observer.java
 * Description: This interface defines the Observer behavior for the delivery system,
 * allowing implementation classes to receive updates from an Observable.
 */
package edu.bu.met.cs665.models;

public interface Observer {

    /**
     * Method to update the observer with a new delivery order.
     * @param deliveryRequest the delivery order to be sent to the observer.
     */
    public void update(DeliveryRequest deliveryRequest);

}
