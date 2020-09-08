package com.example.bocdemo.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//lombok annotations
@ToString
@EqualsAndHashCode

@Component
public class Climate {
    private int id;
    private String stationName;
    private String province;
    private String date;
    private String meanTemp;
    private String highestMonthlyMaxTemp;
    private String lowestMonthlyMinTemp;

    //setters - explicitly written for row mapper warnings
    public void setId(int id) {
        this.id = id;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void setDate(String date) {
        this.date = date;//LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setMeanTemp(String meanTemp) {
        this.meanTemp = meanTemp;
    }

    public void setLowestMonthlyMinTemp(String lowestMonthlyMinTemp) {
        this.lowestMonthlyMinTemp = lowestMonthlyMinTemp;
    }

    public void setHighestMonthlyMaxTemp(String highestMonthlyMaxTemp) {
        this.highestMonthlyMaxTemp = highestMonthlyMaxTemp;
    }

    //getters explicitly declared to avoid mapper warnings
    public int getId() {
        return id;
    }

    public String getStationName() {
        return stationName;
    }

    public String getProvince() {
        return province;
    }

    public String getDate() {
        return date;
    }

    public String getMeanTemp() {
        return meanTemp;
    }

    public String getLowestMonthlyMinTemp() {
        return lowestMonthlyMinTemp;
    }

    public String getHighestMonthlyMaxTemp() {
        return highestMonthlyMaxTemp;
    }
}