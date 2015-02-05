/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Klotor90
 */
public class LinkedPost extends Post{
    private String URL;
    
    public LinkedPost(){}
    public LinkedPost(String textContent, String Author, String URL)
    {
        super.setTextContent(textContent);
        super.setAuthor(Author);
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    
    @Override
    public String toString()
    {
        return "Post by " + super.getAuthor() + ": " + super.getTextContent() + " #" + this.URL;
    }
}
