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
public class LinkedPost extends Post {

    private String URL;
    
    public LinkedPost() {
        super();
    }
    
    public LinkedPost(int postId, int postUserId, String postText, String postTimestamp, int postStatus) {
        super(postId, postUserId, postText, postTimestamp, postStatus);
    }
    
    public LinkedPost(int postId, int postUserId, String postText, String postTimestamp, int postStatus, String URL) {
        super(postId, postUserId, postText, postTimestamp, postStatus);
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "Post by " + super.getPostTimestamp() + ": " + super.getPostText() + " #" + this.URL;
    }
    
    public void printAll()
    {
        System.out.println(postId);
        System.out.println(super.postUserId);
        System.out.println(super.postText);
        System.out.println(super.postTimestamp);
        System.out.println(super.postStatus);
        System.out.println(URL);
    }
}
