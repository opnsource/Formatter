package com.opnsource.formater;

import java.util.Formatter;
import java.util.Locale;

/**
 * Created by liushu on 2015/10/22.
 * 字符串format
 */

class CharacterFormatterManager extends AbstractFormatterManager<Formatter> {

    private volatile StringBuffer mOut = new StringBuffer();

    private final Object mLock = new Object();

    @Override
    Formatter generationFormat(Locale locale, String pattern) {
        return new Formatter(mOut, locale);
    }

    @Override
    String doFormatter(Formatter formatter, FormatterInfo info) {
        Object value = info.mValue;
        Object[] params = info.mData;
        if (value != null && value instanceof String) {
            String source = (String) value;
            synchronized (mLock) {
                mOut.setLength(0);
                return formatter.format(source, params).toString();
            }
        }
        return "";
    }
}
