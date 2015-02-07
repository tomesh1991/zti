/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Post;

/**
 *
 * @author Tomasz
 */
public interface PostDAO {
    void addPost(Post post);
    Post getPostById(int postId);
    Post getPostByUser(int userId);
    Post getPostByStatus(int postStat);
}
