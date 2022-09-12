package com.example.schedule.rule;

import com.example.schedule.dto.EngineerDto;
import com.example.schedule.dto.ShiftDto;
import com.example.schedule.utils.DateHelper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotConsecutiveDayRule implements RuleEngine {

    @Override
    public boolean verify(List<ShiftDto> shifts, ShiftDto currentShift, EngineerDto randomEngineer) {

        return shifts.stream()
                .filter(shiftDto -> shiftDto.getShiftDate().isEqual(DateHelper.getPreviousWorkingDay(currentShift.getShiftDate()))
                        || shiftDto.getShiftDate().isEqual(DateHelper.getNextWorkingDay(currentShift.getShiftDate())))
                .noneMatch(shiftDto -> shiftDto.getEngineer().getId() == randomEngineer.getId());
    }
}
