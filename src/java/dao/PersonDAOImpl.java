/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Person;
import java.sql.ResultSet;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Klotor90
 */
public class PersonDAOImpl implements PersonDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addPerson(Person person) {
        String query = "INSERT INTO USERS (NAME, EMAIL, LOGIN, PASSWORD, ADMIN, STATUS) VALUES (?,?,?,?,?,false,1)";
        jdbcTemplate.update(query, new Object[]{
            person.getPersName(),
            person.getPersEmail(),
            person.getUserLogin(),
            person.getUserPass()
        });
    }

    @Override
    public Person getPersonByLogin(String userLogin) {
        String query = "SELECT * FROM USERS WHERE USERLOGIN=?";
        Person person = null;
        try {
            person = (Person) jdbcTemplate.queryForObject(query, new Object[]{
                userLogin}, (ResultSet rs, int i) -> new Person(rs.getString("NAME"),
                        rs.getString("EMAIL"),
                        rs.getString("USERLOGIN"),
                        rs.getString("PASSWORD")
                ));
        } catch (Exception ex) {
            System.out.println("Could not get Person form database for login ["
                    + userLogin + "]");
        }
        return person;
    }
    
    @Override
    public Person getPersonById(int userId) {
        String query = "SELECT * FROM USERS WHERE id=?";
        Person person = null;
        try {
            person = (Person) jdbcTemplate.queryForObject(query, new Object[]{
                userId}, (ResultSet rs, int i) -> new Person(rs.getString("NAME"),
                        rs.getString("EMAIL"),
                        rs.getString("USERLOGIN"),
                        rs.getString("PASSWORD")
                ));
        } catch (Exception ex) {
            System.out.println("Could not get Person form database for id ["
                    + userId + "]");
        }
        return person;
    }
}
