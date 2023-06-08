package com.example.SuViet.controller;

import com.example.SuViet.model.ResponseObject;
import com.example.SuViet.repository.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/periods")
public class PeriodController {
    @Autowired
    public PeriodRepository periodRepository;

    @GetMapping("")
    public ResponseEntity<ResponseObject> getAllPeriods() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "OK", periodRepository.findAll())
        );
    }
}
