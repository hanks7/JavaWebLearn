package com.yidao.jdbc.imooc.day5fastJson;

import java.util.Calendar;

import com.alibaba.fastjson.JSON;
import com.yidao.jdbc.uitls.Ulog;

public class FastJsonSample1 {
	public static void main(String[] args) {
		Employee employee = new Employee();

		employee.setEmpno(4488);
		employee.setEname("王晓东");
		employee.setJob("客户经理");
		employee.setSalary(10000f);
		employee.setDname("市场部");

		Calendar c = Calendar.getInstance();
		c.set(2019, 0, 30, 0, 0, 0);
		employee.setHdate(c.getTime());

		//FastJSON中提供了JSON对象，完成对象与JSON字符串的互相转换
		String json = JSON.toJSONString(employee);

		Ulog.i(json);
		Employee emp = JSON.parseObject(json, Employee.class);
		Ulog.i(emp.getEname());
		Ulog.i(emp);
	}
}
