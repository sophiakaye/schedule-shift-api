package com.example.schedule.controller;

import com.example.schedule.dto.ShiftDto;
import com.example.schedule.processor.WheelProcessor;
import com.example.schedule.utils.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/wheel")
public class WheelController {

    @Autowired
    private WheelProcessor wheelProcessor;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ShiftDto>> schedule() {

        List<ShiftDto> shifts = wheelProcessor.scheduleShifts(DateHelper.getNextMonday(LocalDate.now()));
        return ResponseEntity.status(HttpStatus.OK).body(shifts.stream()
                .sorted(Comparator.comparing(ShiftDto::getId))
                .collect(Collectors.toList()));
    }
}
