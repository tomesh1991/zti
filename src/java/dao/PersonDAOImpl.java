/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Person;
import java.sql.ResultSet;
import java.util.ArrayList;
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
        String query = "INSERT INTO USERS (NAME, EMAIL, LOGIN, PASSWORD, ADMIN, STATUS) VALUES (?,?,?,?,false,1)";
        jdbcTemplate.update(query, new Object[]{
            person.getPersName(),
            person.getPersEmail(),
            person.getUserLogin(),
            person.getUserPass()
        });
    }

    @Override
    public Person getPersonByLogin(String userLogin) {
        String query = "SELECT * FROM USERS WHERE LOGIN=?";
        Person person = null;
        try {
            person = (Person) jdbcTemplate.queryForObject(query, new Object[]{
                userLogin}, (ResultSet rs, int i) -> new Person(rs.getInt("ID"),
                        rs.getString("LOGIN"),
                        rs.getString("PASSWORD"),
                        rs.getBoolean("ADMIN"),
                        rs.getInt("STATUS"),
                        rs.getString("NAME"),
                        rs.getString("EMAIL")
                ));
        } catch (Exception ex) {
            System.out.println("Could not get Person form database for login ["
                    + userLogin + "]");
        }
        return person;
    }
    
    @Override
    public Person getPersonById(int userId) {
        String query = "SELECT * FROM USERS WHERE ID=?";
        Person person = null;
        try {
            person = (Person) jdbcTemplate.queryForObject(query, new Object[]{
                userId}, (ResultSet rs, int i) -> new Person(rs.getInt("ID"),
                        rs.getString("LOGIN"),
                        rs.getString("PASSWORD"),
                        rs.getBoolean("ADMIN"),
                        rs.getInt("STATUS"),
                        rs.getString("NAME"),
                        rs.getString("EMAIL")
                ));
        } catch (Exception ex) {
            System.out.println("Could not get Person form database for id ["
                    + userId + "]");
        }
        return person;
    }
    
    @Override
    public ArrayList<Person> getPersonByStatus(int userStat) {
        String query = "SELECT * FROM USERS WHERE STATUS=?";
        ArrayList<Person> persons = new ArrayList<>();
        Person person = null;
        try {
            person = (Person) jdbcTemplate.queryForObject(query, new Object[]{
                userStat}, (ResultSet rs, int i) -> new Person(rs.getInt("ID"),
                        rs.getString("LOGIN"),
                        rs.getString("PASSWORD"),
                        rs.getBoolean("ADMIN"),
                        rs.getInt("STATUS"),
                        rs.getString("NAME"),
                        rs.getString("EMAIL")
                ));
        } catch (Exception ex) {
            System.out.println("Could not get Person form database for id ["
                    + userStat + "]");
        }
        return persons;
    }
    @Override
    public void changeUserPasswd(int userId, String new_pass){
        String query = "UPDATE USERS SET PASSWORD = '?' WHERE ID=?";
        jdbcTemplate.update(query, new Object[]{
            new_pass,
            userId
        });
    }
    
    @Override
    public void changeUserMail(int userId, String new_addr){
        String query = "UPDATE USERS SET EMAIL = '?' WHERE ID=?";
        jdbcTemplate.update(query, new Object[]{
            new_addr,
            userId
        });
    }
    
    @Override
    public void acceptUser(int userId){
        String query = "UPDATE USERS SET STATUS=1 WHERE ID=?";
        jdbcTemplate.update(query, new Object[]{
           userId
        });
    }
    
    @Override
    public void dismissUser(int userId){
        String query = "UPDATE USERS SET STATUS=2 WHERE ID=?";
        jdbcTemplate.update(query, new Object[]{
           userId
        });
    }
    
    @Override
    public void deleteUser(int userId){
        String query = "UPDATE USERS SET STATUS=3 WHERE ID=?";
        jdbcTemplate.update(query, new Object[]{
           userId
        });
    }
    
    @Override
    public void grantAdminAccess(int userId){
        String query = "UPDATE USERS SET ADMIN=true WHERE ID=?";
        jdbcTemplate.update(query, new Object[]{
           userId
        });
    }
    
    @Override
    public void revokeAdminAccess(int userId){
        String query = "UPDATE USERS SET ADMIN=false WHERE ID=?";
        jdbcTemplate.update(query, new Object[]{
           userId
        });
    }
}
