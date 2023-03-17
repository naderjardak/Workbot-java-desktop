/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbot_jobtn.entites;

/**
 *
 * @author fnmoh
 */
public class User {
    private int id;
    private String nom;
    private String prenom;
    private String role;
    private String tel;
    private String email;
    private String mdp;
    private String adresse;
    private String photo;
    private String questionSecu;
    private String reponseSecu;
    private String methode;
    private String domaine;
    private String mdpsymfony;
    private String roles;
    private String note;


    public User(String nom, String note) {
        this.nom = nom;
        this.note = note;
    }

    public User(String nom, String prenom, String role, String tel, String email, String mdp, String adresse, String photo, String questionSecu, String reponseSecu, String methode) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.tel = tel;
        this.email = email;
        this.mdp = mdp;
        this.adresse = adresse;
        this.photo = photo;
        this.questionSecu = questionSecu;
        this.reponseSecu = reponseSecu;
        this.methode = methode;
    }

    public User(int id) {
        this.id=id;
    }



    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getMdpsymfony() {
        return mdpsymfony;
    }

    public void setMdpsymfony(String mdpsymfony) {
        this.mdpsymfony = mdpsymfony;
    }
    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getRole() {
        return role;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getPhoto() {
        return photo;
    }

    public String getQuestionSecu() {
        return questionSecu;
    }

    public String getReponseSecu() {
        return reponseSecu;
    }

    public String getMethode() {
        return methode;
    }

    public User(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public User(int id, String nom, String prenom, String role, String tel, String email, String mdp, String adresse, String photo, String questionSecu, String reponseSecu, String methode, String domaine) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.tel = tel;
        this.email = email;
        this.mdp = mdp;
        this.adresse = adresse;
        this.photo = photo;
        this.questionSecu = questionSecu;
        this.reponseSecu = reponseSecu;
        this.methode = methode;
        this.domaine = domaine;
    }

    public User() {
    }

    public User(String nom, String prenom, String role, String tel, String email, String mdp, String adresse, String photo, String questionSecu, String reponseSecu, String methode,String mdpsymfony,String roles) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.tel = tel;
        this.email = email;
        this.mdp = mdp;
        this.adresse = adresse;
        this.photo = photo;
        this.questionSecu = questionSecu;
        this.reponseSecu = reponseSecu;
        this.methode = methode;
        this.mdpsymfony = mdpsymfony;
        this.roles = roles;
        
    }

    public User(int id, String nom, String prenom, String email, String mdp) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
    }

    public User(int id, String nom, String prenom, String role, String tel, String email, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.tel = tel;
        this.email = email;
        this.adresse = adresse;
    }

    public User(String nom, String prenom, String role, String tel, String email, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.tel = tel;
        this.email = email;
        this.adresse = adresse;
    }

    
}