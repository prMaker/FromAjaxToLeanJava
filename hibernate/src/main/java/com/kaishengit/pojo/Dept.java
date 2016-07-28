package com.kaishengit.pojo;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Administrator on 2016/7/26.
 */
@Entity
@Table(name = "t_dept")
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String deptname;

    @OneToMany(mappedBy = "dept",cascade = CascadeType.REMOVE)
    private Set<Employee> employeeSet;

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }


    public Dept() {}

    public Dept(String deptname) {
        this.deptname = deptname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }



    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", deptname='" + deptname + '\'' +
                ", employeeSet=" + employeeSet +
                '}';
    }
}
