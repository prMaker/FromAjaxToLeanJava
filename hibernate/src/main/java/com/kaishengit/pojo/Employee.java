package com.kaishengit.pojo;

/**
 * Created by Administrator on 2016/7/26.
 */
public class Employee {

    private Integer id;
    private Integer deptid;
    private String empname;
    private Dept dept;

    public Employee() {
    }

    public Employee(String empname, Dept dept) {
        this.empname = empname;
        this.dept = dept;
    }

    public Employee(String empname) {
        this.empname = empname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", deptid=" + deptid +
                ", empname='" + empname + '\'' +
                ", dept=" + dept +
                '}';
    }
}
