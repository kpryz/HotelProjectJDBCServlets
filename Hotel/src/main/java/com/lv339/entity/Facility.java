package com.lv339.entity;

public class Facility {
    private int id;
    private String facility;
    private String facilityCategory;
    private int room_id;

    public Facility() {
    }

    /**
     * @param id
     * @param facility
     * @param facilityCategory
     * @param room_id
     */
    public Facility(int id, String facility, String facilityCategory, int room_id) {
        this.id = id;
        this.facility = facility;
        this.facilityCategory = facilityCategory;
        this.room_id = room_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getFacilityCategory() {
        return facilityCategory;
    }

    public void setFacilityCategory(String facilityCategory) {
        this.facilityCategory = facilityCategory;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }
}
