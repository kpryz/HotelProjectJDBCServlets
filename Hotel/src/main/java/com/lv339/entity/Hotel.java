package com.lv339.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hotel {
    private String city;
    private String country;
    private String name;
    private byte stars;
    private String street;
    private String imageUrl;

    private List<Room> roomList = new ArrayList<>();

    public Hotel(String city, String country, String name, byte stars, String street, String imageUrl) {
        this.city = city;
        this.country = country;
        this.name = name;
        this.stars = stars;
        this.street = street;
        this.imageUrl = imageUrl;
    }

    public Hotel() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getStars() {
        return stars;
    }

    public void setStars(byte stars) {
        this.stars = stars;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", stars=" + stars +
                ", street='" + street + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", roomList=" + roomList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return stars == hotel.stars &&
                Objects.equals(city, hotel.city) &&
                Objects.equals(country, hotel.country) &&
                Objects.equals(name, hotel.name) &&
                Objects.equals(street, hotel.street) &&
                Objects.equals(imageUrl, hotel.imageUrl) &&
                Objects.equals(roomList, hotel.roomList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, name, stars, street, imageUrl, roomList);
    }
}
