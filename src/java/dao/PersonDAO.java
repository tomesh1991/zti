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
}
