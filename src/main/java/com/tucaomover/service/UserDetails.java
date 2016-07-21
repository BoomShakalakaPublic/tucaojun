/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.service;

import com.tucaomover.dao.UserDAOImp;
import com.tucaomover.entities.User;
import org.springframework.stereotype.Service;


/**
 *
 * @author gao
 */
@Service
public class UserDetails {   
    
    private UserDAOImp userDao= new UserDAOImp();
    
    public UserDetails(){
        
    }
    
    public User loadByEmail(String email){
        return userDao.getByEmail(email);
    }
    
    
    public boolean userAuth (String email,String password){    
           User user=userDao.getByEmail(email);
           if(user==null){
               return false;
           }
           else{               
           return password.equals(user.getPassword());
           }
 
    }
    
    public boolean addUser(User user){
        if(userDao.isEmailAvai(user.getEmail())){
            userDao.save(user);
            return true;
        }
        else{
            return false;
        }
        
    }
    
}
