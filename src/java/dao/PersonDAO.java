/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Person;

/**
 *
 * @author Klotor90
 */
public interface PersonDAO {
    void addPerson(Person person);
    Person getPerson(String userLogin);
}
