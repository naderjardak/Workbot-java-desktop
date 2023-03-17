/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.entites;

import javafx.scene.control.TextField;

/**
 *
 * @author Exon
 */
public class DTOCandidature_Offre {
    
    private String nomCandidat;
    
    private String dateAjout;
    
    private String noteTest;
    
    private String lettreMotivation;
    
    private String statut;
    
    private String titreOffre;
    
    private String salaire;
    
    private TextField note;

    public int getId_cand() {
        return id_cand;
    }

    public void setId_cand(int id_cand) {
        this.id_cand = id_cand;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private int id_off;
    private int id_cand;
    
    private String email;
    
    private int id_user;
    
    private String tel;

    public DTOCandidature_Offre() {
    }

    
    public DTOCandidature_Offre(int id_cand,String nomCandidat, String dateAjout, String noteTest, String lettreMotivation, String statut, String titreOffre,int id,String salaire,int id_off,String tel) {
        this.id_cand=id_cand;
        this.nomCandidat = nomCandidat;
        this.dateAjout = dateAjout;
        this.noteTest = noteTest;
        this.lettreMotivation = lettreMotivation;
        this.statut = statut;
        this.titreOffre = titreOffre;
        this.id_user=id;
        this.salaire=salaire;
        this.id_off=id_off;
        this.tel=tel;
       // this.note = new TextField(noteTest);

    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSalaire() {
        return salaire;
    }

    public void setSalaire(String salaire) {
        this.salaire = salaire;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_off() {
        return id_off;
    }

    public void setId_off(int id_off) {
        this.id_off = id_off;
    }
    
    
    

    public String getNomCandidat() {
        return nomCandidat;
    }

    public void setNomCandidat(String nomCandidat) {
        this.nomCandidat = nomCandidat;
    }

    public String getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(String dateAjout) {
        this.dateAjout = dateAjout;
    }

    public String getNoteTest() {
        return noteTest;
    }

    public void setNoteTest(String noteTest) {
        this.noteTest = noteTest;
    }

    public String getLettreMotivation() {
        return lettreMotivation;
    }

    public void setLettreMotivation(String lettreMotivation) {
        this.lettreMotivation = lettreMotivation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getTitreOffre() {
        return titreOffre;
    }

    public void setTitreOffre(String titreOffre) {
        this.titreOffre = titreOffre;
    }

    public TextField getNote() {
        return note;
    }

    public void setNote(TextField note) {
        this.note = note;
    }
    
    
    
}
