package com.opnsource.formatter;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by liushu on 2015/10/22.
 */
abstract class AbstractFormatterManager<T> {

    private static final String DEFALUT_KEY = "DEFUALT_FORMAT";

    protected final HashMap<String, T> mCache = new HashMap<String, T>();

    protected T getFormaterInstance(Locale locale, String pattern, boolean cache) {
        String key = generationKey(locale, pattern);
        T format = mCache.get(key);
        if (format == null) {
            format = generationFormat(locale, pattern);
            if (cache) {
                mCache.put(key, format);
            }
        }
        return format;
    }


    protected String generationKey(Locale locale, String orginKey) {
        String key = DEFALUT_KEY;
        if (!TextUtils.isEmpty(orginKey)) {
            key = orginKey.hashCode() + orginKey + locale.hashCode();
        }
        return key;
    }

    String formatter(Locale locale, FormatterInfo info) {
        T formater = getFormaterInstance(locale, info.mPattern, info.mCache);
        return doFormatter(formater, info);
    }

    abstract T generationFormat(Locale locale, String pattern);


    abstract String doFormatter(T formater, FormatterInfo info);

}
