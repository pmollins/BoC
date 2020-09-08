package com.example.bocdemo.controller;
import com.example.bocdemo.model.Climate;
import com.example.bocdemo.service.ClimateService;
import com.example.bocdemo.service.IClimateService;
import com.example.bocdemo.model.DateFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class WebController {

    @Autowired
    private IClimateService climateService;

    private Logger logger = LoggerFactory.getLogger(WebController.class);

    @GetMapping("/")
    public String index(Model model) {
        DateFilter df = new DateFilter();
        df.setEarliestFormDate(climateService.findEarliestDate());
        df.setLatestFormDate(climateService.findLatestDate());

        model.addAttribute("filterForm", df);
        model.addAttribute("climates", climateService.findAll());

        logger.info("WebController::GET::''/''");

        return "index";
    }

    @GetMapping("/climate/{climateId}")
    public String details(@PathVariable int climateId, Model model) {
        model.addAttribute("climate", climateService.findById( climateId ));

        logger.info("WebController::GET::''/climate/'' id - " + climateId);
        return "details";
    }

    @PostMapping("/")
    public String filter(@ModelAttribute("filterForm") DateFilter filter, Model model) {
        model.addAttribute("climates", climateService.findByDateRange(filter.getEarliestFormDate(), filter.getLatestFormDate()) );

        logger.info("WebController::POST::''/'' + filter:" + filter.toString());

        return "index";
    }
}