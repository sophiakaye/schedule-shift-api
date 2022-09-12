package com.example.schedule.processor;

import com.example.schedule.dto.EngineerDto;
import com.example.schedule.dto.ShiftDto;
import com.example.schedule.rule.RuleEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RuleValidator {

    @Autowired
    private Set<RuleEngine> ruleEngines;

    public boolean isValid(List<ShiftDto> shifts, ShiftDto currentShift, EngineerDto currentEngineer) {

        boolean isValid = false;
        for (RuleEngine rule : ruleEngines) {

            isValid = rule.verify(shifts, currentShift, currentEngineer);

            if (!isValid)
                break;
        }
        return isValid;
    }

}
