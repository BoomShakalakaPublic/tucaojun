/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gossip.dao;

import com.tucaomover.dao.CommentDAOImp;
import com.tucaomover.dao.GossipDAOImp;
import com.tucaomover.entities.Comment;
import com.tucaomover.entities.Gossip;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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

public class CommentDAOImpTest {
    private static Gossip gossip;
    private Comment comment;
    private String id;
    
    public CommentDAOImpTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    
        Date today = new Date();
        Timestamp now = new Timestamp(today.getTime());
        gossip = new Gossip("2","testforComment","image.com",4,5,6,now);
        GossipDAOImp instance = new GossipDAOImp();
        instance.save(gossip);
    }
    
    @AfterClass
    public static void tearDownClass() {
        GossipDAOImp instance = new GossipDAOImp();
        instance.delete(gossip);
    }
    
    @Before
    public void setUp() {
        id="11";
        comment = new Comment(id, gossip, "hhhhhhhh");
        CommentDAOImp instance = new CommentDAOImp();
        instance.save(comment);
    }
    
    @After
    public void tearDown() {
        CommentDAOImp instance = new CommentDAOImp();
        instance.delete(comment);
    }

    /**
     * Test of save method, of class CommentDAOImp.
     */


    /**
     * Test of delete method, of class CommentDAOImp.
     */


    /**
     * Test of getById method, of class CommentDAOImp.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        CommentDAOImp instance = new CommentDAOImp();
        Comment expResult = comment;
        Comment result = instance.getById(id);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCommentGossip(){
        System.out.println("gossip-comment");
        CommentDAOImp instance = new CommentDAOImp();
        Comment com=instance.getById(id);
        assertEquals(gossip,com.getGossip());
        GossipDAOImp gDao = new GossipDAOImp();
        Gossip g = gDao.getById("2");
        Set<Comment> coms=new HashSet();
        coms.add(comment);
        assertEquals(coms,g.getHotComments());
     
    }
    
}
