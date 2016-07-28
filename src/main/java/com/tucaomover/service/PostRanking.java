/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.service;

import com.tucaomover.entities.RankRecord;
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
public class PostRanking {
    private GossipDAOImp gossipDao = new GossipDAOImp();
    
    public List<RankRecord> rank(User user){
        List<Gossip> allPost = gossipDao.getAll();
        Set <Gossip> viewedPost = user.getViewedGossips();
        List<RankRecord> result = new ArrayList<RankRecord>();
        for(Gossip post : allPost){
            RankRecord rr = new RankRecord(post,score(post));
            if(viewedPost.contains(post)){
                rr.setScore(rr.getScore()*0.1);
            }
            result.add(rr);
        }
       Collections.sort(result,Collections.reverseOrder());
        return result;
    }
    
    private double score(Gossip gossip){
        double result=0;
        result= (gossip.getUpNum()+gossip.getCommentsNum()+gossip.getForwardNum())*10;
        Timestamp now = new Timestamp(new Date().getTime());
        double interval=log((now.getTime()-gossip.getTimeRetrieved().getTime())/60000+1);
        result=result/interval;
        return result;
                
    }
    
    
}
