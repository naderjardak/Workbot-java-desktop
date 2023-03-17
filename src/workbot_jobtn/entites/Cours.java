/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.entites;

/**
 *
 * @author ADMIN
 */
public class Cours {
    private int nb;
    private int id;
    private String titre,matiere,domaine,categorie,chemin;
    private String logo;

    public Cours( int id, String titre, String matiere, String domaine, String categorie, String chemin, String logo) {
        this.id = id;
        this.titre = titre;
        this.matiere = matiere;
        this.domaine = domaine;
        this.categorie = categorie;
        this.chemin = chemin;
        this.logo = logo;
    }

    
    
    public Cours(String titre, String matiere, String domaine, String categorie, String chemin, String logo) {
        this.titre = titre;
        this.matiere = matiere;
        this.domaine = domaine;
        this.categorie = categorie;
        this.chemin = chemin;
        this.logo = logo;
    }
    
    
    
    public Cours(int nb, String domaine) {
        this.nb = nb;
        this.domaine = domaine;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    
    
    public Cours(int id) {
        this.id = id;
    }

    
    public Cours(String titre, String domaine, String categorie) {
        this.titre = titre;
        this.domaine = domaine;
        this.categorie = categorie;
    }
    

    public Cours(int id, String titre, String matiere, String domaine, String categorie, String chemin) {
        this.id = id;
        this.titre = titre;
        this.matiere = matiere;
        this.domaine = domaine;
        this.categorie = categorie;
        this.chemin = chemin;
    }

    public Cours(String titre, String matiere, String domaine, String categorie, String chemin) {
        this.titre = titre;
        this.matiere = matiere;
        this.domaine = domaine;
        this.categorie = categorie;
        this.chemin = chemin;
    }

    public Cours(String titre, String matiere, String domaine, String categorie) {
        this.titre = titre;
        this.matiere = matiere;
        this.domaine = domaine;
        this.categorie = categorie;
    }

    public Cours() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    
    

    @Override
    public String toString() {
        return "cours{" + "id=" + id + ", titre=" + titre + ", matiere=" + matiere + ", domaine=" + domaine + ", categorie=" + categorie + ", chemin=" + chemin + '}';
    }
    
    
}
