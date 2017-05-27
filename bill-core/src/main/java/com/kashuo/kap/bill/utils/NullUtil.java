package com.kashuo.kap.bill.utils;

import java.util.Collection;
import java.util.Map;

/**
 * Created by sunjiawei on 2017/5/3.
 */
public class NullUtil {

    /**
     * 判断该对象是否为空判断是否为null
     * 或""为集合长度为0返回true,否则返回false
     * 目前支持Object、String、Map、Collection类型判断
     *
     * @param obj
     * @return boolean
     */
    @SuppressWarnings("all")
    public static boolean isNull(Object obj) {
        if (obj == null) {
            return true;
        } else if (obj instanceof String) {
            return "".equals(obj) ? true : false;
        } else if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            return collection.size() == 0 ? true : false;
        } else if (obj instanceof Object[]) {
            Object[] objs = (Object[]) obj;
            return objs.length == 0 ? true : false;
        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            return map.size() == 0 ? true : false;
        }

        return false;
    }

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }
}
