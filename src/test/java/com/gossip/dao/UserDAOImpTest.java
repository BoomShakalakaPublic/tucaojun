/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gossip.dao;

import com.gossip.entities.User;
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
public class UserDAOImpTest {
    private  User user ;
    private  Long id;
    
    public UserDAOImpTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("save");
        user=new User("test","test","test@test");
        UserDAOImp instance = new UserDAOImp();
        id=instance.save(user);
        
    }
    
    @After
    public void tearDown() {
        UserDAOImp instance = new UserDAOImp();
        instance.delete(user);
        
    }

    /**
     * Test of save method, of class UserDAOImp.
     */


    /**
     * Test of delete method, of class UserDAOImp.
     */


    /**
     * Test of getById method, of class UserDAOImp.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        UserDAOImp instance = new UserDAOImp();
        User expResult = user;
        User result = instance.getById(id);
        assertEquals(expResult, result);

    }

    /**
     * Test of getByEmail method, of class UserDAOImp.
     */
    @Test
    public void testGetByEmail() {
        System.out.println("getByEmail");
        String email = "test@test";
        UserDAOImp instance = new UserDAOImp();
        User expResult = user;
        User result = instance.getByEmail(email);
        assertEquals(expResult, result);

    }
    
}
