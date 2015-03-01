/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Post;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * DAO - obsługa klasy Post - implementacja
 *
 * @see PostDAO
 * @author Tomasz
 */
public class PostDAOImpl implements PostDAO {

    private JdbcTemplate jdbcTemplate;

    /**
     * metoda konfigurująca sterownik jdbc
     * @param dataSource [DataSource]
     */
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * metoda dodająca nowy post implementacja
     *
     * @param post [Post] dodawany post
     */
    @Override
    public void addPost(Post post) {
        String query = "INSERT INTO POSTS (USER_ID, TEXT, STATUS) VALUES (?,?,0)";
        jdbcTemplate.update(query, new Object[]{
            post.getPostUserId(),
            post.getPostText(),
            post.getPostStatus()
        });
    }

    /**
     * metoda zwracająca post wg. jego id - implementacja
     *
     * @param postId [int] id żądanego posta
     * @return [Post] odnaleziony w bazie danych post
     */
    @Override
    public Post getPostById(int postId) {
        String query = "SELECT * FROM POSTS WHERE ID=?";
        Post post = null;
        try {
            post = (Post) jdbcTemplate.queryForObject(query, new Object[]{
                postId}, (ResultSet rs, int i) -> new Post(rs.getInt("ID"),
                    rs.getInt("USER_ID"),
                    rs.getString("TIMESTAMP"),
                    rs.getString("TEXT"),
                    rs.getInt("STATUS")
            ));
        } catch (Exception ex) {
            System.out.println("Could not get Post form database for id ["
                    + postId + "]");
        }
        return post;
    }

    /**
     * metoda zwracająca posty wg. ich autora implementacja
     *
     * @param userId [int] id autora
     * @return [ArrayList] lista postów
     */
    @Override
    public ArrayList<Post> getPostByUser(int userId) {
        String query = "SELECT * FROM POSTS WHERE USER_ID=?";
        ArrayList<Post> posts = new ArrayList<>();
        Post post = null;
        try {
            post = (Post) jdbcTemplate.queryForObject(query, new Object[]{
                userId}, (ResultSet rs, int i) -> new Post(rs.getInt("ID"),
                    rs.getInt("USER_ID"),
                    rs.getString("TIMESTAMP"),
                    rs.getString("TEXT"),
                    rs.getInt("STATUS")
            ));
            posts.add(post);
        } catch (Exception ex) {
            System.out.println("Could not get Post form database for user ["
                    + userId + "]");
        }
        return posts;
    }

    /**
     * metoda zwracająca posty wg. ich statusu - implementacja
     *
     * @param postStat [int] id autora
     * @return [ArrayList] lista postów
     */
    @Override
    public ArrayList<Post> getPostByStatus(int postStat) {
        String query = "SELECT * FROM POSTS WHERE STATUS=?";
        ArrayList<Post> posts = new ArrayList<>();
        Post post = null;
        try {
            post = (Post) jdbcTemplate.queryForObject(query, new Object[]{
                postStat}, (ResultSet rs, int i) -> new Post(rs.getInt("ID"),
                    rs.getInt("USER_ID"),
                    rs.getString("TIMESTAMP"),
                    rs.getString("TEXT"),
                    rs.getInt("STATUS")
            ));
            posts.add(post);
        } catch (Exception ex) {
            System.out.println("Could not get Post form database for status ["
                    + postStat + "]");
        }
        return posts;
    }

    /**
     * metoda akceptująca post
     *
     * @param postId [int] id postu
     */
    @Override
    public void acceptPost(int postId) {
        String query = "UPDATE POSTS SET STATUS=1 WHERE ID=?";
        jdbcTemplate.update(query, new Object[]{
            postId
        });
    }

   /**
     * metoda odrzucająca post
     *
     * @param postId [int] id postu
     */
    @Override
    public void dismissPost(int postId) {
        String query = "UPDATE POSTS SET STATUS=2 WHERE ID=?";
        jdbcTemplate.update(query, new Object[]{
            postId
        });
    }
}
