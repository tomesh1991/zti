/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Tomasz
 */
public class Comment {

    private int commId;
    private int commPostId;
    private int commUserId;
    private String commText;
    private String commTimestamp;

    public Comment() {
    }

    public Comment(int commId, int commPostId, int commUserId, String commText, String commTimestamp) {
        this.commId = commId;
        this.commPostId = commPostId;
        this.commUserId = commUserId;
        this.commText = commText;
        this.commTimestamp = commTimestamp;
    }

    public int getCommId() {
        return commId;
    }

    public void setCommId(int commId) {
        this.commId = commId;
    }

    public int getCommPostId() {
        return commPostId;
    }

    public void setCommPostId(int commPostId) {
        this.commPostId = commPostId;
    }

    public int getCommUserId() {
        return commUserId;
    }

    public void setCommUserId(int commUserId) {
        this.commUserId = commUserId;
    }

    public String getCommText() {
        return commText;
    }

    public void setCommText(String commText) {
        this.commText = commText;
    }

    public String getCommTimestamp() {
        return commTimestamp;
    }

    public void setCommTimestamp(String commTimestamp) {
        this.commTimestamp = commTimestamp;
    }

}
