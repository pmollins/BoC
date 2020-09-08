package com.example.bocdemo.service;

import java.util.List;

import com.example.bocdemo.model.Climate;
import com.example.bocdemo.repository.ClimateDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClimateService implements IClimateService {

    @Autowired
    private ClimateDAO climateDAO;

    private Logger logger = LoggerFactory.getLogger(ClimateService.class);


    @Override
    public List<Climate> findAll() {
        logger.info("ClimateService::findAll()");

        return climateDAO.getAllClimates();
    }

    @Override
    public Climate findById(int id) {

        logger.info("ClimateService::findById() - id:" + id);

        return climateDAO.getClimateById(id);
    }

    @Override
    public List<Climate> findByDateRange(String startDate, String endDate) {

        logger.info("ClimateService::findByDateRange() - s:" + startDate + " - e:" + endDate);
        return climateDAO.getRangeOfClimates(startDate, endDate);
    }

    @Override
    public String findEarliestDate() {
        String earliest = climateDAO.findOldestClimate().getDate();

        logger.info("ClimateService::findByEarliestDate() : "+ earliest);

        return earliest;
    }

    @Override
    public String findLatestDate() {
        String latest = climateDAO.findNewestClimate().getDate();

        logger.info("ClimateService::findByEarliestDate() : "+ latest);
        return latest;
    }
}