/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 * klasa User określająca podstawowe cechy użtkownika
 * @author Klotor90
 */
public class User {

    private int userId;
    private String userPass;
    private String userLogin;
    private boolean isAdmin;
    private int userStatus;

    /**
     * domyślny konstruktor klasy
     */
    public User() {
    }
    
    /**
     * konstruktor klasy User ustawiający wszystkie pola obiektu
     * @param userId int id uzytkownika
     * @param userPass String hasło użytkownika
     * @param userLogin String login użytkownika
     * @param isAdmin boolean uprawnienia administratorskie
     * @param userStatus int status użytkownika
     */
    public User(int userId, String userPass, String userLogin, boolean isAdmin, int userStatus) {
        this.userId = userId;
        this.userPass = userPass;
        this.userLogin = userLogin;
        this.isAdmin = isAdmin;
        this.userStatus = userStatus;
    }
    
    /**
     * getter dla pola userId obiektu
     * @return int id użytkownika reprezentowanego przez obiekt
     */
    public int getUserId() {
        return userId;
    }

    /**
     * setter dla pola userId obiektu
     * @param userId nowa wartość id użytkownika
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * getter dla pola userPass obiektu
     * @return String hasło użytkownika reprezentowanego przez obiekt
     */
    public String getUserPass() {
        return userPass;
    }

    /**
     * setter dla pola userPass obiektu
     * @param userPass nowe hasło użytkownika
     */
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    /**
     * getter dla pola userLogin obiektu
     * @return String login użytkownika reprezentowanego przez obiekt
     */
    public String getUserLogin() {
        return userLogin;
    }

    /**
     * setter dla pola userLogin obiektu
     * @param userLogin nowy login użytkownika
     */
    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    /**
     * getter dla pola isAdmin obiektu
     * @return boolean wartość określająca, czy użytkownik, reprezentowany przez obiekt, ma prawa administratora
     */
    public boolean isIsAdmin() {
        return isAdmin;
    }

    /**
     * setter dla pola isAdmin obiektu
     * @param isAdmin nowe prawa administratora lub ich brak
     */
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * getter dla pola userStatus obiektu
     * @return int status użytkownika reprezentowanego przez obiekt
     */
    public int getUserStatus() {
        return userStatus;
    }

    /**
     * setter dla pola userStatus obiektu
     * @param userStatus nowy status użytkownika
     */
    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

}
