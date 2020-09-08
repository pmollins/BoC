package com.example.bocdemo.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClimateRowMapper implements RowMapper<Climate> {
    @Override
    public Climate mapRow(ResultSet rs, int rowNum) throws SQLException {
        Climate summary = new Climate();

        summary.setId(rs.getInt("ID"));
        summary.setStationName(rs.getString("STATION_NAME"));
        summary.setProvince(rs.getString("PROVINCE"));
        summary.setDate(rs.getString("RDATE"));
        summary.setMeanTemp(rs.getString("MEAN_TEMP"));
        summary.setLowestMonthlyMinTemp(rs.getString("LOWEST_MONTHLY_MIN_TEMP"));
        summary.setHighestMonthlyMaxTemp(rs.getString("HIGHEST_MONTHLY_MAX_TEMP"));

        return summary;
    }
}
