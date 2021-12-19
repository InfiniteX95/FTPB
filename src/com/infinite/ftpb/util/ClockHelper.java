package com.infinite.ftpb.util;

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
        return (LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute());
    }
}
