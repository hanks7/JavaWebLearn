package com.yidao.jdbc.uitls;

import com.yidao.jdbc.bean.CustomerBean;
import com.yidao.jdbc.bean.GetCustomerBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 如果要使用SQLServerDriver 驱动必须要到mysql-connector-java-5.1.34-bin.jar
 */
public class UtilJdbc {

    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;


    /**
     * 链接数据库
     */
    public static void startMySQLConn() {
        String driver = "com.mysql.jdbc.Driver";
        String dataBase = "tarena";
        String USER = "root";
        String PASS = "root";
        String URL = "jdbc:mysql://localhost:3306/";// 数据库连接字符串，这里的dataBase为数据库名

        init(driver, USER, PASS, URL);
    }

    /**
     * 链接数据库
     */
    public static void startSqlServerConn() {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String USER = "sa";
        String PASS = "123qwe.com";
        String URL = "jdbc:sqlserver://172.16.1.86;DatabaseName=MDS5";

        init(driver, USER, PASS, URL);
    }

    /**
     * 关闭数据库
     */
    public static void stopMySQLConn() {

        try {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
            Ulog.i("关闭数据库链接 ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 使用哪个数据库
     */
    public static void useDB() {
        String dataBase = "tarena";
        String sql = "use " + dataBase + ";";
        try {
            ps = conn.prepareStatement(sql);
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void init(String driver, String USER, String PASS, String URL) {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(URL, USER, PASS);// 输入链接地址 ,账号,密码
            if (!conn.isClosed()) {
                Ulog.i("打开数据库连接");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 从数据库中得到name为b的phone的值
     *
     * @return
     */
    public static ResultSet query(String sql, String... value) {
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < value.length; i++) {
                ps.setString(i + 1, value[i]);
            }
            resultSet = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * 增加
     *
     * @param bean
     * @return
     */
    private static int insert(CustomerBean bean) {
        int i = 0;

        String sql = "insert into customer (name,phone,email) values(?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, bean.getName());
            ps.setInt(2, Integer.valueOf(bean.getPhone()));
            ps.setString(3, bean.getEmail());
            i = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Ulog.i("insert-success", i);
        return i;
    }

    /**
     * 批量增加
     */
    public static int insertBatch() {
        int[] i;
        String sql = "insert into customer (name,phone,email) values(?,?,?)";
        try {
            conn.setAutoCommit(false);//取消自动提交事务
            ps = conn.prepareStatement(sql);
            for (int j = 110; j < 199; j++) {
                ps.setString(1, j + "fklajsdkfl");
                ps.setInt(2, j);
                ps.setString(3, j + "fklajsdkfl");
                ps.addBatch();
            }

            i = ps.executeBatch();
            Ulog.i("insert-success", i.length);
            for (int j = 0; j < i.length; j++) {

                if (i[j] == 0) {
                    Ulog.i("insert-success", i[j]);
                }
            }
            ps.close();
            conn.commit();//在这里提交数据事务,如果有一条事务出错,所有事务都进行回滚
        } catch (SQLException e) {
            Ulog.i("数据库", "事务提交出错");
            e.printStackTrace();
        }


        return 0;
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    private static int delete(int id) {
        int i = 0;
        String sql = "delete from customer   where id= ? ;";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            i = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Ulog.i("insert-success", i);
        return i;
    }

    /**
     * 改
     *
     * @param id
     * @param name
     * @return
     */
    private static int update(int id, String name) {
        int i = 0;
        String sql = "update customer set name= ? where id= ? ;";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(2, id);
            ps.setString(1, name);
            i = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Ulog.i("insert-success", i);
        return i;
    }

    /**
     * 从数据库中得到name为b的phone的值
     *
     * @return
     */
    public static GetCustomerBean setlect() {
        String sql = "select id,name,phone,email from customer limit 10;";
        GetCustomerBean bean2 = new GetCustomerBean();
        List<CustomerBean> list = new ArrayList<CustomerBean>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            CustomerBean bean;
            while (rs.next()) {
                bean = new CustomerBean();

                bean.setId(Integer.valueOf(rs.getString(1)));
                bean.setName(rs.getString(2));
                bean.setPhone(rs.getString(3));
                bean.setEmail(rs.getString(4));

                list.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        bean2.setList(list);
        return bean2;
    }

    /**
     * 从数据库中得到name为b的phone的值
     *
     * @return
     */
    public static void setlect(int limitNum) {
        String sql = "select id,name,phone,email from customer limit ?;";
        List<CustomerBean> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, limitNum);
            rs = ps.executeQuery();
            CustomerBean bean;
            while (rs.next()) {
                bean = new CustomerBean();

                bean.setId(Integer.valueOf(rs.getString(1)));
                bean.setName(rs.getString(2));
                bean.setPhone(rs.getString(3));
                bean.setEmail(rs.getString(4));
                Ulog.i("bean", bean.toString());

                list.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws SQLException {

//        mysql();

        sqlServer();

    }

    private static void sqlServer()   {
        startSqlServerConn();
        ResultSet resultSet = query("SELECT  * FROM TA_Alert where Name like ? and TA_Alert.AlertID > ? and TA_Alert.AlertID < ? ",
                "%上海市第%人民医院%",
                "20170531000168",
                "20170531000235");
        try {
            while (resultSet.next()) {
                Ulog.i("rs.getString( Name )", resultSet.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        stopMySQLConn();
    }

    private static void mysql() {
        startMySQLConn();// 启动数据库服务
        useDB();// 使用哪一个数据库
//		 for(int i=0;i<20 ; i++){
//		 insert(new CustomerBean("sfas333d"+i,"4321"+i,"12693@qq.com"+i));
//		 }
//		delete(1);
        // 查询数据库得到结果
//        insertBatch();
//        Ugson.toJson(setlect());
        setlect(10);
    }

}
