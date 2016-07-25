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
    private String postId;
    private String text;
    private double score;
    
    public RankRecord(){
        
    }
    
    public RankRecord(String id, String content, double score){
        this.postId=id;
        this.text=content;
        this.score=score;
    }


    @Override
    public int compareTo(RankRecord o1) {
        return this.score<o1.getScore() ? -1 : this.score==o1.getScore() ? 0 : 1;
    }

    /**
     * @return the postId
     */
    public String getPostId() {
        return postId;
    }

    /**
     * @param postId the postId to set
     */
    public void setPostId(String postId) {
        this.postId = postId;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

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

    
    
}
