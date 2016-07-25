/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.dao;

import com.tucaomover.entities.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author gao
 */
public class CommentDAOImp implements CommentDAO{

   private Configuration configuration = new Configuration().configure();
   
   private StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
   private SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
    
    @Override
    public void save(Comment comment) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        session.saveOrUpdate(comment);
        tran.commit();
  
    }

    @Override
    public void delete(Comment comment) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        session.delete(comment);
        tran.commit();

    }

    @Override
    public Comment getById(String id) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        Comment comment=(Comment) session.get(Comment.class, id);
        tran.commit();
        return comment;
    }
    
}
