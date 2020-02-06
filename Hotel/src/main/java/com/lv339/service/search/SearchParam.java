package com.lv339.service.search;

import java.time.LocalDate;

public class SearchParam {
    private String query;
    private LocalDate startDate;
    private LocalDate endDate;
    private Byte numberOfPeople;

    public SearchParam(String query, LocalDate startDate, LocalDate endDate, Byte numberOfPeople) {
        this.query = query;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfPeople = numberOfPeople;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
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

    public Byte getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Byte numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
}
