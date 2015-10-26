package com.opnsource.formatter;

import java.util.Locale;

/**
 * Created by liushu on 2015/10/26.
 * <p/>
 * For exmaple:
 * StringFormatter.format("%s,%s","Hello","java");
 * <p/>
 * Appoint a locale:
 * StringFormatter.format(Locale.US,"%s,%s","Hello","java");
 */
public class StringFormatter {

    private static final Class TAG_KEY = CharacterFormatterManager.class;

    public static String format(String format, Object... args) {
        return Formatter.formatNative(TAG_KEY, format, null, true, args);
    }

    public static String format(Locale locale, String format, Object... args) {
        return Formatter.formatNative(locale, TAG_KEY, format, null, true, args);
    }

}
