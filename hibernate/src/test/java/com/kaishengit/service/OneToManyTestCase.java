package com.kaishengit.service;

import com.kaishengit.pojo.Dept;
import com.kaishengit.pojo.Employee;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/7/26.
 */
public class OneToManyTestCase {

    /*
        1.Hibernate保存时,先存一，再存多
        2.让一的一端放弃关系维护
        3.fetch="join" 解决criteria的 N+1 问题

    */

    @Test
    public void saveTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Dept dept = new Dept("PHP开发部");

        Employee employee1 = new Employee("刘三",dept);
        Employee employee2 = new Employee("李思",dept);

        Set<Employee> employeeSet = new HashSet<Employee>();
        employeeSet.add(employee1);
        employeeSet.add(employee2);
        dept.setEmployeeSet(employeeSet);

        session.save(dept);
        session.save(employee1);
        session.save(employee2);

        session.getTransaction().commit();
    }


    @Test
    public void findByDept(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

//        String hql = "from Dept where id = 19";
//        Query query = session.createQuery(hql);
//        Dept dept = (Dept) query.uniqueResult();
//        System.out.println(dept.getDeptname());
//        for(Employee employee : dept.getEmployeeSet()){
//            System.out.println(employee.getEmpname());
//        }

        String hql = "from Dept";
        Query query = session.createQuery(hql);
        List<Dept> deptList = query.list();
        for(Dept dept : deptList){
            for(Employee employee : dept.getEmployeeSet()){
                System.out.println(employee.getEmpname());
            }
        }

        session.getTransaction().commit();
    }

    @Test
    public void findEmployeeAll(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        // 单个
//        Employee employee = (Employee) session.get(Employee.class,42);
//        System.out.println(employee.getEmpname());
//        System.out.println(employee.getId()+":"+employee.getEmpname()+":"+
//                           employee.getDept().getDeptname());

        // 多个 使用criteria
//        List<Employee> employeeList = session.createCriteria(Employee.class).list();

        // 多个使用hql
//        List<Employee> employeeList = session.createQuery("from Employee").list();

        // 多个 使用native sql
        List<Employee> employeeList = session.createSQLQuery("SELECT * FROM t_employee").addEntity(Employee.class).list();

        for(Employee employee : employeeList){
            System.out.println(employee.getId()+":"+employee.getEmpname()+":"+
                           employee.getDept().getDeptname());
        }

        session.getTransaction().commit();
    }


    @Test
    public void findEmployee(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Employee employee = (Employee) session.get(Employee.class,42);
        System.out.println(employee.getEmpname());
        System.out.println(employee.getDept().getDeptname());


        session.getTransaction().commit();
    }

    @Test
    public void delete(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Dept dept = (Dept) session.get(Dept.class,19);
        session.delete(dept);

        session.getTransaction().commit();
    }













}
