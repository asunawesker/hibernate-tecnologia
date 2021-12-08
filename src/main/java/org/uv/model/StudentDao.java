/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uv.model;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.uv.hibernateconfig.HibernateUtil;

/**
 *
 * @author asunawesker
 */
public class StudentDao implements IDaoGeneral<Student>{
    
    Session session = HibernateUtil.getSessionFactory().openSession();
    
    @Override
    public void create(Student pojo) {
        session.beginTransaction();
        session.save(pojo);
        session.getTransaction().commit();
    }

    @Override
    public void detele(Student pojo) {
        session.beginTransaction();
        session.delete(pojo);
        session.getTransaction().commit();
    }

    @Override
    public Student readOne(Student pojo) {
        return session.find(Student.class, pojo.getIdcard());
    }

    @Override
    public List<Student> readAll() {
        Query query = (Query) session.createQuery("FROM student");
        return (List<Student>) query.list();
    }

    @Override
    public void update(Student pojo) {
        session.beginTransaction();
        session.update(pojo);
        session.getTransaction().commit();
    }
}
