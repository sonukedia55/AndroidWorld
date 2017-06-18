package com.example.lostnfound;

/**
 * Created by Sonu Kedia on 02/06/2017.
 */

public class Eventing {
    private  String contact, material,place,whatis,catag;




    public Eventing(String contact, String material, String place, String whatis, String catag) {

        //this.setContent(content);
        this.setContact(contact);
        this.setMaterial(material);
        this.setPlace(place);
        this.setWhatis(whatis);
        this.setCatag(catag);


    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getWhatis() {
        return whatis;
    }

    public void setWhatis(String whatis) {
        this.whatis = whatis;
    }

    public String getCatag() {
        return catag;
    }

    public void setCatag(String catag) {
        this.catag = catag;
    }
}