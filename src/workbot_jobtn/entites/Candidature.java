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
public class Candidature {
    private int id;
    private String statut;
    private String lettreMotivation; 
    private String noteTest;
    private String dateAjout ;

    private int id_offre;
    private int idcondidat;
    private String NiveauFrancais;
    private String NiveauAnglais;
    private String Cv;
    private String Experience;
    private String TypeCondidature;
    private String diplome;
private String  Domaine;
private String titre;
private String dateExpiration;

    public Candidature() {
    }

    public Candidature(int id, String statut, String lettreMotivation, String noteTest, String dateAjout, int id_offre, int idcondidat, String NiveauFrancais, String NiveauAnglais, String Cv, String Experience,String TypeCondidature, String diplome,String Domaine,String titre,String dateExpiration) {
        this.id = id;
        this.statut = statut;
        this.lettreMotivation = lettreMotivation;
        this.noteTest = noteTest;
        this.dateAjout = dateAjout;
        this.id_offre = id_offre;
        this.idcondidat = idcondidat;
        this.NiveauFrancais = NiveauFrancais;
        this.NiveauAnglais = NiveauAnglais;
        this.Cv = Cv;
        this.Experience = Experience;
        this.TypeCondidature = TypeCondidature;
        this.diplome = diplome;
          this.Domaine = Domaine;
         this.titre = titre;
         this.dateExpiration = dateExpiration;
      
        
    }

    public Candidature(int id, String statut, String lettreMotivation, String noteTest, String dateAjout, int id_offre, String NiveauFrancais, String NiveauAnglais, String Cv, String Experience,String TypeCondidature, String diplome,String Domaine,String titre,String dateExpiration) {
        this.id = id;
        this.statut = statut;
        this.lettreMotivation = lettreMotivation;
        this.noteTest = noteTest;
        this.dateAjout = dateAjout;
        this.id_offre = id_offre;
        this.NiveauFrancais = NiveauFrancais;
        this.NiveauAnglais = NiveauAnglais;
        this.Cv = Cv;
        this.Experience = Experience;
         this.TypeCondidature = TypeCondidature;
        this.diplome = diplome;
          this.Domaine = Domaine;
         this.titre = titre;
           this.dateExpiration = dateExpiration;
    }

    public Candidature(String statut, String lettreMotivation, String noteTest,String dateAjout, int id_offre, String NiveauFrancais, String NiveauAnglais, String Cv, String Experience,String TypeCondidature, String diplome,String Domaine,String titre,String dateExpiration) {
        this.statut = statut;
        this.lettreMotivation = lettreMotivation;
        this.noteTest = noteTest;
        this.dateAjout = dateAjout;
        this.id_offre = id_offre;
        this.NiveauFrancais = NiveauFrancais;
        this.NiveauAnglais = NiveauAnglais;
        this.Cv = Cv;
        this.Experience = Experience;
         this.TypeCondidature = TypeCondidature;
        this.diplome = diplome;
          this.Domaine = Domaine;
         this.titre = titre;
           this.dateExpiration = dateExpiration;
    }

  
    
    public Candidature(String statut, String lettreMotivation, String noteTest, String dateAjout, int id_offre, int idcondidat, String NiveauFrancais, String NiveauAnglais, String Cv, String Experience,String TypeCondidature, String diplome,String Domaine,String titre,String dateExpiration) {
        this.statut = statut;
        this.lettreMotivation = lettreMotivation;
        this.noteTest = noteTest;
        this.dateAjout = dateAjout;
        this.id_offre = id_offre;
        this.idcondidat = idcondidat;
        this.NiveauFrancais = NiveauFrancais;
        this.NiveauAnglais = NiveauAnglais;
        this.Cv = Cv;
        this.Experience = Experience;
         this.TypeCondidature = TypeCondidature;
        this.diplome = diplome;
         this.Domaine = Domaine;
         this.titre = titre;
           this.dateExpiration = dateExpiration;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

   

    public String getDomaine() {
        return Domaine;
    }

    public void setDomaine(String Domaine) {
        this.Domaine = Domaine;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getLettreMotivation() {
        return lettreMotivation;
    }

    public void setLettreMotivation(String lettreMotivation) {
        this.lettreMotivation = lettreMotivation;
    }

    public String getNoteTest() {
        return noteTest;
    }

    public void setNoteTest(String noteTest) {
        this.noteTest = noteTest;
    }

    public String getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(String dateAjout) {
        this.dateAjout = dateAjout;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }



    public int getIdcondidat() {
        return idcondidat;
    }

    public void setIdcondidat(int idcondidat) {
        this.idcondidat = idcondidat;
    }

    public String getNiveauFrancais() {
        return NiveauFrancais;
    }

    public void setNiveauFrancais(String NiveauFrancais) {
        this.NiveauFrancais = NiveauFrancais;
    }

    public String getNiveauAnglais() {
        return NiveauAnglais;
    }

    public void setNiveauAnglais(String NiveauAnglais) {
        this.NiveauAnglais = NiveauAnglais;
    }

    public String getCv() {
        return Cv;
    }

    public void setCv(String Cv) {
        this.Cv = Cv;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String Experience) {
        this.Experience = Experience;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getTypeCondidature() {
        return TypeCondidature;
    }

    public void setTypeCondidature(String TypeCondidature) {
        this.TypeCondidature = TypeCondidature;
    }
    
    
    
}
