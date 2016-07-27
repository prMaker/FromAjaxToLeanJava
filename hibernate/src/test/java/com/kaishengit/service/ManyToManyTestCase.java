package com.kaishengit.service;

import com.kaishengit.pojo.Student;
import com.kaishengit.pojo.Teacher;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/7/27.
 */
public class ManyToManyTestCase {

    @Test
    public void save(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Teacher teacher1 = new Teacher("战三");
        Teacher teacher2 = new Teacher("李思");

        Student student1 = new Student("Tom");
        Student student2 = new Student("Jim");

        Set<Teacher> teacherSet = new HashSet<Teacher>();
        teacherSet.add(teacher1);
        teacherSet.add(teacher2);

        student1.setTeacherSet(teacherSet);
        student2.setTeacherSet(teacherSet);

        Set<Student> studentSet = new HashSet<Student>();
        studentSet.add(student1);
        studentSet.add(student2);

        teacher1.setStudentSet(studentSet);
        teacher2.setStudentSet(studentSet);

        session.save(teacher1);
        session.save(teacher2);
        session.save(student1);
        session.save(student2);

        session.getTransaction().commit();
    }

    @Test
    public void findTeacher(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Teacher teacher = (Teacher) session.get(Teacher.class,20);
        System.out.println(teacher.getTeaname());
        for(Student student : teacher.getStudentSet()){
            System.out.println(student.getStuname());
        }

        session.getTransaction().commit();
    }

    @Test
    public void findStudent(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Student student = (Student) session.get(Student.class,21);
        System.out.println(student.getStuname());
        for(Teacher teacher : student.getTeacherSet()){
            System.out.println(teacher.getTeaname());
        }

        session.getTransaction().commit();
    }


}
