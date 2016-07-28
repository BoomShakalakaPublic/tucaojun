/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.service;

import com.tucaomover.entities.RankRecord;
import com.tucaomover.dao.UserDAOImp;
import com.tucaomover.entities.User;
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
public class PostRankingTest {
    private static User user;
    public PostRankingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        user = new User("testG","passw","testG@test.com");
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of rank method, of class postRanking.
     */
    @Test
    public void testRank() {
        System.out.println("rank");
        PostRanking instance = new PostRanking();
        List<RankRecord> result = instance.rank(user);
        for(RankRecord r : result){
            System.out.println(r.getGossip().getId()+"  "+ r.getScore());
        }
        
    }
    
}
