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
public class Person extends User {

    private String persName;
    private String persEmail;

    public Person() {
    }

    public Person(String persName, String email, String userLogin, String password) {
        this.persName = persName;
        this.persEmail = email;
        super.setUserLogin(userLogin);
        super.setUserPass(password);
    }

    public String getPersName() {
        return persName;
    }

    public void setPersName(String persName) {
        this.persName = persName;
    }

    public String getPersEmail() {
        return persEmail;
    }

    public void setPersEmail(String persEmail) {
        this.persEmail = persEmail;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + persName + '}';
    }
}
