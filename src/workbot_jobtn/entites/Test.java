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
public class Test {

    private int id;

    private String titre;

    private String domaine;

    private String description;

    private String lien;

    private String categorie;

    private int id_soc;

    public int getId_soc() {
        return id_soc;
    }

    public void setId_soc(int id_soc) {
        this.id_soc = id_soc;
    }

    public Test() {
    }

    public Test(String titre, String lien) {
        this.titre = titre;
        this.lien = lien;
    }

    public Test(Integer id, String titre, String domaine, String description, String lien, String categorie) {
        this.id = id;
        this.titre = titre;
        this.domaine = domaine;
        this.description = description;
        this.lien = lien;
        this.categorie = categorie;
    }

    public Test(String titre, String domaine, String description, String lien, String categorie) {
        this.titre = titre;
        this.domaine = domaine;
        this.description = description;
        this.lien = lien;
        this.categorie = categorie;
    }

    public Test(int id, String titre, String lien) {
        this.id = id;
        this.titre = titre;
        this.lien = lien;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.titre);
        hash = 31 * hash + Objects.hashCode(this.lien);
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
        final Test other = (Test) obj;
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.lien, other.lien)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "I_Test{" + "id=" + id + ", titre=" + titre + ", domaine=" + domaine + ", description=" + description + ", lien=" + lien + ", categorie=" + categorie + '}';
    }

}
