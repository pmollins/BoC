package com.example.bocdemo;

import com.example.bocdemo.model.Climate;

import com.example.bocdemo.repository.ClimateDAO;
import com.example.bocdemo.service.ClimateService;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.Before;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@SpringBootTest
public class ClimateServiceTests {

    @Autowired
    private ClimateDAO climateDAO;

    @Autowired
    private ClimateService climateService;

    @Before
    public void setUp() throws Exception {

        File csvFile = new File("eng-climate-summary.csv");
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader(); //first row for header

        try {
            MappingIterator<Map<String, String>> it = mapper.readerFor(Map.class)
                    .with(schema)
                    .readValues(csvFile);
            climateDAO.insertClimates(it);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAllClimates() {
        List<Climate> results = climateService.findAll();
        assertThat(results).isNotNull().isNotEmpty();
        assertThat(results).hasSize(1135);
    }

    @Test
    void testFindById() {
        Climate result = climateService.findById(1);
        assertThat(result).isNotNull();
        assertEquals(result.getId(), 1);
    }

    @Test
    void testFindByRange() {
        List<Climate> results = climateService.findByDateRange("2018-01-01", "2018-01-06");
        assertThat(results).isNotNull().isNotEmpty();
        assertThat(results).hasSize(64);
    }

    @Test
    void testFindEarliest() {
        String date = climateService.findEarliestDate();
        assertThat(date).isNotNull();
        assertEquals(date, "2017-03-09");
    }

    @Test
    void testFindLatest() {
        String date = climateService.findLatestDate();
        assertThat(date).isNotNull();
        assertEquals(date, "2018-10-20");
    }
}
