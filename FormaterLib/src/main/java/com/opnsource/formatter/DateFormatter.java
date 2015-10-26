package com.opnsource.formatter;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;


/**
 * Created by liushu on 2015/10/26.
 * <p/>
 * For exmaple:
 * <p/>
 * DateFormatter.format(new Date(),"yyyy-MM-dd HH:mm:ss");
 * <p/>
 * DateFormatter.format( System.currentTimeMillis(),""yyyy-MM-dd HH:mm:ss"");
 * <p/>
 * Appoint a locale:
 * <p/>
 * DateFormatter.format(Locale.US,new Date(),"yyyy-MM-dd HH:mm:ss");
 * <p/>
 * NOT CACHE:
 * <p/>
 * DateFormatter.format(Locale.US,new Date(),"yyyy-MM-dd HH:mm:ss",false);
 */

public class DateFormatter {


    public static String format(Date date, String pattern) {
        return format(date, pattern, true);
    }

    public static String format(Locale locale, Date date, String pattern) {
        return Formatter.formatNative(locale, DateFormatterManager.class, date, pattern, true);
    }

    public static String format(Date date, String pattern, boolean cache) {
        return Formatter.formatNative(DateFormatterManager.class, date, pattern, cache, "");
    }

    public static String format(Locale locale, Date date, String pattern, boolean cache) {
        return Formatter.formatNative(locale, DateFormatterManager.class, date, pattern, cache, "");
    }

    public static String format(long milliseconds, String pattern, TimeZone timeZone) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTimeInMillis(milliseconds);
        calendar.setTimeZone(timeZone);
        return format(calendar.getTime(), pattern);
    }

    public static String format(long milliseconds, String pattern) {
        try {
            String result = format(new Date(milliseconds), pattern);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}

