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
public class Candidat extends User {
    private int id;
    private String diplome;
    private String experience;
    private String niveauFr;
    private String niveauAng;
    private String competance;
    private String cv;
    private String portfolio;
    private String bio;
    private String typeCandidat;
    private String note;
    private String domaine;

    public Candidat(String domaine, String nom, String prenom, String role, String tel, String email, String adresse) {
        super(nom, prenom, role, tel, email, adresse);
        this.domaine = domaine;
    }

    public Candidat(String domaine, int id, String nom, String prenom, String role, String tel, String email, String adresse) {
        super(id, nom, prenom, role, tel, email, adresse);
        this.domaine = domaine;
    }

    public String getDomaine() {
        return domaine;
    }
     

    public String getDiplome() {
        return diplome;
    }

    public String getExperience() {
        return experience;
    }

    public String getNiveauFr() {
        return niveauFr;
    }

    public String getNiveauAng() {
        return niveauAng;
    }

    public String getCompetance() {
        return competance;
    }

    public String getCv() {
        return cv;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public String getBio() {
        return bio;
    }

    public String getTypeCandidat() {
        return typeCandidat;
    }

    public String getNote() {
        return note;
    }

    public int getId() {
        return id;
    }

    public Candidat(int id, String diplome, String experience, String niveauFr, String niveauAng, String competance, String cv, String portfolio, String bio, String typeCandidat, String note) {
        this.id = id;
        this.diplome = diplome;
        this.experience = experience;
        this.niveauFr = niveauFr;
        this.niveauAng = niveauAng;
        this.competance = competance;
        this.cv = cv;
        this.portfolio = portfolio;
        this.bio = bio;
        this.typeCandidat = typeCandidat;
        this.note = note;
        
    }

    public Candidat(String diplome, String experience, String niveauFr, String niveauAng, String competance, String cv, String portfolio, String bio, String typeCandidat, String note) {
        this.diplome = diplome;
        this.experience = experience;
        this.niveauFr = niveauFr;
        this.niveauAng = niveauAng;
        this.competance = competance;
        this.cv = cv;
        this.portfolio = portfolio;
        this.bio = bio;
        this.typeCandidat = typeCandidat;
        this.note = note;
    }

    public Candidat() {
    } 
}
