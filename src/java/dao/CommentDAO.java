/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Comment;

/**
 *
 * @author Tomasz
 */
public interface CommentDAO {

    /**
     *
     * @param person
     */
    void addComment(Comment person);

    /**
     *
     * @param postId
     * @return
     */
    Comment getCommentById(int postId);

    /**
     *
     * @param userId
     * @return
     */
    Comment getCommentByPost(int userId);

    /**
     *
     * @param userId
     * @return
     */
    Comment getCommentByUser(int userId);
}
