package com.example.schedule.rule;

import com.example.schedule.dto.EngineerDto;
import com.example.schedule.dto.ShiftDto;

import java.util.List;

public interface RuleEngine {

    boolean verify(List<ShiftDto> shifts, ShiftDto currentShift, EngineerDto randomEngineer);
}
