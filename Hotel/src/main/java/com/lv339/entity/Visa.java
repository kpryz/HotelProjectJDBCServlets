package com.lv339.entity;

import java.time.LocalDate;

public class Visa {
    private LocalDate startDate;
    private LocalDate endDate;
    private String country;
    private String visaNumber;
    private String customer_email;

    public Visa() {
    }

    public Visa(LocalDate startDate, LocalDate endDate, String country, String visaNumber, String customer_email) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.country = country;
        this.visaNumber = visaNumber;
        this.customer_email = customer_email;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVisaNumber() {
        return visaNumber;
    }

    public void setVisaNumber(String visaNumber) {
        this.visaNumber = visaNumber;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }
}
