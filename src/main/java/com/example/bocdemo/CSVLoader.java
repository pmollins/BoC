package com.example.bocdemo;

import java.io.*;
import java.util.Map;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.bocdemo.repository.ClimateDAO;

@Component
public class CSVLoader implements CommandLineRunner {

    //private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private ClimateDAO climateDAO;

    @Override
    public void run(String... args) throws Exception {
        File csvFile = new File("eng-climate-summary.csv");
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader(); //first row for header
        MappingIterator<Map<String,String>> it = mapper.readerFor(Map.class)
                .with(schema)
                .readValues(csvFile);
        climateDAO.insertClimates(it);
    }
}

