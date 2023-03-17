/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.entites;

/**
 *
 * @author ADMIN
 */
public class Certification {

   
    private int id;
    private String titreCours,titreTest,dateAjout,lien;
    
    public Certification() {
    }

    public Certification(int id) {
        this.id = id;
    }

    public Certification(String titreCours, String titreTest, String dateAjout, String lien) {
        this.titreCours = titreCours;
        this.titreTest = titreTest;
        this.dateAjout = dateAjout;
        this.lien = lien;
    }
    
    public Certification(int id, String titreCours, String titreTest, String dateAjout, String lien) {
        this.id = id;
        this.titreCours = titreCours;
        this.titreTest = titreTest;
        this.dateAjout = dateAjout;
        this.lien = lien;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitreCours() {
        return titreCours;
    }

    public void setTitreCours(String titreCours) {
        this.titreCours = titreCours;
    }

    public String getTitreTest() {
        return titreTest;
    }

    public void setTitreTest(String titreTest) {
        this.titreTest = titreTest;
    }

    public String getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(String dateAjout) {
        this.dateAjout = dateAjout;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    @Override
    public String toString() {
        return "Certification{" + "id=" + id + ", titreCours=" + titreCours + ", titreTest=" + titreTest + ", dateAjout=" + dateAjout + ", lien=" + lien + '}';
    }
    
    
}
