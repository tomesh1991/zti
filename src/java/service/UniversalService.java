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
 * klasa pośrednicząca pomiędzy warstwami DAO oraz kontrolerami 
 * @author Klotor90
 */
public class UniversalService {

    PersonDAO personDAO;
    LinkedPostDAO linkedPostDAO;
    PostDAO postDAO;

    /**
     * meteda generujaca wiadomość powitalną dla użytkownika 
     * @param person [Person] użytkownik
     * @return [String] wiadomość powitalna
     */
    public String personWelcome(Person person) {
        System.out.print("Powitanie użytkownika");
        String result = "Witaj użytkowniku " + person.getPersName() + " (" + person.getUserLogin()
                + ")";
        return result;
    }

    /**
     * metoda obsługująca uwierzytelnianie użytkownika
     * @param user [User] uwierzytelniany użytkownik
     * @return [LoginWrapper] wynik będący sukcesem lub porażką z powodu złędnego loginu bądź hasła
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
     * metoda obsługująca rejestrację nowego użytkownika
     * @param person [Person] dane o nowym użytkowniku
     */
    public void addPerson(Person person) {
        personDAO.addPerson(person);
    }

    /**
     * metoda pobierająca dane o danym użytkoniku z bazy danych
     * @param user [User] dane użytkownika
     * @return [Person] użytkownik, jeżeli istnieje, jeżeli nie, to null
     */
    public Person getPerson(User user) {
        if (user != null) {
            //Person person = getPersonByLogin(user); // Uśmiech prowadzącego :)
            return personDAO.getPersonByLogin(user.getUserLogin());
        }
        return null;
    }
    
    /**
     * metoda obsługująca dodanie nowego posta
     * @param post [Post] dodawany post
     */
    public void addPost(Post post) {
        postDAO.addPost(post);
    }

    /**
     * metoda obsługująca dodanie nowego posta z linkiem
     * @param post [LinkedPost] dodawany post
     */
    public void addLinkedPost(LinkedPost post) {
        post.printAll();
        linkedPostDAO.addLinkedPost(post);
    }

    /**
     * metoda ustawiająca obiekt warstwy DAO dla klasy Person
     * @param personDAO [PersonDAO] nowy obiekt warstwy DAO
     */
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    /**
     * metoda ustawiająca obiekt warstwy DAO dla klasy LinkedPost
     * @param linkedPostDAO [LinkedPostDAO] nowy obiekt warstwy DAO
     */
    public void setLinkedPostDAO(LinkedPostDAO linkedPostDAO) {
        this.linkedPostDAO = linkedPostDAO;
    }

    /**
     * metoda ustawiająca obiekt warstwy DAO dla klasy Post
     * @param postDAO [PostDAO] nowy obiekt warstwy DAO
     */
    public void setPostDAO(PostDAO postDAO) {
        this.postDAO = postDAO;
    }
    
    /** 
     * metoda obsługująca wyświetlanie się postów
     * @param status [int] status postów
     * @return [Strint] wygenerowany kod HTML
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
     * metoda obsugujca zaakceptowanie posta
     * @param ID [int] id posta
     */
    public void acceptPost(int ID)
    {
        linkedPostDAO.acceptPost(ID);
    }
}
