/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.dao;

import com.tucaomover.entities.User;

/**
 *
 * @author gao
 */
public interface UserDAO {
    public Long save(User user);
    public void delete(User user);
    public User getById(Long id);
    public User getByEmail(String email);
}
