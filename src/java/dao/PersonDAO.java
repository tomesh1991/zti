/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Person;
import java.util.ArrayList;

/**
 *
 * @author Klotor90
 */
public interface PersonDAO {

    /**
     *
     * @param person
     */
    void addPerson(Person person);

    /**
     *
     * @param userLogin
     * @return
     */
    Person getPersonByLogin(String userLogin);

    /**
     *
     * @param userId
     * @return
     */
    Person getPersonById(int userId);

    /**
     *
     * @param userStat
     * @return
     */
    ArrayList<Person> getPersonByStatus(int userStat);

    /**
     *
     * @param userId
     * @param new_pass
     */
    void changeUserPasswd(int userId, String new_pass);

    /**
     *
     * @param userId
     * @param new_addr
     */
    void changeUserMail(int userId, String new_addr);

    /**
     *
     * @param userId
     */
    void acceptUser(int userId);

    /**
     *
     * @param userId
     */
    void dismissUser(int userId);

    /**
     *
     * @param userId
     */
    void deleteUser(int userId);

    /**
     *
     * @param userId
     */
    void grantAdminAccess(int userId);

    /**
     *
     * @param userId
     */
    void revokeAdminAccess(int userId);
}
