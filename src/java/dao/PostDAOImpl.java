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
 *
 * @author Tomasz
 */
public class PostDAOImpl implements PostDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addPost(Post post) {
        String query = "INSERT INTO POST (ID, USER_ID, TIMESTAMP, TEXT, STATUS) VALUES (?,?,?,?,?,1)";
        jdbcTemplate.update(query, new Object[]{
            post.getPostId(),
            post.getPostUserId(),
            post.getPostTimestamp(),
            post.getPostText(),
            post.getPostStatus()
        });
    }

    @Override
    public Post getPostById(int postId) {
        String query = "SELECT * FROM POST WHERE ID=?";
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

}
