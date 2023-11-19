/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolio.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author augu4
 */
public class dtoRedes {
     @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String instagram;
    private String linkedin;
    private String facebook;

    public dtoRedes() {
    }
    public dtoRedes(String instagram, String facebook, String linkedin){
        this.instagram=instagram;
        this.linkedin=linkedin;
        this.facebook=facebook;
    }
    public int getId() {
	return this.id;
    }
    public void setId(int id) {
            this.id = id;
    }
    public String getInstagram() {
            return this.instagram;
    }
    public void setInstagram(String instagram) {
            this.instagram = instagram;
    }
    public String getLinkedin() {
            return this.linkedin;
    }
    public void setLinkedin(String linkedin) {
            this.linkedin = linkedin;
    }
    public String getFacebook() {
            return this.facebook;
    }
    public void setFacebook(String facebook) {
            this.facebook = facebook;
    }
}
