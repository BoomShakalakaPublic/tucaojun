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
    private static Configuration configuration = new Configuration().configure();    
   private static StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
   private static final SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());


    public HibernateUtil(){
       
    }
   
   
   public  Session getSession() {
       return sessionFactory.getCurrentSession();
       
   }
   

}
