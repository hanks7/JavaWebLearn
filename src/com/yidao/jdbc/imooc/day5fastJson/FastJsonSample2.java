package com.yidao.jdbc.imooc.day5fastJson;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.yidao.jdbc.uitls.Ulog;

public class FastJsonSample2 {
    public static void main(String[] args) {
        String json = initData();

        List<Employee> emps = JSON.parseArray(json, Employee.class);

        for (Employee e : emps) {
            Ulog.i(e.getEmpno() + ":" + e.getEname());
        }

    }

    /**
     * 制造假数据
     * @return
     */
    private static String initData() {
        List emplist = new ArrayList();

        for (int i = 1; i <= 100; i++) {
            Employee employee = new Employee();
            employee.setEmpno(4488 + i);
            employee.setEname("员工" + i);
            emplist.add(employee);
        }

        String json = JSON.toJSONString(emplist);
        Ulog.i(json);
        return json;
    }
}
