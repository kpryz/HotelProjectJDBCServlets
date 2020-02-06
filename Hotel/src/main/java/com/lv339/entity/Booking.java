package com.lv339.entity;

import java.time.LocalDate;

public class Booking {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String comment; //if user has any additional wishes
    private String customer_email;
    private int totalPriceInDollars;
    private int room_id;

    private Room room; //TODO What is better?

    public Booking() {
    }

    /**
     * @param startDate
     * @param endDate
     * @param comment
     * @param customer_email
     * @param room_id
     */
    public Booking(LocalDate startDate, LocalDate endDate, String comment, String customer_email, int room_id) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.comment = comment;
        this.customer_email = customer_email;
        this.room_id = room_id;
    }

    /**
     * @param id
     * @param startDate
     * @param endDate
     * @param comment
     * @param customer_email
     * @param room_id
     */
    public Booking(int id, LocalDate startDate, LocalDate endDate, String comment, String customer_email, int room_id) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.comment = comment;
        this.customer_email = customer_email;
        this.room_id = room_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getTotalPriceInDollars() {
        return totalPriceInDollars;
    }

    public void setTotalPriceInDollars(int totalPriceInDollars) {
        this.totalPriceInDollars = totalPriceInDollars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}
