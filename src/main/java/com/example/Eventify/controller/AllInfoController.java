package com.example.Eventify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Eventify.Dto.AggregatedDataDTO;
import com.example.Eventify.service.DataService;

@RestController
@RequestMapping("/data")
public class AllInfoController {

	 @Autowired
	 private DataService dataService;

	    // Get all aggregated data
	    @GetMapping
	    @ResponseBody
	    public ResponseEntity<AggregatedDataDTO> getAggregatedData() {
	        AggregatedDataDTO aggregatedData = dataService.getAggregatedData();
	        return ResponseEntity.ok(aggregatedData);
	    }
	    @GetMapping("/data")
	    public ResponseEntity<String> testData() {
	        return ResponseEntity.ok("Test successful");
	    }

}
