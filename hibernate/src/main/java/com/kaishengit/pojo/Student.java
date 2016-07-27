package com.kaishengit.pojo;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Administrator on 2016/7/27.
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 7344650489859757252L;

    private Integer id;
    private String stuname;
    private Set<Teacher> teacherSet;

    public Set<Teacher> getTeacherSet() {
        return teacherSet;
    }

    public void setTeacherSet(Set<Teacher> teacherSet) {
        this.teacherSet = teacherSet;
    }

    public Student(String stuname) {
        this.stuname = stuname;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuname='" + stuname + '\'' +
                ", teacherSet=" + teacherSet +
                '}';
    }
}
