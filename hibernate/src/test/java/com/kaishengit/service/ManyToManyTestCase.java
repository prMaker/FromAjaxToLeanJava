package com.kaishengit.service;

import com.kaishengit.pojo.Student;
import com.kaishengit.pojo.Teacher;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/7/27.
 */
public class ManyToManyTestCase {

    @Test
    public void save(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Teacher teacher1 = new Teacher("T1");
        Teacher teacher2 = new Teacher("T2");

        Student student1 = new Student("S1");
        Student student2 = new Student("S2");

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
        System.out.println(teacher.getId()+":"+teacher.getTeaname());
        for(Student student : teacher.getStudentSet()){
            System.out.println(student.getId()+":"+student.getStuname());
        }
        session.getTransaction().commit();
    }

    @Test
    public void findTeacherAll(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Teacher.class);
        List<Teacher> teacherList = criteria.list();
        for(Teacher teacher : teacherList){
            for(Student student : teacher.getStudentSet()){
                System.out.println(student.getId()+":"+student.getStuname());
            }
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

    @Test
    public void findStudentAll(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        List<Student> studentList = session.createCriteria(Student.class).list();
        for (Student student : studentList){
            for(Teacher teacher : student.getTeacherSet()){
                System.out.println(teacher.getTeaname());
            }
        }

        session.getTransaction().commit();
    }

}
