/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.dao;

import com.tucaomover.entities.Gossip;
import java.util.List;

/**
 *
 * @author gao
 */
public interface GossipDAO {
    public void save(Gossip gossip);
    public void delete(Gossip gossip);
    public List<Gossip> getAll();
    public Gossip getById(String id);
}
