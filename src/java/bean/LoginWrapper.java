/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 * klasa wrapper dla procesu logowania
 * @author Klotor90
 */
public class LoginWrapper {

    private String message;
    private Person person;

    /**
     * domyślny konstruktor klasy LoginWrapper
     */
    public LoginWrapper() {
    }

    /**
     * metoda pobierająca komunikat logowania 
     * @return [String] komunikat logowania 
     */
    public String getMessage() {
        return message;
    }

    /**
     * metoda ustawiająca komunikat logowania 
     * @param message [String] komunikat logowania 
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * metoda pobierająca logujacego się użytkownika 
     * @return [Person] obiekt użytkownika
     */
    public Person getPerson() {
        return person;
    }

    /**
     * metoda ustawiająca logujacego się użytkownika 
     * @param person [Person] obiekt użytkownika
     */
    public void setPerson(Person person) {
        this.person = person;
    }
}
