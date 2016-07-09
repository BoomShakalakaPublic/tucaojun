/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.dao;

import com.tucaomover.entities.Gossip;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



/**
 *
 * @author gao
 */
public class GossipDAOImp implements GossipDAO{
   private Configuration configuration = new Configuration().configure();    
   private StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
   private SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

    
    @Override
    public void save(Gossip gossip) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        session.saveOrUpdate(gossip);
        tran.commit();
    }

    @Override
    public void delete(Gossip gossip) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        session.delete(gossip);
        tran.commit();
    }

    @Override
    public List<Gossip> getAll() {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        List<Gossip> all=session.createCriteria(Gossip.class).list();
        return all;
        
    }

    @Override
    public Gossip getById(String id) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        Gossip gossip=(Gossip) session.get(Gossip.class, id);
        return gossip;
    }
    
}
