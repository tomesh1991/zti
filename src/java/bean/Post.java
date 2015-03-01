/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 * klasa bazowa Post odzwierciedlająca posty
 * @author Klotor90
 */
public class Post {

    int postId;
    int postUserId;
    String postText;
    String postTimestamp;
    int postStatus;

    /**
     * domyślny konstruktor klasy Post
     */
    public Post() {
    }
    
    /**
     * konstruktor klasy Post ustawiający wszystkie pola obiektu
     * @param postId [int] id postu
     * @param postUserId [int] id użytkownika, który napisał post
     * @param postText [String] treść postu
     * @param postTimestamp [String] data dodania postu
     * @param postStatus [int] status postu [0 - oczekujący na akceptację, 1 - zaakceptowany]
     */
    public Post(int postId, int postUserId, String postText, String postTimestamp, int postStatus) {
        this.postId = postId;
        this.postUserId = postUserId;
        this.postText = postText;
        this.postTimestamp = postTimestamp;
        this.postStatus = postStatus;
    }
    
    /**
     * getter dla pola postUserId obiektu
     * @return [int] id użytkownika, który napisał post reprezentowany przed obiekt
     */
    public int getPostUserId() {
        return postUserId;
    }

    /**
     * setter dla pola postUserId obiektu
     * @param postUserId [int] nowa wartość id użytkownika
     */
    public void setPostUserId(int postUserId) {
        this.postUserId = postUserId;
    }

    /**
     * getter dla pola postStatus obiektu
     * @return [int] status posta reprezentowanego przed obiekt
     */
    public int getPostStatus() {
        return postStatus;
    }

    /**
     * setter dla pola postStatus obiektu
     * @param postStatus [int] nowa wartość statusu posta
     */
    public void setPostStatus(int postStatus) {
        this.postStatus = postStatus;
    }

    /**
     * getter dla pola postId obiektu
     * @return [int] id posta reprezentowanego przed obiekt
     */
    public int getPostId() {
        return postId;
    }

    /**
     * setter dla pola postId obiektu
     * @param postId [int] nowa wartość id posta
     */
    public void setPostId(int postId) {
        this.postId = postId;
    }

    /**
     * getter dla pola postText obiektu
     * @return [String] treść posta reprezentowanego przed obiekt
     */
    public String getPostText() {
        return postText;
    }

    /**
     * setter dla pola postText obiektu
     * @param postText [String] nowa treść posta
     */
    public void setPostText(String postText) {
        this.postText = postText;
    }

    /**
     * getter dla pola postTimestamp obiektu
     * @return [String] data napisania posta reprezentowanego przed obiekt
     */
    public String getPostTimestamp() {
        return postTimestamp;
    }

    /**
     * setter dla pola postTimestamp obiektu
     * @param postTimestamp [String] nowa data utworzenia posta
     */
    public void setPostTimestamp(String postTimestamp) {
        this.postTimestamp = postTimestamp;
    }
}
