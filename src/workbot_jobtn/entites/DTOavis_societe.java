/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbot_jobtn.entites;

import java.util.Objects;

/**
 *
 * @author youcef
 */
public class DTOavis_societe {
    private String nom;
    private int note_moy;
    private int note;
    private String desc;

    public DTOavis_societe() {
    }

    public DTOavis_societe(String nom, int note_moy, int note, String desc) {
        this.nom = nom;
        this.note_moy = note_moy;
        this.note = note;
        this.desc = desc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNote_moy() {
        return note_moy;
    }

    public void setNote_moy(int note_moy) {
        this.note_moy = note_moy;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

   
    @Override
    public String toString() {
        return "DTOavis_societe{" + "nom=" + nom + ", note_moy=" + note_moy + ", note=" + note + ", desc=" + desc + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.nom);
        hash = 61 * hash + this.note_moy;
        hash = 61 * hash + this.note;
        hash = 61 * hash + Objects.hashCode(this.desc);
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
        final DTOavis_societe other = (DTOavis_societe) obj;
        if (this.note_moy != other.note_moy) {
            return false;
        }
        if (this.note != other.note) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.desc, other.desc)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
