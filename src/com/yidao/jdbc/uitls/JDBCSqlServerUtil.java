package com.yidao.jdbc.uitls;

import com.yidao.jdbc.bean.CustomerBean;
import com.yidao.jdbc.bean.GetCustomerBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 如果要使用SQLServerDriver 驱动必须要到sqljdbc4.jar 具体可看文章
 * https://www.cnblogs.com/javahr/p/8276298.html
 */
public class JDBCSqlServerUtil {

    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String USER = "sa";
    private static String PASS = "123qwe.com";
    private static String dataBase = "MDS5";
    private static final String URL = "jdbc:sqlserver://172.16.1.86;DatabaseName=MDS5";
    ;// 数据库连接字符串，这里的dataBase为数据库名

    static Connection conn = null;
    static Statement statement = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;


    /**
     * 链接数据库
     */
    public static void startMySQLConn() {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(URL, USER, PASS);// 输入链接地址 ,账号,密码
            if (!conn.isClosed()) {
                Ulog.i("成功链接到数据库! ");
            }

            statement = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭数据库
     */
    public static void closeMySQLConn() {
        if (conn != null) {
            try {
                conn.close();
                Ulog.i("数据库链接终端 ");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 从数据库中得到name为b的phone的值
     *
     * @return
     */
    public static void setlect() {
        String sql = "SELECT  Name FROM TA_Alert where Name like '%第十%'";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            CustomerBean bean;
            while (rs.next()) {

                Ulog.i("rs.getString(1)", rs.getString(1));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        startMySQLConn();
        setlect();
        closeMySQLConn();
    }

}
