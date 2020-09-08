package com.example.bocdemo.service;

import java.util.List;

import com.example.bocdemo.model.Climate;
import com.example.bocdemo.repository.ClimateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClimateService implements IClimateService {

    @Autowired
    private ClimateDAO climateDAO;

    @Override
    public List<Climate> findAll() {
        return climateDAO.getAllClimates();
    }

    @Override
    public Climate findById(int id) {
        return climateDAO.getClimateById(id);
    }

    @Override
    public List<Climate> findByDateRange(String startDate, String endDate) {
        return climateDAO.getRangeOfClimates(startDate, endDate);
    }

    @Override
    public String findEarliestDate() {
        return climateDAO.findOldestClimate().getDate();
    }

    @Override
    public String findLatestDate() {
        return climateDAO.findNewestClimate().getDate();
    }
}