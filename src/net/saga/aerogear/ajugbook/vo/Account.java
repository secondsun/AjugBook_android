/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.saga.aerogear.ajugbook.vo;

import java.io.Serializable;

/**
 *
 * @author Summers
 */
public class Account implements Serializable {
    private Long id;
    
    private Image image;
    
    
    private String accountUserName;

    public String getAccountUserName() {
        return accountUserName;
    }

    public void setAccountUserName(String userName) {
        this.accountUserName = userName;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
