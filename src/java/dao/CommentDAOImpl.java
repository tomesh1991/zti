/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Comment;
import java.sql.ResultSet;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Tomasz
 */
public class CommentDAOImpl implements CommentDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addComment(Comment comm) {
        String query = "INSERT INTO COMMENTS (ID, POST_ID, USER_ID, TIMESTAMP, TEXT) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(query, new Object[]{
            comm.getCommId(),
            comm.getCommPostId(),
            comm.getCommUserId(),
            comm.getCommTimestamp(),
            comm.getCommText(),});
    }

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

    @Override
    public Comment getCommentByPost(int postId) {
        String query = "SELECT * FROM COMMENTS WHERE POST_ID=?";
        Comment post = null;
        try {
            post = (Comment) jdbcTemplate.queryForObject(query, new Object[]{
                postId}, (ResultSet rs, int i) -> new Comment(rs.getInt("ID"),
                    rs.getInt("POST_ID"),
                    rs.getInt("USER_ID"),
                    rs.getString("TIMESTAMP"),
                    rs.getString("TEXT")
            ));
        } catch (Exception ex) {
            System.out.println("Could not get Comment form database for post ["
                    + postId + "]");
        }
        return post;
    }

    @Override
    public Comment getCommentByUser(int userId) {
        String query = "SELECT * FROM COMMENTS WHERE USER_ID=?";
        Comment post = null;
        try {
            post = (Comment) jdbcTemplate.queryForObject(query, new Object[]{
                userId}, (ResultSet rs, int i) -> new Comment(rs.getInt("ID"),
                    rs.getInt("POST_ID"),
                    rs.getInt("USER_ID"),
                    rs.getString("TIMESTAMP"),
                    rs.getString("TEXT")
            ));
        } catch (Exception ex) {
            System.out.println("Could not get Comment form database for user ["
                    + userId + "]");
        }
        return post;
    }
}