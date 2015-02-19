/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.LinkedPost;
import bean.Post;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author tomasz
 */
public class LinkedPostDAOImpl implements LinkedPostDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addLinkedPost(LinkedPost post) {
        String query = "INSERT INTO POST (ID, USER_ID, TIMESTAMP, TEXT, STATUS, PICT_URL) VALUES (?,?,?,?,?,1,?)";
        jdbcTemplate.update(query, new Object[]{
            post.getPostId(),
            post.getPostUserId(),
            post.getPostTimestamp(),
            post.getPostText(),
            post.getPostStatus(),
            post.getURL()
        });
    }

    @Override
    public LinkedPost getLinkedPostById(int postId) {
        String query = "SELECT * FROM POSTS WHERE ID=?";
        LinkedPost post = null;
        try {
            post = (LinkedPost) jdbcTemplate.queryForObject(query, new Object[]{
                postId}, (ResultSet rs, int i) -> new LinkedPost(rs.getInt("ID"),
                        rs.getInt("USER_ID"),
                        rs.getString("TIMESTAMP"),
                        rs.getString("TEXT"),
                        rs.getInt("STATUS"),
                        rs.getString("PICT_URL")
                ));
        } catch (Exception ex) {
            System.out.println("Could not get Post form database for id ["
                    + postId + "]");
        }
        return post;
    }

    @Override
    public ArrayList<LinkedPost> getLinkedPostByUser(int userId) {
        String query = "SELECT * FROM POSTS WHERE USER_ID=?";
        ArrayList<LinkedPost> posts = new ArrayList<>(); 
        LinkedPost post = null;
        try {
            post = (LinkedPost) jdbcTemplate.queryForObject(query, new Object[]{
                userId}, (ResultSet rs, int i) -> new LinkedPost(rs.getInt("ID"),
                        rs.getInt("USER_ID"),
                        rs.getString("TIMESTAMP"),
                        rs.getString("TEXT"),
                        rs.getInt("STATUS"),
                        rs.getString("PICT_URL")
                ));
            posts.add(post);
        } catch (Exception ex) {
            System.out.println("Could not get Post form database for user ["
                    + userId + "]");
        }
        return posts;
    }

    @Override
    public ArrayList<LinkedPost> getLinkedPostByStatus(int postStat) {
        String query = "SELECT * FROM POSTS WHERE STATUS=?";
        ArrayList<LinkedPost> posts = new ArrayList<>();
        LinkedPost post = null;
        try {
            post = (LinkedPost) jdbcTemplate.queryForObject(query, new Object[]{
                postStat}, (ResultSet rs, int i) -> new LinkedPost(rs.getInt("ID"),
                        rs.getInt("USER_ID"),
                        rs.getString("TIMESTAMP"),
                        rs.getString("TEXT"),
                        rs.getInt("STATUS"),
                        rs.getString("PICT_URL")
                ));
            posts.add(post);
        } catch (Exception ex) {
            System.out.println("Could not get Post form database for status ["
                    + postStat + "]");
        }
        return posts;
    }
}
