package com.example.schedule.processor;

import com.example.schedule.dto.EngineerDto;
import com.example.schedule.utils.DateHelper;
import com.example.schedule.dto.ShiftDto;
import com.example.schedule.utils.WheelConstants;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchedulePreparator {

    public List<ShiftDto> prepareEmptySchedule(LocalDate startDate) {

        List<ShiftDto> newShifts = new ArrayList<>();
        LocalDate currentDate = null;

        int tempId = 1;

        for(int i = 0; i < WheelConstants.NUMBER_OF_DAYS_PER_PERIOD; i++) {

            currentDate = startDate.plusDays(i);
            if(DateHelper.checkIsWeekend(currentDate))
                continue;

            newShifts.add(new ShiftDto((long) tempId++, currentDate.getDayOfWeek().name(), currentDate, EngineerDto.DayTime.MORNING, new EngineerDto()));
            newShifts.add(new ShiftDto((long) tempId++, currentDate.getDayOfWeek().name(), currentDate, EngineerDto.DayTime.AFTERNOON, new EngineerDto()));
        }
        return newShifts;
    }


}
