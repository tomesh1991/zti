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
    void addPerson(Person person);
    Person getPersonByLogin(String userLogin);
    Person getPersonById(int userId);
    ArrayList<Person> getPersonByStatus(int userStat);
    void changeUserPasswd(int userId, String new_pass);
    void changeUserMail(int userId, String new_addr);
    void acceptUser(int userId);
    void dismissUser(int userId);
    void deleteUser(int userId);
    void grantAdminAccess(int userId);
    void revokeAdminAccess(int userId);
}
