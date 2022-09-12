package com.example.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiftDto extends ObjectDto {

    private Long id;
    private String shiftDay;
    private LocalDate shiftDate;
    private EngineerDto.DayTime dayTime;
    private EngineerDto engineer;
    
    public enum DayTime {
        MORNING,
        AFTERNOON
    }
}
