/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.LinkedPost;
import bean.LoginWrapper;
import bean.Person;
import bean.Post;
import bean.User;
import dao.LinkedPostDAO;
import dao.PersonDAO;
import dao.PostDAO;

/**
 *
 * @author Klotor90
 */
public class UniversalService {

    PersonDAO personDAO;
    LinkedPostDAO linkedPostDAO;
    PostDAO postDAO;

    public String personWelcome(Person person) {
        System.out.print("Powitanie użytkownika");
        String result = "Witaj użytkowniku " + person.getPersName() + " (" + person.getUserLogin()
                + ")";
        return result;
    }

    public LoginWrapper logIn(User user) {
        LoginWrapper loginWrapper = new LoginWrapper();
        Person person = getPerson(user);
        if (person != null) {
            if (person.getUserPass().equals(user.getUserPass())) {
                loginWrapper.setPerson(person);
                String message = "Użytkownik został zalogowany";
                loginWrapper.setMessage(message);
            } else {
                String message = "Podano nieprawidłowe hasło";
                loginWrapper.setMessage(message);
            }
        } else {
            String message = "Podany użytkownik nie istnieje";
            loginWrapper.setMessage(message);
        }
        return loginWrapper;
    }

    public void addPerson(Person person) {
        personDAO.addPerson(person);
    }

    public Person getPerson(User user) {
        if (user != null) {
            //Person person = getPersonByLogin(user); // Uśmiech prowadzącego :)
            return personDAO.getPersonByLogin(user.getUserLogin());
        }
        return null;
    }
    
    public void addPost(Post post) {
        postDAO.addPost(post);
    }
    public void addLinkedPost(LinkedPost post) {
        post.printAll();
        linkedPostDAO.addLinkedPost(post);
    }

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
    public void setLinkedPostDAO(LinkedPostDAO linkedPostDAO) {
        this.linkedPostDAO = linkedPostDAO;
    }
    public void setPostDAO(PostDAO postDAO) {
        this.postDAO = postDAO;
    }
}
