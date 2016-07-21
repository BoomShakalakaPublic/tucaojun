/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.dao;

import com.tucaomover.entities.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author gao
 */
public class UserDAOImp implements UserDAO{
    
   private Configuration configuration = new Configuration().addResource("hibernate.cfg.xml").configure();
   private StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
   private SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

    @Override
    public Long save(User user) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran = session.beginTransaction();
        session.saveOrUpdate(user);
        tran.commit();
        return user.getId();
    }
    

    @Override
    public void delete(User user) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        session.delete(user);
        tran.commit();
        
    }

    @Override
    public User getById(Long id) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        User user=(User) session.get(User.class,id);
        tran.commit();
        return user;        
        
    }

    @Override
    public User getByEmail(String email) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        Criteria criteria=session.createCriteria(User.class);
        User user=(User) criteria.add(Restrictions.eq("email",email)).uniqueResult();
        tran.commit();
        return user;
        
    }

    @Override
    public boolean isEmailAvai(String email) {
        User user = getByEmail(email);
        return user==null;
    }
    
    
}
