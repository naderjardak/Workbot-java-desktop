/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.entites;

import static java.lang.String.valueOf;
import java.util.Date;
import java.util.Objects;
import javafx.scene.control.Button;

/**
 *
 * @author Exon
 */
public class Offre {

    private int id;

    private String titre;

    private String Salaire;

    private String description;

    private String domaine;

    private String dateExpiration;

    private String dureeStage;

    private String typeStage;

    private String typeContrat;

    private String dureeContrat;

    private String anneeExperience;

    private String modeTravail;

    private String lieu;

    private Integer id_soc;

    private Integer id_test;

    private TypeOffre typeOffre;

    private String dateAjout;

    private int btn;

    public Offre(int id1, String titre, String Salaire, String desc, String domaine, String dateExp, String lieu, String modeTravail, String typeContrat, String tp) {
        //Offre d'emlpoi
        if (tp.equals("Emploi")) {
            this.id = id1;
            this.titre = titre;
            this.Salaire = Salaire;
            this.description = desc;
            this.domaine = domaine;
            this.dateExpiration = dateExp;
            this.typeContrat = typeContrat;
            this.modeTravail = modeTravail;
            this.lieu = lieu;
            this.typeOffre = TypeOffre.Emploi;
        }

        if (tp.equals("Stage")) {
            this.id = id1;
            this.titre = titre;
            this.dureeStage = Salaire;
            this.description = desc;
            this.domaine = domaine;
            this.dateExpiration = dateExp;
            this.typeStage = typeContrat;
            this.modeTravail = modeTravail;
            this.lieu = lieu;
            this.typeOffre = TypeOffre.Emploi;
        }

        if (tp.equals("Freelancer")) {
            this.id = id1;
            this.titre = titre;
            this.dureeStage = Salaire;
            this.description = desc;
            this.domaine = domaine;
            this.dateExpiration = dateExp;
            this.Salaire = typeContrat;
            this.modeTravail = modeTravail;
            this.lieu = lieu;
            this.typeOffre = TypeOffre.Emploi;
        }

    }

    public Offre(int id1, String titre, String Salaire, String desc, String domaine, String dateExp, String dureeStage, String typeStage, String lieu, int id_test, String dateAjout, String modeTravail, String duree, String typeContrat, int id_soc, String tp) {
        this.id = id1;
        this.titre = titre;
        this.Salaire = Salaire;
        this.description = desc;
        this.domaine = domaine;
        this.dateExpiration = dateExp;
        this.typeContrat = typeContrat;
        this.dureeStage = dureeStage;
        this.typeStage = typeStage;
        this.modeTravail = modeTravail;
        this.id_soc = id_soc;
        this.id_test = id_test;
        this.lieu = lieu;
        this.dateAjout = dateAjout;
        this.typeOffre = TypeOffre.valueOf(tp);
    }

    public Offre(Integer id, String titre, String salaire, String description, String domaine, String dateExpiration, String typeContrat, String typeOffre, Integer id_soc, String modeTravail, String lieu, Integer id_test) {
     this.id = id;
        this.titre = titre;
        this.Salaire = salaire;
        this.description = description;
        this.domaine = domaine;
        this.dateExpiration = dateExpiration;
        this.typeContrat = typeContrat;
        this.modeTravail = modeTravail;
        this.id_soc = id_soc;
        this.id_test = id_test;
        this.lieu = lieu;
        this.typeOffre = TypeOffre.valueOf(typeOffre);
    }

    public Offre(String titre, String duree, String desc, String domaine, String dateExp, String renumeration, String modeTravail, String lieu, int id_soc, TypeOffre typeOffre, String ty) {
        this.titre = titre;
        this.Salaire = renumeration;
        this.description = desc;
        this.domaine = domaine;
        this.dateExpiration = dateExp;
        this.modeTravail = modeTravail;
        this.id_soc = id_soc;
        this.lieu = lieu;
        this.typeOffre = typeOffre;
        this.typeContrat=ty;
        this.dureeStage=duree;
    }

  

    public int getBtn() {
        return btn;
    }

    public void setBtn(int btn) {
        this.btn = btn;
    }

    public Offre(int id, String titre, String Salaire, String description, String domaine, String dateExpiration) {
        this.id = id;
        this.titre = titre;
        this.Salaire = Salaire;
        this.description = description;
        this.domaine = domaine;
        this.dateExpiration = dateExpiration;
    }

    public Offre(int id, String titre, String desc, String domaine, String dateExp, String modeTravail, int id_soc, TypeOffre tp, String dateAjout, int btn) {
        this.id = id;
        this.titre = titre;
        this.description = desc;
        this.domaine = domaine;
        this.dateExpiration = dateExp;
        this.modeTravail = modeTravail;
        this.id_soc = id_soc;
        this.typeOffre = tp;
        this.dateAjout = dateAjout;
        this.btn = btn;
    }

    public String getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(String dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Offre() {
    }

    //non null
    public Offre(int id, String titre, String description, String domaine, String dateExpiration, String modeTravail, Integer id_soc, TypeOffre typeOffre) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.domaine = domaine;
        this.dateExpiration = dateExpiration;
        this.modeTravail = modeTravail;
        this.id_soc = id_soc;
        this.typeOffre = typeOffre;
        //this.dateAjout=new Date().toString();
    }

    public Offre(String titre, String Salaire_duree, String description, String domaine, String dateExpiration, String typeContrat, String modeTravail, String lieu, Integer id_soc, TypeOffre typeOffre) {
        //Offre d'emlpoi
        if ("Emploi".equals(valueOf(typeOffre))) {
            this.titre = titre;
            this.Salaire = Salaire_duree;
            this.description = description;
            this.domaine = domaine;
            this.dateExpiration = dateExpiration;
            this.typeContrat = typeContrat;
            this.modeTravail = modeTravail;
            this.lieu = lieu;
            this.id_soc = id_soc;
            this.typeOffre = typeOffre;
            // this.dateAjout=new Date().toString(); 
        }

        //Offre de stage
        if ("Stage".equals(valueOf(typeOffre))) {
            this.titre = titre;
            this.dureeStage = Salaire_duree;
            this.description = description;
            this.domaine = domaine;
            this.dateExpiration = dateExpiration;
            this.typeStage = typeContrat;
            this.modeTravail = modeTravail;
            this.lieu = lieu;
            this.id_soc = id_soc;
            this.typeOffre = typeOffre;
            //this.dateAjout=new Date().toString(); 
        }

        //Offre d'alternance
        if ("Freelancer".equals(valueOf(typeOffre))) {
            this.titre = titre;
            this.dureeStage = Salaire_duree;
            this.description = description;
            this.domaine = domaine;
            this.dateExpiration = dateExpiration;
            this.Salaire = typeContrat;
            this.modeTravail = modeTravail;
            this.lieu = lieu;
            this.id_soc = id_soc;
            this.typeOffre = typeOffre;
            //this.dateAjout=new Date().toString(); 
        }
    }
        public Offre( int id,String titre, String salaire, String description, String domaine, String dateExpiration, String dureeStage, String typeStage, String dureeContrat, String typeContrat, String anneeExperience, int id_Soc, String modeTravail, String lieu, int id_test /*String type*/,TypeOffre typeOffre) {
       this.id=id;
        this.titre = titre;
        this.Salaire = salaire;
        this.description = description;
        this.domaine = domaine;
        this.dateExpiration = dateExpiration;
        this.dureeStage = dureeStage;
        this.typeStage = typeStage;
        this.dureeContrat = dureeContrat;
        this.typeContrat = typeContrat;
        this.anneeExperience = anneeExperience;
        this.id_soc = id_Soc;
        this.modeTravail = modeTravail;
        this.lieu = lieu;
        this.id_test = id_test;
        this.typeOffre = typeOffre;
    }
          public Offre(int id, String titre, String salaire, String description, String domaine) {
        this.id = id;
        this.titre = titre;
        this.Salaire = salaire;
        this.description = description;
        this.domaine = domaine;
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

    public String getSalaire() {
        return Salaire;
    }

    public void setSalaire(String Salaire) {
        this.Salaire = Salaire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public String getDureeStage() {
        return dureeStage;
    }

    public void setDureeStage(String dureeStage) {
        this.dureeStage = dureeStage;
    }

    public String getTypeStage() {
        return typeStage;
    }

    public void setTypeStage(String typeStage) {
        this.typeStage = typeStage;
    }

    public String getDureeContrat() {
        return dureeContrat;
    }

    public void setDureeContrat(String dureeContrat) {
        this.dureeContrat = dureeContrat;
    }

    public String getAnneeExperience() {
        return anneeExperience;
    }

    public void setAnneeExperience(String anneeExperience) {
        this.anneeExperience = anneeExperience;
    }

    public String getModeTravail() {
        return modeTravail;
    }

    public void setModeTravail(String modeTravail) {
        this.modeTravail = modeTravail;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Integer getId_soc() {
        return id_soc;
    }

    public void setId_soc(Integer id_soc) {
        this.id_soc = id_soc;
    }

    public Integer getId_test() {
        return id_test;
    }

    public void setId_test(Integer id_test) {
        this.id_test = id_test;
    }

    public TypeOffre getTypeOffre() {
        return typeOffre;
    }

    public void setTypeOffre(TypeOffre typeOffre) {
        this.typeOffre = typeOffre;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    @Override
    public String toString() {
        return "I_Offre{" + "id=" + id + ", titre=" + titre + ", Salaire=" + Salaire + ", description=" + description + ", domaine=" + domaine + ", dateExpiration=" + dateExpiration + ", dureeStage=" + dureeStage + ", typeStage=" + typeStage + ", dureeContrat=" + dureeContrat + ", anneeExperience=" + anneeExperience + ", modeTravail=" + modeTravail + ", lieu=" + lieu + ", id_soc=" + id_soc + ", id_test=" + id_test + ", typeOffre=" + typeOffre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.titre);
        hash = 29 * hash + Objects.hashCode(this.domaine);
        hash = 29 * hash + Objects.hashCode(this.id_soc);
        hash = 29 * hash + Objects.hashCode(this.typeOffre);
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
        final Offre other = (Offre) obj;
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.domaine, other.domaine)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.id_soc, other.id_soc)) {
            return false;
        }
        return this.typeOffre == other.typeOffre;
    }
}
