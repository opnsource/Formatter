package com.opnsource.formatter;

import android.text.TextUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by liushu on 2015/10/22.
 * Date format
 */
class DateFormatterManager extends AbstractFormatterManager<DateFormat> {


    @Override
    DateFormat generationFormat(Locale locale, String pattern) {
        DateFormat format;
        if (TextUtils.isEmpty(pattern)) {
            format = SimpleDateFormat.getInstance();
        } else {
            format = new SimpleDateFormat(pattern, locale);
        }
        return format;
    }

    @Override
    String doFormatter(DateFormat formatter, FormatterInfo info) {
        Object value = info.mValue;
        if (value != null) {
            return formatter.format(value);
        }
        return "";
    }
}
