package com.kashuo.kap.bill.utils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by 冷艳君 on 2016/6/24.
 */
public class CustomStringUtils extends org.springframework.util.StringUtils {
    /**
     * 判断字符串是否为空（去除两边空格比较）
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        return isEmpty(trimBothSidesWhiteSpace(str));
    }

    /**
     * 去除两边空格
     *
     * @param str
     * @return
     */
    public static String trimBothSidesWhiteSpace(String str) {
        if (isEmpty(str)) {
            return str;
        }
        return str.trim();

    }

    /**
     * 判断字符串是否为空（不去除两边空格比较）
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }

    /**
     * 转义mysql中的特殊字符
     *
     * @param str
     * @return
     */
    public static String escapeSpecialCharacterInSQL(String str) {
        str = trimBothSidesWhiteSpace(str);
        if (NullUtil.isNull(str)) {
            return null;
        }
        if (str.contains("\\")) {
            str = str.replaceAll("\\\\", "\\\\\\\\");
        }
        if (str.contains("%")) {
            str = str.replaceAll("%", "\\\\%");
        }
        if (str.contains("_")) {
            str = str.replaceAll("_", "\\\\_");
        }
        return str;
    }


    /**
     * 将字符串类型的数组拼接成字符串（以逗号分隔）
     *
     * @param stringList 字符串数组
     * @return String
     */
    public static String listToString(List<String> stringList) {
        if (NullUtil.isNull(stringList)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : stringList) {
            stringBuilder.append(isEmpty(str) ? "" : str).append(",");
        }
        String resultStr = stringBuilder.toString();
        return resultStr.substring(0, resultStr.length() - 1);
    }

    /**
     * 以逗号分隔字符串，并转换成数组
     *
     * @param str 字符串（元素间以逗号分隔）
     * @return List<String>
     */
    public static List<String> toListSplitByCommas(String str) {
        List<String> list = new ArrayList<>();
        if (!CustomStringUtils.isBlank(str)) {
            str = CustomStringUtils.trimAllWhitespace(str).replaceAll("，", ",");
            list.addAll(Arrays.stream(str.split(",")).filter(NullUtil::isNotNull).collect(Collectors.toList()));
        }
        return list;
    }

    /**
     * 将中文括号转化成英文括号
     *
     * @param str 字符串
     * @return String
     */
    public static String bracketsToEnglish(String str) {
        str = trimBothSidesWhiteSpace(str);
        if (isEmpty(str)) {
            return str;
        }
        return str.replaceAll("（", "(").replaceAll("）", ")");
    }

    /**
     * 将字符串类型的set集合拼接成字符串（以逗号分隔）
     *
     * @param stringSet 字符串集合
     * @return String
     */
    public static String setToString(Set<String> stringSet) {
        if (NullUtil.isNull(stringSet)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : stringSet) {
            str = isEmpty(str) ? "" : str;
            stringBuilder.append(str).append(",");
        }
        String resultStr = stringBuilder.toString();
        return resultStr.substring(0, resultStr.length() - 1);
    }

}
