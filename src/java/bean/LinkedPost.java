/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 * klasa rozszerzająca klasę Post o URL obrazka
 * @see Post
 * @author Klotor90
 */
public class LinkedPost extends Post {

    private String URL;
    
    /**
     * domyślny konstruktor klasy LinkedPost
     */
    public LinkedPost() {
        super();
    }
    
    /**
     * konstruktor klasy Post ustawiający wszystkie pola obiektu
     * @param postId [int] id postu
     * @param postUserId [int] id użytkownika, który napisał post
     * @param postText [String] treść postu
     * @param postTimestamp [String] data dodania postu
     * @param postStatus [int] status postu [0 - oczekujący na akceptację, 1 - zaakceptowany]
     * @param URL [String] URL dodawanego obrazka
     */
    public LinkedPost(int postId, int postUserId, String postText, String postTimestamp, int postStatus, String URL) {
        super(postId, postUserId, postText, postTimestamp, postStatus);
        this.URL = URL;
    }

    /**
     * getter dla pola URL obiektu
     * @return [String] url obrazka
     */
    public String getURL() {
        return URL;
    }

    /**
     * setter dla pola URL obiektu
     * @param URL [String] nowy url obrazka
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "Post by " + super.getPostTimestamp() + ": " + super.getPostText() + " #" + this.URL;
    }
    
    /**
     * metoda kontrolna wypisująca wszystkie pola obiektu
     */
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
