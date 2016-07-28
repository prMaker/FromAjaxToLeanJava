package com.kaishengit.pojo;

import org.hibernate.annotations.Fetch;
import org.hibernate.sql.Delete;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/7/26.
 */
@Entity
@Table(name = "t_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String empname;
    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptid")
    private Dept dept;

    public Employee() {}

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
                ", empname='" + empname + '\'' +
                ", dept=" + dept +
                '}';
    }
}
