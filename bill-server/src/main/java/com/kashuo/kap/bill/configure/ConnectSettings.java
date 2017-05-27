package com.kashuo.kap.bill.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 1. 不能加入@Component
 * 2. 从application.yml中读取数据源信息
 * 3. 仅为测试，信息配置从简，连接池等配置未加。
 *
 * 4. 该数据源为：apache tomcat自带的JDBC
 *
 * Created by sunjiawei on 2017/4/18.
 */

@ConfigurationProperties(prefix="jdbc")
public class ConnectSettings {
    private String driverClass;
    private String url;
    private String username;
    private String password;

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //    private String validationQuery = "SELECT 1";
//    private int maxActive = 100;
//    private int maxIdle = 8;
//    private int minIdle = 8;
//    private int initialSize = 10;
//    private boolean testOnBorrow = true;
//    private boolean testOnReturn = false;
//    private boolean testWhileIdle = true;


}
