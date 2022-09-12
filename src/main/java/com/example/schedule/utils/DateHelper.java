package com.example.schedule.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateHelper {

    public static boolean checkIsWeekend(LocalDate localDate) {
        if (localDate.getDayOfWeek() == DayOfWeek.SATURDAY
            || localDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return true;
        } else {
            return false;
        }
    }

    public static LocalDate getPreviousWorkingDay(LocalDate localDate) {
        int i = 1;
        LocalDate currentDate = localDate;

        while(i < 7) {
            currentDate = currentDate.minusDays(i);
            i++;
            if (checkIsWeekend(currentDate))
                continue;
            else
                break;
        }
        return currentDate;
    }

    public static LocalDate getNextWorkingDay(LocalDate localDate) {
        int i = 1;
        LocalDate currentDate = localDate;

        while(i < 7) {
            currentDate = currentDate.plusDays(i);
            i++;
            if (checkIsWeekend(currentDate))
                continue;
            else
                break;
        }
        return currentDate;
    }

    public static LocalDate getNextMonday(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
    }
}
