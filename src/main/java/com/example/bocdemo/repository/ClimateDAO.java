package com.example.bocdemo.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.fasterxml.jackson.databind.MappingIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.bocdemo.model.Climate;
import com.example.bocdemo.model.ClimateRowMapper;

@Repository
public class ClimateDAO extends JdbcDaoSupport implements IClimateDAO {

    private Logger logger = LoggerFactory.getLogger(ClimateRowMapper.class);

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public void insertClimates(MappingIterator<Map<String, String>> it) {
        while (it.hasNext()) {
            Map<String, String> rowAsMap = it.next();

            //muted due to noise
            //logger.info("ClimateDAO::insertClimates item:"+rowAsMap.toString());

            String insertQuery = "insert into CLIMATE (STATION_NAME, PROVINCE, RDATE, MEAN_TEMP, LOWEST_MONTHLY_MIN_TEMP, " +
                    "HIGHEST_MONTHLY_MAX_TEMP) values(?,?,?,?,?,?)";
            getJdbcTemplate().update(insertQuery, rowAsMap.get("Station_Name"), rowAsMap.get("Province"),
                    LocalDate.parse(rowAsMap.get("Date"), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    rowAsMap.get("Mean_Temp"), rowAsMap.get("Lowest_Monthly_Min_Temp"),
                    rowAsMap.get("Highest_Monthly_Maxi_Temp"));
            }
    }

    @Override
    public List<Climate> getAllClimates(){
        String sql = "SELECT * FROM CLIMATE ORDER BY RDATE ASC";

        logger.info("ClimateDAO::getAllClimates");

        return getJdbcTemplate().query(sql, new ClimateRowMapper());
    }

    @Override
    public Climate getClimateById(int climateId) {
        logger.info("ClimateDAO::getClimateById - id:" + climateId);

        String sql = "SELECT * FROM CLIMATE WHERE ID = ?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{climateId}, new ClimateRowMapper());
    }

    @Override
    public List<Climate> getRangeOfClimates(String startDate, String endDate) {
        logger.info("ClimateDAO::getRangeOfClimates - s:" + startDate + " e:" + endDate);

        String sql = "SELECT * FROM CLIMATE WHERE RDATE BETWEEN ? AND ? ORDER BY RDATE ASC";
        return getJdbcTemplate().query(sql, new Object[]{startDate, endDate}, new ClimateRowMapper());
    }

    @Override
    public Climate findOldestClimate() {
        logger.info("ClimateDAO::findOldestClimate");
        String sql = "SELECT * FROM CLIMATE ORDER BY RDATE ASC LIMIT 1";
        return getJdbcTemplate().queryForObject(sql, new ClimateRowMapper());
    }

    @Override
    public Climate findNewestClimate() {
        logger.info("ClimateDAO::findNewestClimate");

        String sql = "SELECT * FROM CLIMATE ORDER BY RDATE DESC LIMIT 1";
        return getJdbcTemplate().queryForObject(sql, new ClimateRowMapper());
    }
}