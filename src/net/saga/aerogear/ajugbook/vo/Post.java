/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.saga.aerogear.ajugbook.vo;


import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable {

    private Long id;
    private String authorUsername;
    private String text;

    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String author) {
        this.authorUsername = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
