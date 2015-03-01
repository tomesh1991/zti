/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.LinkedPost;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author tomasz
 */
public class LinkedPostDAOImpl implements LinkedPostDAO {
    private JdbcTemplate jdbcTemplate;

    /**
     *
     * @param dataSource
     */
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     *
     * @param post
     */
    @Override
    public void addLinkedPost(LinkedPost post) {
        String query = "INSERT INTO POSTS (USER_ID, TEXT, STATUS, PICT_URL) VALUES (?,?,0,?)";
        jdbcTemplate.update(query, new Object[]{
            post.getPostUserId(),
            post.getPostText(),
            //post.getPostStatus(),
            post.getURL()
        });
    }

    /**
     *
     * @param userId
     * @return
     */
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

    /**
     *
     * @param postId
     * @return
     */
    @Override
    public LinkedPost getLinkedPostById(int postId) {
        String query = "SELECT * FROM POSTS WHERE ID=?";
        LinkedPost post = null;
        try {
            post = (LinkedPost) jdbcTemplate.queryForObject(query, new Object[]{
                postId}, (ResultSet rs, int i) -> new LinkedPost(rs.getInt("ID"),
                        rs.getInt("USER_ID"),
                        rs.getString("TEXT"),
                        rs.getString("TIMESTAMP"),
                        rs.getInt("STATUS"),
                        rs.getString("PICT_URL")
                ));
        } catch (Exception ex) {
            System.out.println("Could not get Post form database for id ["
                    + postId + "]");
        }
        return post;
    }

    /**
     *
     * @param postStat
     * @return
     */
    @Override
    public ArrayList<LinkedPost> getLinkedPostByStatus(int postStat) {
        String query = "SELECT * FROM POSTS WHERE STATUS=?";
        ArrayList<LinkedPost> posts = new ArrayList<>();
        try {
            List<Map<String, Object>> rows;
            rows = jdbcTemplate.queryForList(query, new Object[]{postStat});
            for (Map row : rows) {
                
                LinkedPost post = new LinkedPost();
                System.out.println((int)row.get("ID"));
                post.setPostId((int)row.get("ID"));
                post.setPostUserId((int)row.get("USER_ID"));
                post.setPostText((String)row.get("TEXT"));
                post.setPostTimestamp(row.get("TIMESTAMP").toString());
                post.setPostStatus((int)row.get("STATUS"));
                post.setURL((String)row.get("PICT_URL"));
                post.printAll();
                posts.add(post);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Could not get Post form database for status ["
                    + postStat + "]");
        }
        return posts;
    }

    /**
     *
     * @param postId
     */
    @Override
    public void acceptPost(int postId){
        String query = "UPDATE POSTS SET STATUS=1 WHERE ID=?";
        jdbcTemplate.update(query, new Object[]{
           postId
        });
    }

    /**
     *
     * @param postId
     */
    @Override
    public void dismissPost(int postId){
        String query = "UPDATE POSTS SET STATUS=2 WHERE ID=?";
        jdbcTemplate.update(query, new Object[]{
           postId
        });
    }
    
    
}
