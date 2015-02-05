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

    private String firstName;
    private String lastName;
    private String address;

    public Person() {
    }

    public Person(String firstName, String lastName, String address, String userLogin, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        super.setUserLogin(userLogin);
        super.setPassword(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
    }
}
