/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Klotor90
 */
public class EmbeddedPost extends Post {

    /**
     *
     * @param postId
     * @param postUserId
     * @param postText
     * @param postTimestamp
     * @param postStatus
     */
    public EmbeddedPost(int postId, int postUserId, String postText, String postTimestamp, int postStatus) {
        super(postId, postUserId, postText, postTimestamp, postStatus);
    }
}
