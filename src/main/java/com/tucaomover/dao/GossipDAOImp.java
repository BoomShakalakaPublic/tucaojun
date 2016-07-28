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
    private static HibernateUtil hibernateUtil= new HibernateUtil();
    
    @Override
    public void save(Gossip gossip) {
        Session session=hibernateUtil.getSession();
        Transaction tran=session.beginTransaction();
        session.saveOrUpdate(gossip);
        tran.commit();
      
    }

    @Override
    public void delete(Gossip gossip) {
        Session session=hibernateUtil.getSession();
        Transaction tran=session.beginTransaction();
        session.delete(gossip);
        tran.commit();
        
    }

    @Override
    public List<Gossip> getAll() {
        Session session=hibernateUtil.getSession();
        Transaction tran=session.beginTransaction();
        Criteria criteria = session.createCriteria(Gossip.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Gossip> all=criteria.list();
        tran.commit();
        return all;
        
    }

    @Override
    public Gossip getById(String id) {
        Session session=hibernateUtil.getSession();
        Transaction tran=session.beginTransaction();
        Gossip gossip=(Gossip) session.get(Gossip.class, id);
        tran.commit();
        return gossip;
    }
    
}
