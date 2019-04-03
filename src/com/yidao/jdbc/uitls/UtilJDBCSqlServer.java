package com.yidao.jdbc.uitls;

import java.sql.*;

/**
 * 如果要使用SQLServerDriver 驱动必须要到sqljdbc4.jar 具体可看文章
 * https://www.cnblogs.com/javahr/p/8276298.html
 */
public class UtilJDBCSqlServer {

    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String USER = "sa";
    private static String PASS = "123qwe.com";
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
    public static void stopMySQLConn() {
        if (conn != null) {
            try {
                conn.close();
                Ulog.i("关闭数据库链接 ");
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
    public static void setlect(String... value) {
        String sql = "SELECT  * FROM TA_Alert where Name like ? and TA_Alert.AlertID > ? and TA_Alert.AlertID < ? ";

        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < value.length; i++) {
                ps.setString(1+1, value[0]);
            }
            ps.setString(1, "%上海市第%人民医院%");
            rs = ps.executeQuery();
            while (rs.next()) {

                Ulog.i("rs.getString( Name )", rs.getString("Name"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        startMySQLConn();
        setlect();
        stopMySQLConn();
    }

}
