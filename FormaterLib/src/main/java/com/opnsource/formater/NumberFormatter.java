package com.opnsource.formater;

import java.util.Locale;

/**
 * Created by liushu on 2015/10/26.
 * <p/>
 * formatter NUMBER
 * <p/>
 * For exmaple:
 * <p/>
 * NumberFormatter.format(10.00f,"#0.00MB");
 * NumberFormatter.format(10.00f,"#0.00MB",true);
 * <p/>
 * if the pattern not cache:
 * <p/>
 * NumberFormatter.format(10.00f,"#0.00MB",false);
 */
public class NumberFormatter {

    private static final Class TAG_KEY = NumberFormatterManager.class;

    public static String format(long value, String pattern, boolean cache) {
        return Formatter.formatNative(TAG_KEY, value, pattern, cache, "");
    }

    public static String format(int value, String pattern, boolean cache) {
        return Formatter.formatNative(TAG_KEY, value, pattern, cache, "");
    }

    public static String format(Number value, String pattern, boolean cache) {
        return Formatter.formatNative(TAG_KEY, value, pattern, cache, "");
    }

    public static String format(double value, String pattern, boolean cache) {
        return Formatter.formatNative(TAG_KEY, value, pattern, cache, "");
    }

    public static String format(float value, String pattern, boolean cache) {
        return Formatter.formatNative(TAG_KEY, value, pattern, cache, "");
    }

    public static String format(Locale locale, Number value, String pattern, boolean cache) {
        return Formatter.formatNative(locale, TAG_KEY, value, pattern, cache);
    }

    public static String format(int value, String pattern) {
        return format(value, pattern, true);
    }

    public static String format(long value, String pattern) {
        return format(value, pattern, true);
    }

    public static String format(double value, String pattern) {
        return format(value, pattern, true);
    }

    public static String format(float value, String pattern) {
        return format(value, pattern, true);
    }

    public static String format(Number value, String pattern) {
        return format(value, pattern, true);
    }


    public static String format(Locale locale, Number value, String pattern) {
        return format(locale, value, pattern, true);
    }


}
