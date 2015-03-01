/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Comment;
import bean.Person;
import java.util.ArrayList;

/**
 * interfejs DAO do obsługi komentarzy 
 * @author Tomasz
 */
public interface CommentDAO {

    /**
     * metoda dodająca nowy komentarz
     * @param comm Comment dodawany komentarz
     */
    void addComment(Comment comm);

    /**
     * metoda zwracająca komentarz wg. jego id
     * @param commId int id komentarza
     * @return Comment odnaleziony w bazie danych komentarz
     */
    Comment getCommentById(int commId);

    /**
     * metoda zwracająca komentarze wg. postu, do którego są przypisane
     * @param postId int id posta
     * @return ArrayList lista komentarzy
     */
    ArrayList<Comment> getCommentByPost(int postId);

    /**
     * metoda zwracająca komentarze wg. id uzytkownika, który ja napisał
     * @param userId int id użytkownika
     * @return ArrayList lista komentarzy
     */
    ArrayList<Comment> getCommentByUser(int userId);
}
