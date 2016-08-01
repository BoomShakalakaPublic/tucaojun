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
    
  private static HibernateUtil hibernateUtil= new HibernateUtil();

    @Override
    public Long save(User user) {
        Session session=hibernateUtil.getSession();
        Transaction tran = session.beginTransaction();
        session.saveOrUpdate(user);
        try{
            tran.commit();
        } catch(RuntimeException e){
            tran.rollback();
            throw e;
        }
  tran.commit();
      
        return user.getId();
    }
    

    @Override
    public void delete(User user) {
       Session session=hibernateUtil.getSession();
        Transaction tran=session.beginTransaction();
        session.delete(user);        
        try{
            tran.commit();
        } catch(RuntimeException e){
            tran.rollback();
            throw e;
        }
  
     
        
    }

    @Override
    public User getById(Long id) {
        Session session=hibernateUtil.getSession();
        Transaction tran=session.beginTransaction();
        User user=(User) session.get(User.class,id);
        try{
            tran.commit();
        } catch(RuntimeException e){
            tran.rollback();
            throw e;
        }
  
       
        return user;        
        
    }

    @Override
    public User getByEmail(String email) {
        Session session=hibernateUtil.getSession();
        Transaction tran=session.beginTransaction();
        Criteria criteria=session.createCriteria(User.class);
        User user=(User) criteria.add(Restrictions.eq("email",email)).uniqueResult();
        try{
            tran.commit();
        } catch(RuntimeException e){
            tran.rollback();
            throw e;
        }
  
        
        return user;
        
    }

    @Override
    public boolean isEmailAvai(String email) {
        User user = getByEmail(email);
        return user==null;
    }
    
    
}
