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
public class CourseDao implements IDaoGeneral<Course>{
    
    Session session = HibernateUtil.getSessionFactory().openSession();
    
    @Override
    public void create(Course pojo) {
        session.beginTransaction();
        session.save(pojo);
        session.getTransaction().commit();
    }

    @Override
    public void detele(Course pojo) {
        session.beginTransaction();
        session.delete(pojo);
        session.getTransaction().commit();
    }

    @Override
    public Course readOne(Course pojo) {
        return session.find(Course.class, pojo.getId());
    }

    @Override
    public List<Course> readAll() {
        Query query = (Query) session.createQuery("FROM course");
        return (List<Course>) query.list();
    }

    @Override
    public void update(Course pojo) {
        session.beginTransaction();
        session.update(pojo);
        session.getTransaction().commit();
    }
    
}
