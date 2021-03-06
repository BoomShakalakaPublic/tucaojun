/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

/**
 *
 * @author gao
 */
@Entity
@Table
@Transactional
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
    private String id;
    @ManyToOne   
    private Gossip gossip;
    @Column
    private String content;
    
    
    public Comment(){
        
    }
    
    public Comment(String id, Gossip gossip, String content){
        this.id=id;
        this.gossip=gossip;
        this.content=content;
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
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tucaomover.entities.Comment[ id=" + id + " ]";
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

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    
}
