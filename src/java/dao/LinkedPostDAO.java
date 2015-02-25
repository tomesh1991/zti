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
    void addLinkedPost(LinkedPost post);
    LinkedPost getLinkedPostById(int postId);
    ArrayList<LinkedPost> getLinkedPostByUser(int userId);
    ArrayList<LinkedPost> getLinkedPostByStatus(int postStat);
    void acceptPost(int postId);
    void dismissPost(int postId);
}
