/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.entites;

import java.util.Objects;

/**
 *
 * @author Exon
 */
public class Entretien {

    private int id;

    private String date;

    private String lienMeet;

    private Integer id_Candidature;

    private Integer heure;

    public Entretien() {
    }

    public Entretien(Integer id, String date, String lienMeet, Integer id_Candidature, Integer heure) {
        this.id = id;
        this.date = date;
        this.lienMeet = lienMeet;
        this.id_Candidature = id_Candidature;
        this.heure = heure;
    }

    public Entretien(String date, String lienMeet, Integer id_Candidature, Integer heure) {
        
        this.date = date;
        this.lienMeet = lienMeet;
        this.id_Candidature = id_Candidature;
        this.heure = heure;
    }

    public Integer getHeure() {
        return heure;
    }

    public void setHeure(Integer heure) {
        this.heure = heure;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLienMeet() {
        return lienMeet;
    }

    public void setLienMeet(String lienMeet) {
        this.lienMeet = lienMeet;
    }

    public Integer getId_Candidature() {
        return id_Candidature;
    }

    public void setId_Candidature(Integer id_Candidature) {
        this.id_Candidature = id_Candidature;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.date);
        hash = 59 * hash + Objects.hashCode(this.lienMeet);
        hash = 59 * hash + Objects.hashCode(this.id_Candidature);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entretien other = (Entretien) obj;
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.lienMeet, other.lienMeet)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.id_Candidature, other.id_Candidature);
    }

    @Override
    public String toString() {
        return "I_entretien{" + "id=" + id + ", date=" + date + ", lienMeet=" + lienMeet + ", id_Candidature=" + id_Candidature + '}';
    }

}
