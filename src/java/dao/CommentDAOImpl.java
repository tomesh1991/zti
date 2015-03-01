/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Comment;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * DAO - obsługa klasy Comment - implementacja
 * @see CommentDAO
 * @author Tomasz
 */
public class CommentDAOImpl implements CommentDAO {

    private JdbcTemplate jdbcTemplate;

    /**
     * metoda konfigurująca sterownik jdbc
     * @param dataSource [DataSource]
     */
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * metoda dodająca nowy komentarz - implementacja
     * @param comm [Comment] dodawany komentarz
     */
    @Override
    public void addComment(Comment comm) {
        String query = "INSERT INTO COMMENTS (POST_ID, USER_ID, TEXT) VALUES (?,?,?)";
        jdbcTemplate.update(query, new Object[]{
            comm.getCommPostId(),
            comm.getCommUserId(),
            comm.getCommText(),});
    }

     /**
     * metoda zwracająca komentarz wg. jego id - implementacja
     * @param commId [int] id komentarza
     * @return [Comment] odnaleziony w bazie danych komentarz
     */
    @Override
    public Comment getCommentById(int commId) {
        String query = "SELECT * FROM COMMENTS WHERE ID=?";
        Comment post = null;
        try {
            post = (Comment) jdbcTemplate.queryForObject(query, new Object[]{
                commId}, (ResultSet rs, int i) -> new Comment(rs.getInt("ID"),
                    rs.getInt("POST_ID"),
                    rs.getInt("USER_ID"),
                    rs.getString("TIMESTAMP"),
                    rs.getString("TEXT")
            ));
        } catch (Exception ex) {
            System.out.println("Could not get Comment form database for id ["
                    + commId + "]");
        }
        return post;
    }

    /**
     * metoda zwracająca komentarze wg. postu, do którego są przypisane - implementacja
     * @param postId [int] id posta
     * @return [ArrayList] lista komentarzy
     */
    @Override
    public ArrayList<Comment> getCommentByPost(int postId) {
        String query = "SELECT * FROM COMMENTS WHERE POST_ID=?";
        Comment post = null;
        ArrayList<Comment> comments = new ArrayList<>();
        try {
            post = (Comment) jdbcTemplate.queryForObject(query, new Object[]{
                postId}, (ResultSet rs, int i) -> new Comment(rs.getInt("ID"),
                    rs.getInt("POST_ID"),
                    rs.getInt("USER_ID"),
                    rs.getString("TIMESTAMP"),
                    rs.getString("TEXT")
            ));
            comments.add(post);
        } catch (Exception ex) {
            System.out.println("Could not get Comment form database for post ["
                    + postId + "]");
        }
        return comments;
    }

    /**
     * metoda zwracająca komentarze wg. id uzytkownika, który ja napisał - implementacja
     * @param userId [int] id użytkownika
     * @return [ArrayList] lista komentarzy
     */
    @Override
    public ArrayList<Comment> getCommentByUser(int userId) {
        String query = "SELECT * FROM COMMENTS WHERE USER_ID=?";
        Comment post = null;
        ArrayList<Comment> comments = new ArrayList<>();
        try {
            post = (Comment) jdbcTemplate.queryForObject(query, new Object[]{
                userId}, (ResultSet rs, int i) -> new Comment(rs.getInt("ID"),
                    rs.getInt("POST_ID"),
                    rs.getInt("USER_ID"),
                    rs.getString("TIMESTAMP"),
                    rs.getString("TEXT")
            ));
            comments.add(post);
        } catch (Exception ex) {
            System.out.println("Could not get Comment form database for user ["
                    + userId + "]");
        }
        return comments;
    }
}
