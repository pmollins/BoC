package com.example.bocdemo.service;

import com.example.bocdemo.model.Climate;

import java.util.List;

public interface IClimateService {

    List<Climate> findAll();
    List<Climate> findByDateRange(String startDate, String endDate);
    Climate findById(int id);
    String findEarliestDate();
    String findLatestDate();
}