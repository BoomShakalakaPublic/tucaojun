/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author gao
 */
@Entity
@Table
public class Gossip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id    
    private String id;
    @Column
    private Timestamp timeRetrieved;

    @Column
    private String text;
    @Column
    private String imageURL;
    @Column
    private long upNum;
    @Column
    private long forwardNum;
    @Column
    private long commentsNum;
    @OneToMany(mappedBy="gossip", cascade=CascadeType.REMOVE)
    private Set<Comment> hotComments;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinTable(name = "user_gossip",joinColumns = { 
                    @JoinColumn(name = "gossip_id", nullable = false, updatable = false) }, 
                    inverseJoinColumns = { @JoinColumn(name = "user_id", 
                                    nullable = false, updatable = false) })
    private Set<User> viewedUsers = new HashSet();
    
    public Gossip(){
        this.hotComments = new HashSet();
    
    }

    public Gossip(String id,String text, String imageURL, long upNum, long forwardNum,long commentsNum, Timestamp time){
        this.hotComments = new HashSet();
        this.id=id;
        this.text=text;
        this.imageURL=imageURL;
        this.commentsNum=commentsNum;
        this.upNum=upNum;
        this.forwardNum=forwardNum;
        this.timeRetrieved=time;
    }
    
    
    
    //Getter and setter
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gossip)) {
            return false;
        }
        Gossip other = (Gossip) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tucaomover.entities.Gossip[ id=" + id + " ]";
    }

    /**
     * @return the timeRetrieved
     */
    public Timestamp getTimeRetrieved() {
        return timeRetrieved;
    }

    /**
     * @param timeRetrieved the timeRetrieved to set
     */
    public void setTimeRetrieved(Timestamp timeRetrieved) {
        this.timeRetrieved = timeRetrieved;
    }

    /**
     * @return the timeLastVisited


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
     * @return the imageURL
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * @param imageURL the imageURL to set
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * @return the upNum
     */
    public long getUpNum() {
        return upNum;
    }

    /**
     * @param upNum the upNum to set
     */
    public void setUpNum(long upNum) {
        this.upNum = upNum;
    }

    /**
     * @return the forwardNum
     */
    public long getForwardNum() {
        return forwardNum;
    }

    /**
     * @param forwardNum the forwardNum to set
     */
    public void setForwardNum(long forwardNum) {
        this.forwardNum = forwardNum;
    }

    /**
     * @return the commentsNum
     */
    public long getCommentsNum() {
        return commentsNum;
    }

    /**
     * @param commentsNum the commentsNum to set
     */
    public void setCommentsNum(long commentsNum) {
        this.commentsNum = commentsNum;
    }

    /**
     * @return the hotComments
     */
    public Set<Comment> getHotComments() {
        return hotComments;
    }

    /**
     * @param hotComments the hotComments to set
     */
    public void setHotComments(Set<Comment> hotComments) {
        this.hotComments = hotComments;
    }

    /**
     * @return the viewedUsers
     */
    public Set<User> getViewedUsers() {
        return viewedUsers;
    }

    /**
     * @param viewedUsers the viewedUsers to set
     */
    public void setViewedUsers(Set<User> viewedUsers) {
        this.viewedUsers = viewedUsers;
    }
    
}
