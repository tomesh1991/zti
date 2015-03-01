/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.LinkedPost;
import java.util.ArrayList;

/**
 * interfejs DAO do obsługi postów z linkiem
 *
 * @author Tomasz
 */
public interface LinkedPostDAO {

    /**
     * metoda dodająca nowy post z linkiem
     *
     * @param post Post dodawany post
     */
    void addLinkedPost(LinkedPost post);

    /**
     * metoda zwracająca post z linkiem wg. jego id
     *
     * @param postId int id żądanego posta
     * @return Post odnaleziony w bazie danych post
     */
    LinkedPost getLinkedPostById(int postId);

    /**
     * metoda zwracająca posty z linkiem wg. ich autora
     *
     * @param userId int id autora
     * @return ArrayList lista postów
     */
    ArrayList<LinkedPost> getLinkedPostByUser(int userId);

    /**
     * metoda zwracająca posty z linkiem wg. ich statusu
     *
     * @param postStat int status
     * @return ArrayList lista postów
     */
    ArrayList<LinkedPost> getLinkedPostByStatus(int postStat);

    /**
     * metoda akceptująca post z linkiem
     *
     * @param postId int id postu
     */
    void acceptPost(int postId);

    /**
     * metoda odrzucająca post z linkiem
     *
     * @param postId int id postu
     */
    void dismissPost(int postId);
}
