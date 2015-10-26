package com.opnsource.formatter;

/**
 * Created by liushu on 2015/10/22.
 */
class FormatterInfo {

    /**
     * formater value
     */
    public Object mValue;

    /**
     * formater style
     */
    public String mPattern;

    /**
     * Need to cache,true is Need
     */
    public boolean mCache = true;

    /**
     * Parameters to format strings
     */
    public Object[] mData;
}
