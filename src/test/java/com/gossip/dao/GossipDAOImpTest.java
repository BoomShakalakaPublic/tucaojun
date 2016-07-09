/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gossip.dao;

import com.tucaomover.dao.GossipDAOImp;
import com.tucaomover.dao.UserDAOImp;
import com.tucaomover.entities.Gossip;
import com.tucaomover.entities.User;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gao
 */
public class GossipDAOImpTest {
    private static User user;
    private static Gossip gossip;
    private String id= "1";
    
    public GossipDAOImpTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        user = new User("testG","passw","testG@test");
        UserDAOImp instance = new UserDAOImp();
        instance.save(user);
    }
    
    @AfterClass
    public static void tearDownClass() {
        UserDAOImp instance=new UserDAOImp();
        instance.delete(user);
    }
    
    @Before
    public void setUp() {
        
        Date today=new Date();
        Timestamp now=new Timestamp(today.getTime());
        gossip = new Gossip(id,"hello","image.jpg",1,2,3,now);
        GossipDAOImp instance = new GossipDAOImp();
        instance.save(gossip);
    }
    
    @After
    public void tearDown() {
        GossipDAOImp instance = new GossipDAOImp();
        instance.delete(gossip);
    }

    /**
     * Test of save method, of class GossipDAOImp.
     */


    /**
     * Test of delete method, of class GossipDAOImp.
     */


    /**
     * Test of getAll method, of class GossipDAOImp.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        GossipDAOImp instance = new GossipDAOImp();
        List<Gossip> expResult = Arrays.asList(gossip);
        List<Gossip> result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class GossipDAOImp.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        GossipDAOImp instance = new GossipDAOImp();
        Gossip expResult = gossip;
        Gossip result = instance.getById(id);
        assertEquals(expResult, result);
    }
    @Test
    public void testUserGossip(){
        System.out.println("User-Gossip");
        GossipDAOImp instance=new GossipDAOImp();
        gossip.getViewedUsers().add(user);
        user.getViewedGossips().add(gossip);
        instance.save(gossip);
        
    }
    
}
