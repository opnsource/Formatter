package com.opnsource.formatter;

import android.text.TextUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by liushu on 2015/10/22.
 *
 */
class NumberFormatterManager extends AbstractFormatterManager<NumberFormat> {

    NumberFormat generationFormat(Locale locale, String pattern) {
        DecimalFormat format = (DecimalFormat) DecimalFormat.getNumberInstance(locale);
        if (!TextUtils.isEmpty(pattern)) {
            format.applyPattern(pattern);
        }
        return format;
    }

    @Override
    String doFormatter(NumberFormat formatter, FormatterInfo info) {
        Object value = info.mValue;
        if (value != null) {
            return formatter.format(value);
        }
        return "";
    }
}
