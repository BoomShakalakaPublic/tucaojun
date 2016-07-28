/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.entities;

import java.util.Comparator;

/**
 *
 * @author gao
 */
public class RankRecord implements Comparable<RankRecord>{
    private Gossip gossip;
    private double score;
    
    public RankRecord(){
        
    }
    
    public RankRecord(Gossip g, double score){
        this.gossip=g;
        this.score=score;
    }


    @Override
    public int compareTo(RankRecord o1) {
        return this.score<o1.getScore() ? -1 : this.score==o1.getScore() ? 0 : 1;
    }

    /**
     * @return the postId
     */
    
    /**
     * @return the score
     */
    public double getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * @return the gossip
     */
    public Gossip getGossip() {
        return gossip;
    }

    /**
     * @param gossip the gossip to set
     */
    public void setGossip(Gossip gossip) {
        this.gossip = gossip;
    }

    
    
}
