/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.service;

import com.tucaomover.dao.GossipDAOImp;
import com.tucaomover.entities.Gossip;
import com.tucaomover.entities.User;
import static java.lang.Math.log;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author gao
 */
@Service
public class postRanking {
    private GossipDAOImp gossipDao = new GossipDAOImp();
    
    public List<rankingRecord> rank(User user){
        List<Gossip> allPost = gossipDao.getAll();
        Set <Gossip> viewedPost = user.getViewedGossips();
        List<rankingRecord> result = new ArrayList<rankingRecord>();
        for(Gossip post : allPost){
            rankingRecord rr = new rankingRecord(post.getId(),post.getText(),score(post));
            if(viewedPost.contains(post)){
                rr.setScore(rr.getScore()*0.3);
            }
            result.add(rr);
        }
       //Collections.sort(result);
        return result;
    }
    
    private double score(Gossip gossip){
        double result=0;
        result= gossip.getUpNum()*10+gossip.getCommentsNum()*20+gossip.getForwardNum()*30;
        Timestamp now = new Timestamp(new Date().getTime());
        double interval=log((now.getTime()-gossip.getTimeRetrieved().getTime())/3600000);
        result/=interval;
        return result;
                
    }
    
    
}
