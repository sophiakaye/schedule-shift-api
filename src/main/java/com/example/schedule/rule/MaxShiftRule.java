package com.example.schedule.rule;

import com.example.schedule.dto.EngineerDto;
import com.example.schedule.dto.ShiftDto;
import com.example.schedule.utils.WheelConstants;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MaxShiftRule implements RuleEngine {

    @Override
    public boolean verify(List<ShiftDto> shifts, ShiftDto currentShift, EngineerDto randomEngineer) {

        return shifts.stream()
                .filter(s -> s.getEngineer().getId() == randomEngineer.getId())
                .count() < WheelConstants.MAX_ENGINEER_SHIFT_PER_PERIOD;
    }
}
