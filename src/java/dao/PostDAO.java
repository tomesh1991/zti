/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Post;
import java.util.ArrayList;

/**
 * interfejs DAO do obsługi postów 
 * @author Tomasz
 */
public interface PostDAO {

    /**
     * metoda dodająca nowy post
     * @param post Post dodawany post
     */
    void addPost(Post post);

    /**
     * metoda zwracająca post wg. jego id
     * @param postId int id żądanego posta
     * @return Post odnaleziony w bazie danych post
     */
    Post getPostById(int postId);

    /**
     * metoda zwracająca posty wg. ich autora
     * @param userId int id autora
     * @return ArrayList lista postów
     */
    ArrayList<Post> getPostByUser(int userId);

    /**
     * metoda zwracająca posty wg. ich statusu
     * @param postStat int status
     * @return ArrayList lista postów
     */
    ArrayList<Post> getPostByStatus(int postStat);

    /**
     * metoda akceptująca post
     * @param postId int id postu
     */
    void acceptPost(int postId);

    /**
     * metoda odrzucająca post
     *
     * @param postId int id postu
     */
    void dismissPost(int postId);
}
