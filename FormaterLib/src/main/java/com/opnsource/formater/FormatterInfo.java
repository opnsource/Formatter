package com.opnsource.formater;

/**
 * Created by liushu on 2015/10/22.
 */
class FormatterInfo {

    /**
     * formater主体
     */
    public Object mValue;

    /**
     * formater 样式
     */
    public String mPattern;

    /**
     * 是否对该Pattern进行cache ,默认为true
     */
    public boolean mCache = true;

    /**
     * 用于formater 字符串
     */
    public Object[] mData;
}
