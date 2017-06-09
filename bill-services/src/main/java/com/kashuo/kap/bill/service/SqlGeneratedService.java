package com.kashuo.kap.bill.service;

import com.kashuo.kap.bill.utils.ConstantUtil;
import com.kashuo.kap.bill.utils.SqlGenerate;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by sunjiawei on 2017/6/9.
 */
@Service
public class SqlGeneratedService {


    public String normal(){
        String sql = SqlGenerate.readFromFile(ConstantUtil.NORMAL_SQL);
//        LOG.info("sql,{}"+sql);
        try {
            SqlGenerate.outputBySql(sql, ConstantUtil.NORMAL_SQL,1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
