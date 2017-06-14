package com.example.chat;

/**
 * Created by Sonu Kedia on 02/06/2017.
 */

public class Eventing {
    private  String recip, material,side;




    public Eventing(String recip, String material, String side) {

        //this.setContent(content);
        this.setRecip(recip);
        this.setMaterial(material);
        this.setSide(side);


    }

    public String getRecip() {
        return recip;
    }

    public void setRecip(String recip) {
        this.recip = recip;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }
}