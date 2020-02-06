package com.lv339.entity;

import java.util.ArrayList;
import java.util.List;

public class Customer implements IUser {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String contactNumber;
    private String user_email;

    private List<Visa> visaList = new ArrayList<>();
    private List<Booking> bookingList = new ArrayList<>();


    public Customer() {
    }

    /**
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param contactNumber
     * @param user_email
     * @param visaList
     * @param bookingList
     */
    public Customer(String firstName, String lastName, String email, String password,
                    String contactNumber, String user_email, List<Visa> visaList, List<Booking> bookingList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.contactNumber = contactNumber;
        this.user_email = user_email;
        this.visaList = visaList;
        this.bookingList = bookingList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public List<Visa> getVisaList() {
        return visaList;
    }

    public void setVisaList(List<Visa> visaList) {
        this.visaList = visaList;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }
}
