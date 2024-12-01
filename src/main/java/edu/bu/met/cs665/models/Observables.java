/**
 * Name: Paridhi Talwar
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/27/2024
 * File Name: Observables.java
 * Description: This class defines the Observable behavior for the delivery system,
 * allowing observers to add, remove, and be alerted of delivery requests.
 */
package edu.bu.met.cs665.models;

import edu.bu.met.cs665.models.Observer;

/**
 * Interface for managing observers.
 */
public interface Observables {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void alertObservers();
}
