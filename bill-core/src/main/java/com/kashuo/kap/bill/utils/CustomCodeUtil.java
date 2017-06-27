package com.kashuo.kap.bill.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * 自定义code规则
 * Created by sunjiawei on 2017/5/11.
 */
public class
CustomCodeUtil {

    private static Logger log = LoggerFactory.getLogger(CustomCodeUtil.class);

    /**
     *
     * @param beginIndex 开始下标
     * @param endIndex 结束下标
     * @return
     */
    private static String generatedRandomCode(int beginIndex, int endIndex){
        return UUID.randomUUID().toString().substring(beginIndex,endIndex);
    }

    /**
     * 规则： 日期+时间+手动标识（90）+随机数（4位）
     * @param dateStr 日期
     * @param timeStr 时间
     * @return
     */
    public  static String generatedTransNo(String dateStr, String timeStr){
        StringBuilder sb = new StringBuilder();

        if (dateStr == null || dateStr =="" || timeStr==null ||timeStr ==""){
            return "";
        }
        dateStr = DateUtil.toString(dateStr);
        timeStr = DateUtil.toString(timeStr);
        sb.append(dateStr).append(timeStr).append(ConstantUtil.handFlag).append(generatedRandomCode(ConstantUtil.ZERO,ConstantUtil.FOUR));
        log.info("sb: {}",sb);

        return sb.toString();
    }

    public static void main(String[] args){
        generatedTransNo("2017-06-25\n","18:57:40\n");
    }
}
