package com.yidao.jdbc.imooc.day5fastJson;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Employee {

    private Integer empno;
    private String ename;
    private String job;

    //@JSONField(format="yyyy-MM-dd HH:mm:ss SSS")//这是正常的转换时间格式 下面的注解多了一个name属性,为的是修改原来的属性名称
    @JSONField(name = "hiredate", format = "yyyy-MM-dd")//这个name在json中就显示为hiredate,就不显示为hdate
    private Date hdate;

    private Float salary;

    @JSONField(serialize = false)//表示不对他进行序列化, 被解析成json,该字段不会显示在其中
    private String dname;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getHdate() {
        return hdate;
    }

    public void setHdate(Date hdate) {
        this.hdate = hdate;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("empno=").append(empno);
        sb.append(", ename='").append(ename).append('\'');
        sb.append(", job='").append(job).append('\'');
        sb.append(", hdate=").append(hdate);
        sb.append(", salary=").append(salary);
        sb.append(", dname='").append(dname).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
