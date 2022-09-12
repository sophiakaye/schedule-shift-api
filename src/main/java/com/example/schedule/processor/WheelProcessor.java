package com.example.schedule.processor;

import com.example.schedule.dto.EngineerDto;
import com.example.schedule.dto.ShiftDto;
import com.example.schedule.utils.RandomEngineerPicker;
import com.example.schedule.utils.WheelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class WheelProcessor {

    @Autowired
    private SchedulePreparator schedulePreparator;
    @Autowired
    private EngineerPoolPreparator engineerPoolPreparator;
    @Autowired
    private RuleValidator ruleValidator;

    private List<ShiftDto> shifts = new ArrayList<>();
    private List<EngineerDto> engineerPool = new ArrayList<>();

    public List<ShiftDto> scheduleShifts(LocalDate startDate) {

        shifts = schedulePreparator.prepareEmptySchedule(startDate);
        engineerPool = engineerPoolPreparator.createEngineerPool();

        shifts.stream()
              .forEach(shift -> assignEngineer(shift));

        return shifts;
    }

    private void assignEngineer(ShiftDto currentShift) {

        EngineerDto randomEngineer = RandomEngineerPicker.pickUp(engineerPool);

        if (ruleValidator.isValid(shifts, currentShift, randomEngineer)) {
            currentShift.setEngineer(randomEngineer);
            removeUnavailableEngineers();
        } else {
            assignEngineer(currentShift);
        }
    }

    private void removeUnavailableEngineers() {

        if (engineerPool.size() > 1) {
            engineerPool.removeAll(shifts.stream()
                    .filter(s -> s.getEngineer().getId() != null)
                    .map(s -> s.getEngineer())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream()
                    .filter(x -> x.getValue().intValue() == WheelConstants.MAX_ENGINEER_SHIFT_PER_PERIOD)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList()));
        }
    }

}
