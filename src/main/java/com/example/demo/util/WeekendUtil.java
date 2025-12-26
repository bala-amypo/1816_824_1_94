
package com.example.demo.util;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class WeekendUtil {

    // Prevent object creation
    private WeekendUtil() {}

    /*
     * Check if a Timestamp falls on a weekend (Saturday or Sunday)
     */
    public static boolean isWeekend(Timestamp timestamp) {
        if (timestamp == null) {
            return false;
        }

        LocalDateTime dateTime = timestamp
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        DayOfWeek day = dateTime.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }

    /*
     * Check if a LocalDateTime falls on a weekend
     */
    public static boolean isWeekend(LocalDateTime dateTime) {
        if (dateTime == null) {
            return false;
        }

        DayOfWeek day = dateTime.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
}
