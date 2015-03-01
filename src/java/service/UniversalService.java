/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.LinkedPost;
import bean.LoggedUser;
import bean.LoginWrapper;
import bean.Person;
import bean.Post;
import bean.User;
import dao.LinkedPostDAO;
import dao.PersonDAO;
import dao.PostDAO;
import java.util.ArrayList;

/**
 *
 * @author Klotor90
 */
public class UniversalService {

    PersonDAO personDAO;
    LinkedPostDAO linkedPostDAO;
    PostDAO postDAO;

    /**
     *
     * @param person
     * @return
     */
    public String personWelcome(Person person) {
        System.out.print("Powitanie użytkownika");
        String result = "Witaj użytkowniku " + person.getPersName() + " (" + person.getUserLogin()
                + ")";
        return result;
    }

    /**
     *
     * @param user
     * @return
     */
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

    /**
     *
     * @param person
     */
    public void addPerson(Person person) {
        personDAO.addPerson(person);
    }

    /**
     *
     * @param user
     * @return
     */
    public Person getPerson(User user) {
        if (user != null) {
            //Person person = getPersonByLogin(user); // Uśmiech prowadzącego :)
            return personDAO.getPersonByLogin(user.getUserLogin());
        }
        return null;
    }
    
    /**
     *
     * @param post
     */
    public void addPost(Post post) {
        postDAO.addPost(post);
    }

    /**
     *
     * @param post
     */
    public void addLinkedPost(LinkedPost post) {
        post.printAll();
        linkedPostDAO.addLinkedPost(post);
    }

    /**
     *
     * @param personDAO
     */
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    /**
     *
     * @param linkedPostDAO
     */
    public void setLinkedPostDAO(LinkedPostDAO linkedPostDAO) {
        this.linkedPostDAO = linkedPostDAO;
    }

    /**
     *
     * @param postDAO
     */
    public void setPostDAO(PostDAO postDAO) {
        this.postDAO = postDAO;
    }
    
    /**
     *
     * @param status
     * @return
     */
    public String showPosts(int status) {
        String toShow = new String();
        ArrayList<LinkedPost> posts = linkedPostDAO.getLinkedPostByStatus(status);
        if (posts != null)
        {
            for (LinkedPost post: posts)
            {
                toShow += "<br/><hr/><br/>";
                toShow += post.getPostText();
                toShow += "<br/>";
                toShow += "<i>" + post.getPostTimestamp() + "</i><br/>";
                if(post.getURL() != null)
                    toShow += "<br/>Link: " + post.getURL();
                else
                    toShow += "<br/>Brak linka";
                toShow += "<br/><b>" + personDAO.getPersonById(post.getPostUserId()).getPersName() + "</b>";
                if(LoggedUser.getLoggedUserAdmin() == 1 && post.getPostStatus() != 1)
                {
                    toShow += "<br/><input type=submit name=accept"+post.getPostId()+" value=Potwierdź><br/>";
                }
            }
        }
        return toShow;
    }
    
    /**
     *
     * @param ID
     */
    public void acceptPost(int ID)
    {
        linkedPostDAO.acceptPost(ID);
    }
}
