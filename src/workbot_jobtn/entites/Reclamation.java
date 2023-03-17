/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.entites;


import java.sql.Date;
import java.util.Objects;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author youcef
 */
public class Reclamation {
    private int id;
    private String objet;
    private String date;      
    private String description;
    private String image;
    private Categorie categorie;      
    private User user;
    private Offre offre;
    private ImageView img;
    private String etat;
    private String nomCat=null;
     public Reclamation() {
    }

    public Reclamation(int id, String objet, String date, String description, String image, Categorie categorie, User user, Offre offre, ImageView img, String etat) {
        this.id = id;
        this.objet = objet;
        this.date = date;
        this.description = description;
        this.image = image;
        this.categorie = categorie;
        this.user = user;
        this.offre = offre;
        this.img = img;
        this.etat = etat;
    }
    
    public Reclamation(String objet, String date, String description, String image, Categorie categorie, User user, Offre offre, ImageView img, String etat) {
        this.objet = objet;
        this.date = date;
        this.description = description;
        this.image = image;
        this.categorie = categorie;
        this.user = user;
        this.offre = offre;
        this.img = img;
        this.etat = etat;
    }

    public Reclamation(int id, String objet, String date, String description, String image, Categorie categorie, String etat, String nomCat) {
        this.id = id;
        this.objet = objet;
        this.date = date;
        this.description = description;
        this.image = image;
        this.categorie = categorie;
        this.etat = etat;
        this.nomCat=nomCat;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getImage() {
        return image;
    }

        
    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
        public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public String getNomCat() {
        return nomCat;
    }

    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }
    
}