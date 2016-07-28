package com.kaishengit.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Administrator on 2016/7/27.
 */
/*
TODO 重做多对多
 */
@Entity
@Table(name = "t_teacher")
public class Teacher implements Serializable{
    private static final long serialVersionUID = -4625830563325271234L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String teaname;

    @ManyToMany(mappedBy = "teacherSet",cascade = CascadeType.REMOVE)
    @OrderBy("id desc ")
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
