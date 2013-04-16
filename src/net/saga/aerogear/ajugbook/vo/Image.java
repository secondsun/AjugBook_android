/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.saga.aerogear.ajugbook.vo;

import android.util.Base64;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Summers
 */
public class Image implements Serializable {

    private Long id;
    private String ownerName;
    private String imageData;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String owernName) {
        this.ownerName = owernName;
    }

    public byte[] getImageBytes() {
        return Base64.decode(imageData, Base64.DEFAULT);
    }

    public String getImageData() {
    	return imageData;
    }
    
    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public String getImageBase64() {
        if (imageData != null) {
            return imageData;
        } else {
            return null;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
