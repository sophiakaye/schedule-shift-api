package com.example.schedule.rule;

import com.example.schedule.dto.EngineerDto;
import com.example.schedule.dto.ShiftDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotSameDayShiftRule implements RuleEngine {

    @Override
    public boolean verify(List<ShiftDto> shifts, ShiftDto currentShift, EngineerDto randomEngineer) {

        return shifts.stream()
                .filter(shiftDto -> shiftDto.getShiftDate().isEqual(currentShift.getShiftDate()))
                .noneMatch(shiftDto -> shiftDto.getEngineer().getId() == randomEngineer.getId());
    }
}
