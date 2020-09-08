package com.example.bocdemo;

import java.io.*;
import java.util.Map;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.bocdemo.repository.ClimateDAO;

@Component
public class CSVLoader implements CommandLineRunner {

    private  final Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);

    @Autowired
    private ClimateDAO climateDAO;

    @Override
    public void run(String... args) throws Exception {
        logger.info("CSVLoader::run - load the csv");

        File csvFile = new File("eng-climate-summary.csv");
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader(); //first row as header; otherwise defaults are fine
        MappingIterator<Map<String,String>> it = mapper.readerFor(Map.class)
                .with(schema)
                .readValues(csvFile);
        climateDAO.insertClimates(it);
    }
}

