/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.service;

import com.tucaomover.dao.GossipDAOImp;
import com.tucaomover.dao.UserDAOImp;
import com.tucaomover.entities.Gossip;
import com.tucaomover.entities.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author gao
 */
@Service
public class PostUtil {
    private GossipDAOImp gossipDao = new GossipDAOImp();
    private UserDAOImp userDao = new UserDAOImp();
    
    @Transactional
    public Gossip loadPost(String PostId){
        Gossip post = gossipDao.getById(PostId);
        return post;
    }
    
    @Transactional
    public void viewed(User user, Gossip gossip){
        user.getViewedGossips().add(gossip);
        userDao.save(user);
    }
}
