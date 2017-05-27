package com.kashuo.kap.bill.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * java 8 中 localDate和localTime
 * Created by sunjiawei on 2017/4/12.
 */
public class DateUtil {

    public static String  testDate(){
        LocalDate today = LocalDate.now();//获取当天日期
        LocalDate oneDay = convertInt(2017,5,12);//输出2017-05-12
        LocalDate hasDay = convertString("2017/3/4");//输出2017-03-04

//        String result = toString(hasDay);
        String result = toString("2017/3/4");

        return "\n today: "+today+"\n one day: "+oneDay+
                "\n test: "+hasDay+
                "\n result: "+result;
    }

//    public static void main(String[] args){
//        String date = testDate();
//        System.out.println("date: "+date);
//        test();
//    }




    /**
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    private static LocalDate convertInt(int year, int month, int day){
        return LocalDate.of(year, month, day);
    }

    private static LocalDate convertInt(String[] dateArray){
        int year = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int day = Integer.parseInt(dateArray[2]);
        return LocalDate.of(year, month, day);
    }

    public static LocalDate convertString(String dateStr){

        if (dateStr.contains("/")){
            String[] dateArray = dateStr.split("/");
            if (dateArray.length!=3)
            {
                return null;
            }
            int year = Integer.parseInt(dateArray[0]);
            int month = Integer.parseInt(dateArray[1]);
            int day = Integer.parseInt(dateArray[2]);
            return LocalDate.of(year, month, day);
        }
        return null;
    }

    /**
     *
     * @param strTemp 可以是日期，也可以是时间格式
     * @return
     */
    public static String toString(String strTemp){
        StringBuilder sb = new StringBuilder();

        if (strTemp.contains("/")||strTemp.contains("-")||strTemp.contains(":")){
            String[] dateArray = strTemp.split("/")==null ?strTemp.split("-"):strTemp.split("/");
            if (dateArray.length<=1 && dateArray[0].contains(":")){
                dateArray = strTemp.split(":");
            }
            if (dateArray.length<=1 && dateArray[0].contains("-")){
                dateArray = strTemp.split("-");
            }
            if (dateArray.length!=3)
            {
                return null;
            }
            sb.append(dateArray[0]).
                    append(convertType(dateArray[1])).
                    append(convertType(dateArray[2]));
        }


        return sb.toString();
    }


    /***
     * LocalDate 转换成String
     * 如：2017-04-12
     * 20170412
     * @param today
     * @return
     */
    public static String toString(LocalDate today){
        StringBuilder sb = new StringBuilder();
        int year  = today.getYear();
        String month = convertType(today.getMonthValue());;
        String day = convertType(today.getDayOfMonth());
        sb.append(year).append(month).append(day);
        return sb.toString();
    }


    /**
     * 1.1. 按照标准格式输出：比如5，输出则是05
     * @param number
     * @return
     */
    private static String convertType(int number){
       return number<10?"0"+number:number+"";
    }

    /**
     *1.2.按照标准格式输出：比如"5"，输出则是"05"
     * @param numberStr
     * @return
     */
    private static String convertType(String numberStr){
        int number = Integer.parseInt(numberStr);
        return convertType(number);
    }

}
