/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author gao
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal();
    
    public HibernateUtil(){
        
    }
   
   private static SessionFactory configureSessionFactory(){
       try{
           Configuration configuration = new Configuration().addResource("hibernate.cfg.xml").configure();
           StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
           sessionFactory = configuration.buildSessionFactory(builder.build());
       } catch(HibernateException e){
           System.out.append("Exception in SessionFactory");
           e.printStackTrace();
       }
       return sessionFactory;
   }
   
   public static Session getSession() throws HibernateException{
       Session session = threadLocal.get();
       if(session == null|| !session.isOpen()){
           if(sessionFactory == null){
               configureSessionFactory();
           }
        session = (sessionFactory != null) ? sessionFactory.openSession() :null;
        threadLocal.set(session);   
       }
       return session;
       
   }
   
   public static void closeSession() throws HibernateException{
       Session session=(Session) threadLocal.get();
       threadLocal.set(null);
       if(session!=null){
           session.close();
       }
   }
}
