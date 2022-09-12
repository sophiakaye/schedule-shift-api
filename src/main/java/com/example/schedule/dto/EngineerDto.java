package com.example.schedule.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EngineerDto extends ObjectDto {

    private Long id;
    private String firstName;

    public enum DayTime {
        MORNING,
        AFTERNOON
    }
}
