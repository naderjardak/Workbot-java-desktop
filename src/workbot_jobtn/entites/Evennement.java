/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.entites;

/**
 *
 * @author hp
 */
public class Evennement {
    private int id;
private String dateDebut;
private String dateFin;
private String libelle;
private String heureDebut;
private String heureFin;
private int nbPlaces;
private String prix;
private String flyer;
private String video;
private int id_user;

    public Evennement() {
    }

    public Evennement(int id) {
        this.id = id;
    }

    public Evennement(String dateDebut, String dateFin, String libelle, String heureDebut, String heureFin, int nbPlaces, String prix, String flyer, String video, int id_user) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.libelle = libelle;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.nbPlaces = nbPlaces;
        this.prix = prix;
        this.flyer = flyer;
        this.video = video;
        this.id_user = id_user;
    }

    public Evennement(int id, String dateDebut, String dateFin, String libelle, String heureDebut, String heureFin, int nbPlaces, String prix, String flyer, String video, int id_user) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.libelle = libelle;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.nbPlaces = nbPlaces;
        this.prix = prix;
        this.flyer = flyer;
        this.video = video;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getFlyer() {
        return flyer;
    }

    public void setFlyer(String flyer) {
        this.flyer = flyer;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
