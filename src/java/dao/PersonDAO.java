/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Person;
import java.util.ArrayList;

/**
 * interfejs DAO do obsługi użytkowników 
 * @author Klotor90
 */
public interface PersonDAO {

    /**
     * metoda dodająca nowego użytkownika
     * @param person Person dodawany użytkownik
     */
    void addPerson(Person person);

    /**
     * metoda zwracająca użytkownika wg. jego loginu
     * @param userLogin String login żądanego posta
     * @return
     */
    Person getPersonByLogin(String userLogin);

    /**
     * metoda zwracająca użytkownika wg. jego id
     * @param userId int id żądanego użytkownika
     * @return Person odnaleziony w bazie danych użytkownik
     */
    Person getPersonById(int userId);

    /**
     * metoda zwracająca użytkowników wg. ich statusu
     * @param userStat int status
     * @return ArrayList lista użytkowników
     */
    ArrayList<Person> getPersonByStatus(int userStat);

    /**
     * metoda zmieniająca hasło użytkownika
     * @param userId int id użytkownika
     * @param new_pass String nowe hasło użytkownika
     */
    void changeUserPasswd(int userId, String new_pass);

    /**
     * metoda zmieniająca e-mail użytkownika
     * @param userId int id użytkownika
     * @param new_addr String nowy e-mail użytkownika
     */
    void changeUserMail(int userId, String new_addr);

    /**
     * metoda akceptująca użytkownika
     * @param userId int id użytkownika
     */
    void acceptUser(int userId);

    /**
     * metoda odrzucająca użytkownika
     * @param userId int id użytkownika
     */
    void dismissUser(int userId);

    /**
     * metoda usuwająca użytkownika
     * @param userId int id użytkownika
     */
    void deleteUser(int userId);

    /**
     * metoda nadająca użytkownikowi prawa administratora
     * @param userId int id użytkownika
     */
    void grantAdminAccess(int userId);

    /**
     * metoda odbierająca użytkownikowi prawa administratora
     * @param userId int id użytkownika
     */
    void revokeAdminAccess(int userId);
}
