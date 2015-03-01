/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 * klasa User rozszerzająca dane o użytkowniku portalu o dane osoby
 * @see User
 * @author Klotor90
 */
public class Person extends User {

    private String persName;
    private String persEmail;

    /**
     * domyślny konktruktor klasy Person
     */
    public Person() {
    }

    /**
     * konstruktor klasy Person ustawiający wszystkie pola obiektu
     * @param userId
     * @param userLogin
     * @param userPass
     * @param isAdmin
     * @param userStatus
     * @param persName
     * @param persEmail
     */
    public Person(int userId, String userLogin, String userPass, boolean isAdmin, int userStatus, String persName, String persEmail) {
        super(userId, userPass, userLogin, isAdmin, userStatus);
        this.persName = persName;
        this.persEmail = persEmail;
    }

    /**
     * getter dla pola persName obiektu
     * @return String imię osoby
     */
    public String getPersName() {
        return persName;
    }

    /**
     * setter dla pola persName obiektu
     * @param persName String nowe nazwisko osoby
     */
    public void setPersName(String persName) {
        this.persName = persName;
    }

    /**
     * getter dla pola persEmail obiektu
     * @return String adres e-mail osoby
     */
    public String getPersEmail() {
        return persEmail;
    }

    /**
     * setter dla pola persEmail obiektu
     * @param persEmail nowy e-mail 
     */
    public void setPersEmail(String persEmail) {
        this.persEmail = persEmail;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + persName + '}';
    }
}
