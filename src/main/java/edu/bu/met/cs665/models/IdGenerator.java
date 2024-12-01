/**
 * Name: Paridhi Talwar
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/27/2024
 * File Name: IdGenerator.java
 * Description: This class implements a unique id for each Driver
 * It implements the Observer interface to receive delivery requests.
 */
package edu.bu.met.cs665.models;

public class IdGenerator {

    private static IdGenerator instance;
    private int currentId;

    private IdGenerator() {
        currentId = 0;
    }

    public static synchronized IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }

    public synchronized int generateId() {
        return currentId++;
    }
}
