package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * BuddyInfo Class for Lab 1
 *
 * @author Bilal Chaudhry 101141634
 * @version 1.0
 */
@Entity
public class BuddyInfo {

    private String phoneNumber;
    private String name;
    private String address;

    @Id
    @GeneratedValue
    private Long id;

    /**
     * Constructor for a BuddyInfo Object
     */
    protected BuddyInfo() {
    }

    /**
     * Constructor for BuddyIngo Object
     *
     * @param name        : String, name of buddy
     * @param phoneNumber : String, phone number of buddy
     */
    public BuddyInfo(String name, String phoneNumber) {
        this(name, phoneNumber, "Ottawa");
    }

    /**
     * Constructor for BuddyIngo Object
     *
     * @param name        : String, name of buddy
     * @param phoneNumber : String, phone number of buddy
     * @param address     : String, address of the buddy
     */
    public BuddyInfo(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * getter for phoneNumber
     *
     * @return String, phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }


    /**
     * Setter for phoneNumber
     *
     * @param phoneNumber : String
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter for name
     *
     * @return String, name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     *
     * @param name : String
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Buddy: " + name + ", PhoneNumber: " + phoneNumber + ", Address: " + address;
    }


}
