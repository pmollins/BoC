package com.example.bocdemo.model;

public class DateFilter {
    private String earliestFormDate;
    private String latestFormDate;

    public void setEarliestFormDate(String earliestFormDate) {
        this.earliestFormDate = earliestFormDate;
    }

    public void setLatestFormDate(String latestFormDate) {
        this.latestFormDate = latestFormDate;
    }

    public String getEarliestFormDate() {
        return earliestFormDate;
    }

    public String getLatestFormDate() {
        return latestFormDate;
    }

    @Override
    public String toString() {

        return "DateFilter{" +
                "earliestFormDate='" + earliestFormDate + '\'' +
                ", latestFormDate='" + latestFormDate + '\'' +
                '}';
    }
}
