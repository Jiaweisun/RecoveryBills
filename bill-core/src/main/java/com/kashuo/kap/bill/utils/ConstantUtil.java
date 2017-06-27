package com.kashuo.kap.bill.utils;

/**
 * Created by sunjiawei on 2017/5/11.
 */
public class ConstantUtil {

    // numeric
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;


    //
    public static final int handFlag = 90;
    public static final String transComment = "手工加入单边账";
    public static final String acqChannel = "SXFPAY";

    public static final String BANK = "bank";
    public static final String NORMAL = "normal";

// paymentType
    public static final String LONG = "LONGPAY";
    public static final String OTHER = "OTHER";


    //file template path
    public static final String NORMAL_SQL = "D:\\workspace\\kap-all\\RecoveryBills\\file\\单边账模板SQL.txt";
    public static final String BANK_SQL = "D:\\workspace\\kap-all\\RecoveryBills\\file\\银行活动模板SQL.txt";
    public static final String BASE_FILE_PATH = "D:\\workspace\\kap-all\\RecoveryBills\\file\\";
    public static final String rootPath = "d:\\upload\\";

    //sql
    public static final String NORMAL_SQL_P = "insert into transaction" +
            "(trans_no,order_no,merchant_id,store_id,store_channel, trans_date,trans_time,total_amount,agency_id,device_sn,terminal_number," +
            "status,trans_type,pay_amount,trans_rate,total_profit,acquirer_id,acq_channel,payment_type,card_number,bank_name,trans_comment,created_at,updated_at) " +
            "values( ";
}
