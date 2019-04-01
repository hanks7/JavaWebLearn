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
    private static final String URL = "jdbc:sqlserver://172.16.1.86";// 数据库连接字符串，这里的dataBase为数据库名

    static Connection conn = null;
    static Statement statement = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    /**
     * 链接数据库
     */
    public static void startMySQLConn() {
        try {
            // 加载驱动
            Class.forName(driver);
            String url = "jdbc:sqlserver://172.16.1.86;DatabaseName=MDS5";
            String user = "sa";
            String password = "123qwe.com";
            // 获取数据库连接（连上数据库）
            Connection connection = DriverManager.getConnection(url, user, password);
            // 执行查询，返回ResultSet（结果集）

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 使用哪个数据库
     */
    public static void useDB() {
        String sql = "use " + dataBase + ";";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
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
    public static GetCustomerBean setlect() {
        String sql = "SELECT a.Title,a.Name FROM TA_Alert as a WHERE a.Name like '%上海佳婧贸易商行%';";

        GetCustomerBean bean2 = new GetCustomerBean();
        List<CustomerBean> list = new ArrayList<CustomerBean>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            CustomerBean bean;
            while (rs.next()) {
                bean = new CustomerBean();

                bean.setPhone(rs.getString(1));
                bean.setEmail(rs.getString(2));

                list.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        bean2.setList(list);
        return bean2;
    }


    public static void main(String[] args) {
        startMySQLConn();
//        useDB();
//        setlect();
//        Ulog.i( setlect());
//        closeMySQLConn();
    }

}
