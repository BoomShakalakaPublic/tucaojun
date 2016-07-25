/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.transaction.Transactional;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author gao
 */
@Entity
@Table
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable=false)
    @NotEmpty(message="Username cannot be empty")
    private String username;
    @Column(nullable=false)
    @NotEmpty(message="Password cannot be empty")
   
    private String password;
    @Email(message="Invalide email format")
    @NotEmpty(message="Email cannot be empty")
    @Column(nullable=false, unique=true)
    private String email;    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinTable(name = "user_gossip",joinColumns = { 
                    @JoinColumn(name = "user_id", nullable = false) }, 
                    inverseJoinColumns = { @JoinColumn(name = "gossip_id", 
                                    nullable = false) })
    private Set<Gossip> viewedGossips = new HashSet(); 
    
    public User(){};
    public User(String username, String password, String email){

        this.username=username;
        this.password=password;
        this.email=email;
    }
    
    
// Getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tucaomover.entities.User[ id=" + id + " ]";
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the viewedGossips
     */
    public Set<Gossip> getViewedGossips() {
        return viewedGossips;
    }

    /**
     * @param viewedGossips the viewedGossips to set
     */
    public void setViewedGossips(Set<Gossip> viewedGossips) {
        this.viewedGossips = viewedGossips;
    }
    
}
