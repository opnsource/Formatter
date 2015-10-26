package com.opnsource.formatter;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by liushu on 2015/10/22.
 * <p/>
 * init your locale By Formatter
 * <p/>
 * Default Locale is Locale.US
 * <p/>
 * For exmaple :
 * <p/>
 * Formatter.init(Locale.US)
 */
public class Formatter {

    private static Locale DEFAULT_LOCALE = Locale.US;

    public static final HashMap<Class, AbstractFormatterManager> CACHE = new HashMap<Class, AbstractFormatterManager>();

    static {
        CACHE.put(NumberFormatterManager.class, new NumberFormatterManager());
        CACHE.put(DateFormatterManager.class, new DateFormatterManager());
        CACHE.put(CharacterFormatterManager.class, new CharacterFormatterManager());
    }

    static String formatNative(Locale locale, Class cacheKey, Object value, String pattern,
                               boolean cache, Object... args) {
        AbstractFormatterManager formatterManager = CACHE.get(cacheKey);
        if (formatterManager == null) {
            throw new FormatterException("formatter manger is null");
        }
        FormatterInfo formatterInfo = generationFormatterInfo(value, pattern, cache, args);
        locale = locale == null ? DEFAULT_LOCALE : locale;
        return formatterManager.formatter(locale, formatterInfo);
    }

    /**
     * Init Default locale
     *
     * @param initLocale
     */
    public static void init(Locale initLocale) {
        DEFAULT_LOCALE = initLocale;
    }

    static String formatNative(Class cacheKey, Object value, String pattern,
                               boolean cache, Object... args) {
        return formatNative(DEFAULT_LOCALE, cacheKey, value, pattern, cache, args);
    }

    private static FormatterInfo generationFormatterInfo(Object value, String pattern, boolean cache, Object... args) {
        FormatterInfo formatInfo = new FormatterInfo();
        formatInfo.mValue = value;
        formatInfo.mPattern = pattern;
        formatInfo.mData = args;
        formatInfo.mCache = cache;
        return formatInfo;
    }

}
