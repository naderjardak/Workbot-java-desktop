/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.entites;

/**
 *
 * @author Exon
 */
public class DTOEntretien {
    private String nomCand;
        private String date;
    private String heure;
    private String lien;

    public DTOEntretien() {
    }

    public DTOEntretien(String nomCand, String date, String heure,String lien) {
        this.nomCand = nomCand;
        this.date = date;
        this.heure = heure;
                this.lien=lien;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getNomCand() {
        return nomCand;
    }

    public void setNomCand(String nomCand) {
        this.nomCand = nomCand;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    @Override
    public String toString() {
        return "DTOEntretien{" + "nomCand=" + nomCand + ", date=" + date + ", heure=" + heure + ", lien=" + lien + '}';
    }
    
    

}
