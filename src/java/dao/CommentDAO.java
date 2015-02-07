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

    void addComment(Comment person);

    Comment getCommentById(int postId);

    Comment getCommentByPost(int userId);

    Comment getCommentByStatus(int userStat);
}
