/**
 * Name: Paridhi Talwar
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/27/2024
 * File Name: DeliverySystemTest.java
 * Description: This is a test class for the Shop class.
 * This class is responsible for:
 * - testing adding and removing observers
 * - testing creating a delivery request from Observable
 * - testing ability to alert all observers at once
 */

package edu.bu.met.cs665;

import static org.junit.Assert.*;

import edu.bu.met.cs665.models.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DeliverySystemTest {

    private Shop shop;

    private Driver driver1;
    private Driver driver2;
    private Driver driver3;
    private Driver driver4;
    private Driver driver5;

    private Vehicles Scooter;
    private Vehicles Car;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        shop = new Shop();

        Scooter = new Scooter(); // Updated class name to follow Java conventions
        Car = new Car(); // Updated class name to follow Java conventions

        driver1 = new Driver(Scooter);
        driver2 = new Driver(Car);
        driver3 = new Driver(Car);
        driver4 = new Driver(Scooter);
        driver5 = new Driver(Car);

        // Redirecting System.out to capture output
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Tests all methods from Observable at once.
     */
    @Test
    public void testAllMethods_Success() {
        // Test delivery request
        DeliveryRequest expectedDeliveryRequest = new DeliveryRequest("Bicycle", "New Jersey");

        // Register 5 Driver objects to Observable.
        shop.addObserver(driver1);
        shop.addObserver(driver2);
        shop.addObserver(driver3);
        shop.addObserver(driver4);
        shop.addObserver(driver5);

        // Create a new delivery request and notify all drivers.
        shop.createDeliveryRequest("Bicycle", "New Jersey");
        shop.alertObservers();

        // Unregister 2 Driver objects.
        shop.removeObserver(driver1);
        shop.removeObserver(driver5);

        // Create a new delivery request and notify remaining registered drivers.
        shop.createDeliveryRequest("Unicycle", "New York");
        shop.alertObservers();

        // Capture the output and compare the driver's IDs.
        String output = outContent.toString().trim();

        // Debug output to ensure the correct format
        System.out.println("Captured Output: " + output);

        // Check if the output contains correct driver IDs
        assertTrue(output.contains("Driver " + driver2.getId() + " received new delivery request:"));

        // Reset output stream for next test
        outContent.reset();
    }
}