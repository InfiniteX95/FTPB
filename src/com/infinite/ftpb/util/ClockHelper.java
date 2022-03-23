package com.infinite.ftpb.util;

import sun.util.calendar.BaseCalendar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ClockHelper {

    public static String getFormattedDateTime()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm", Locale.getDefault());//get default pattern

        String strLocalDate = LocalDateTime.now().withNano(0).withSecond(0).toString();//stores local date in string format

        LocalDateTime localDate = LocalDateTime.parse(strLocalDate, formatter);//parses the string

        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm ").format(localDate));

        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH'H'mm").format(localDate);//return the final formatted value
    }

    public static String getActualHour()
    {
        int hour = LocalDateTime.now().getHour();;
        int min = LocalDateTime.now().getMinute();
        StringBuilder sb = new StringBuilder();
        if (hour < 10) {
            sb.append(0).append(hour);
        } else {
            sb.append(hour);
        }
        sb.append(":");
        if (min < 10) {
            sb.append(0).append(min);
        } else {
            sb.append(min);
        }
        return sb.toString();
    }
}
