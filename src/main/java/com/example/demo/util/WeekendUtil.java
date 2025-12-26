package com.example.demo.util;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class WeekendUtil {

    public static boolean isWeekend(LocalDateTime dateTime) {
        DayOfWeek day = dateTime.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
}
