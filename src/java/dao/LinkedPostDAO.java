/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.LinkedPost;
import java.util.ArrayList;

/**
 *
 * @author tomasz
 */
public interface LinkedPostDAO {

    /**
     *
     * @param post
     */
    void addLinkedPost(LinkedPost post);

    /**
     *
     * @param postId
     * @return
     */
    LinkedPost getLinkedPostById(int postId);

    /**
     *
     * @param userId
     * @return
     */
    ArrayList<LinkedPost> getLinkedPostByUser(int userId);

    /**
     *
     * @param postStat
     * @return
     */
    ArrayList<LinkedPost> getLinkedPostByStatus(int postStat);

    /**
     *
     * @param postId
     */
    void acceptPost(int postId);

    /**
     *
     * @param postId
     */
    void dismissPost(int postId);
}
