package com.lv339.entity;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int Id;
    private int numberOfPeople;
    private int priceInDollars;
    private String roomType;
    private short roomNumber;
    private String hotel_name;
    private Hotel hotel;

    private List<Facility> facilityList = new ArrayList<>();

    public Room() {
    }

    /**
     * @param id
     * @param numberOfPeople
     * @param priceInDollars
     * @param roomType
     * @param roomNumber
     * @param hotelName
     */
    public Room(int id, int numberOfPeople, int priceInDollars, String roomType, short roomNumber, String hotelName) {
        Id = id;
        this.numberOfPeople = numberOfPeople;
        this.priceInDollars = priceInDollars;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.hotel_name = hotelName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getPriceInDollars() {
        return priceInDollars;
    }

    public void setPriceInDollars(int priceInDollars) {
        this.priceInDollars = priceInDollars;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public short getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(short roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public List<Facility> getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(List<Facility> facilityList) {
        this.facilityList = facilityList;
    }

    @Override
    public String toString() {
        return "Room{" +
                "Id=" + Id +
                ", numberOfPeople=" + numberOfPeople +
                ", priceInDollars=" + priceInDollars +
                ", roomType='" + roomType + '\'' +
                ", roomNumber=" + roomNumber +
                ", hotel_name='" + hotel_name + '\'' +
                ", facilityList=" + facilityList +
                '}';
    }


    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
