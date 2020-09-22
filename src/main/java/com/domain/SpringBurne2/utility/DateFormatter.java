package com.domain.SpringBurne2.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter
{
    public static String formatDate(Date javaDate)
    {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(javaDate);
    }
}
