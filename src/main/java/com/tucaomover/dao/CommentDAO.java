/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.dao;

import com.tucaomover.entities.Comment;

/**
 *
 * @author gao
 */
public interface CommentDAO {
    public void save (Comment comment);
    public void delete(Comment comment);
    public Comment getById(String id);
}
