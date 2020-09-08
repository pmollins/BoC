package com.example.bocdemo.repository;

import java.util.Map;
import java.util.List;
import com.example.bocdemo.model.Climate;
import com.fasterxml.jackson.databind.MappingIterator;

public interface IClimateDAO {
    void insertClimates(MappingIterator<Map<String,String>> it);
    List<Climate> getAllClimates();
    List<Climate> getRangeOfClimates(String startDate, String endDate);
    Climate getClimateById(int climateId);
    Climate findOldestClimate();
    Climate findNewestClimate();
}