package com.kaishengit.pojo;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Administrator on 2016/7/27.
 */
/*
TODO 重做多对多
 */
public class Teacher implements Serializable{
    private static final long serialVersionUID = -4625830563325271234L;

    private Integer id;
    private String teaname;
    private Set<Student> studentSet;

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public Teacher(String teaname) {
        this.teaname = teaname;
    }

    public Teacher() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeaname() {
        return teaname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teaname='" + teaname + '\'' +
                ", studentSet=" + studentSet +
                '}';
    }
}
