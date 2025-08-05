package com.pokemon.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/csv")
public class CsvController {

    @Autowired
    private CsvService csvService;

    @PostMapping("/upload/{count}")
    public ResponseEntity<String> uploadCsvFiles(@RequestBody List<String> filePaths, @PathVariable int count) {
        csvService.processCsvFiles(filePaths, count);
        return ResponseEntity.ok("CSV file list received successfully.");
    }
}