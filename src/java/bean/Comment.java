/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 * klasa Comment odzwierciedlająca komentarze
 * @author Tomasz
 */
public class Comment {

    private int commId;
    private int commPostId;
    private int commUserId;
    private String commText;
    private String commTimestamp;

    /**
     * domyślny konstruktor klasy Comment
     */
    public Comment() {
    }

    /**
     * konstruktor klasy Comment ustawiający wszystkie pola obiektu
     * @param commId int id komentarza
     * @param commPostId int id postu, do którego komentarz się odnosi
     * @param commUserId int id użytkownika, który napisał komentarz
     * @param commText String treść komentarza
     * @param commTimestamp String data wstawienia komentarza
     */
    public Comment(int commId, int commPostId, int commUserId, String commText, String commTimestamp) {
        this.commId = commId;
        this.commPostId = commPostId;
        this.commUserId = commUserId;
        this.commText = commText;
        this.commTimestamp = commTimestamp;
    }

    /**
     * getter dla pola commId obiektu
     * @return int wartośc id komentarza reprezentowanego przez dany obiekt
     */
    public int getCommId() {
        return commId;
    }

    /**
     * setter dla pola commId obiektu
     * @param commId int nowa wartość id
     */
    public void setCommId(int commId) {
        this.commId = commId;
    }

    /**
     * getter dla pola commPostId obiektu
     * @return int wartośc id postu, do którego odnosi się komentarz reprezentowany przez dany obiekt
     */
    public int getCommPostId() {
        return commPostId;
    }

    /**
     * setter dla pola commPostId obiektu
     * @param commPostId int nowa wartość id postu
     */
    public void setCommPostId(int commPostId) {
        this.commPostId = commPostId;
    }

    /**
     * getter dla pola commUserId obiektu
     * @return int wartość id użytkownika, który utworzył komentarz reprezentowany przez dany obiekt
     */
    public int getCommUserId() {
        return commUserId;
    }

    /**
     * setter dla pola commUserId obiektu
     * @param commUserId int nowa wartośc id użytkownika
     */
    public void setCommUserId(int commUserId) {
        this.commUserId = commUserId;
    }

    /**
     * getter dla pola commText obiektu
     * @return String treść komentarza reprezentowanego przez dany obiekt
     */
    public String getCommText() {
        return commText;
    }

    /**
     * setter dla pola commText obiektu
     * @param commText String nowa treść komentarza
     */
    public void setCommText(String commText) {
        this.commText = commText;
    }

    /**
     * getter dla pola commTimestamp obiektu
     * @return String czas utworzenia komentarza reprezentowanego przez dany obiekt
     */
    public String getCommTimestamp() {
        return commTimestamp;
    }

    /**
     * setter dla pola commTimestamp obiektu
     * @param commTimestamp String nowa wartość daty
     */
    public void setCommTimestamp(String commTimestamp) {
        this.commTimestamp = commTimestamp;
    }

}
