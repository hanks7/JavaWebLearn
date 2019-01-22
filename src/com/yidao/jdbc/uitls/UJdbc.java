package com.yidao.jdbc.uitls;

import com.yidao.jdbc.bean.CustomerBean;
import com.yidao.jdbc.bean.GetCustomerBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UJdbc {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String dataBase = "tarena";
    private static String user = "root";
    private static String pass = "root";

    private static final String URL = "jdbc:mysql://localhost:3306/";// 数据库连接字符串，这里的dataBase为数据库名

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
            conn = DriverManager.getConnection(URL, user, pass);// 输入链接地址 ,账号,密码
            if (!conn.isClosed()) {
                Ulog.i("成功链接到数据库!");
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
                Ulog.i("数据库链接终端");
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
    private static int insertBatch() {
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
        String sql = "select id,name,phone,email from customer limit 2;";
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
     * @param args
     */
    public static void main(String[] args) {

        startMySQLConn();// 启动数据库服务
        useDB();// 使用哪一个数据库
//		 for(int i=0;i<20 ; i++){
//		 insert(new CustomerBean("sfas333d"+i,"4321"+i,"12693@qq.com"+i));
//		 }
//		delete(1);
        // 查询数据库得到结果
//        insertBatch();
        UtilGson.GsonToJson(setlect());

    }

}
