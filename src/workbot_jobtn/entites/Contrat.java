/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbot_jobtn.entites;

import java.util.Date;

/**
 *
 * @author Administrateur
 */
public class Contrat {
    
    private int id;
    private String typeContrat;
private Date dateDebut;
private String salaire;
private Date dateFin;
private String lien;
private int id_candidature;
private Date dateCreation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getSalaire() {
        return salaire;
    }

    public void setSalaire(String salaire) {
        this.salaire = salaire;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public int getId_candidature() {
        return id_candidature;
    }

    public void setId_candidature(int id_candidature) {
        this.id_candidature = id_candidature;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Contrat() {
    }

    public Contrat(int id, String typeContrat, Date dateDebut, String salaire, Date dateFin, String lien, int id_candidature, Date dateCreation) {
        this.id = id;
        this.typeContrat = typeContrat;
        this.dateDebut = dateDebut;
        this.salaire = salaire;
        this.dateFin = dateFin;
        this.lien = lien;
        this.id_candidature = id_candidature;
        this.dateCreation = dateCreation;
    }

    public Contrat(String typeContrat, Date dateDebut, String salaire, Date dateFin, String lien, int id_candidature, Date dateCreation) {
        this.typeContrat = typeContrat;
        this.dateDebut = dateDebut;
        this.salaire = salaire;
        this.dateFin = dateFin;
        this.lien = lien;
        this.id_candidature = id_candidature;
        this.dateCreation = dateCreation;
    }
   




}
