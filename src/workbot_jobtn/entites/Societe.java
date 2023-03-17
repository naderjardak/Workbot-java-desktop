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
public class Societe extends User {
    
private int id;
    private String formeJuridique;
    private String raisionSociale;
    private String domaine;
    private String pattente;
    private String nomSociéte;
    private String experience;
    private String bio;

    public String getFormeJuridique() {
        return formeJuridique;
    }

    public String getRaisionSociale() {
        return raisionSociale;
    }

    public String getDomaine() {
        return domaine;
    }

    public String getPattente() {
        return pattente;
    }

    public String getNomSociéte() {
        return nomSociéte;
    }

    public String getExperience() {
        return experience;
    }

    public String getBio() {
        return bio;
    }

    public int getId() {
        return id;
    }

    public Societe(int id, String formeJuridique, String raisionSociale, String domaine, String pattente, String nomSociéte, String experience, String bio) {
        this.id = id;
        this.formeJuridique = formeJuridique;
        this.raisionSociale = raisionSociale;
        this.domaine = domaine;
        this.pattente = pattente;
        this.nomSociéte = nomSociéte;
        this.experience = experience;
        this.bio = bio;
    }

    public Societe(String formeJuridique, String raisionSociale, String domaine, String pattente, String nomSociéte, String experience, String bio) {
        this.formeJuridique = formeJuridique;
        this.raisionSociale = raisionSociale;
        this.domaine = domaine;
        this.pattente = pattente;
        this.nomSociéte = nomSociéte;
        this.experience = experience;
        this.bio = bio;
    }

    public Societe() {
    }

    
    
}

