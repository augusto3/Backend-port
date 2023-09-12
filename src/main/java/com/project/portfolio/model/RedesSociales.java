package com.project.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class RedesSociales {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String instagram;
    private String linkedin;
    private String facebook;

    public RedesSociales() {
    }
    public RedesSociales(String instagram, String facebook, String linkedin){
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