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
public class ProfessorDao implements IDaoGeneral<Professor>{
    
    Session session = HibernateUtil.getSessionFactory().openSession();
    
    @Override
    public void create(Professor pojo) {
        session.beginTransaction();
        session.save(pojo);
        session.getTransaction().commit();
    }

    @Override
    public void detele(Professor pojo) {
        session.beginTransaction();
        session.delete(pojo);
        session.getTransaction().commit();
    }

    @Override
    public Professor readOne(Professor pojo) {
        return session.find(Professor.class, pojo.getIdcard());
    }

    @Override
    public List<Professor> readAll() {
        Query query = (Query) session.createQuery("FROM professor");
        return (List<Professor>) query.list();
    }

    @Override
    public void update(Professor pojo) {
        session.beginTransaction();
        session.update(pojo);
        session.getTransaction().commit();
    }
}
