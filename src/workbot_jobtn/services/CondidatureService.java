/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbot_jobtn.services;

import workbot_jobtn.entites.Candidature;
import workbot_jobtn.entites.Contrat;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import workbot_jobtn.utils.MyDB;
import workbot_jobtn.utils.SessionManager;
/**
 *
 * @author Administrateur
 */
public class CondidatureService {
      Connection connexion;   
  public CondidatureService() {
        connexion = MyDB.getInstance().getConnection();
    } 
    
    
    
    
     public void modifierCondidature(Candidature u) throws SQLException, NoSuchAlgorithmException {
        String req = "UPDATE candidature SET "
                + "statut ='"   +   u.getStatut()+"'"
                + ", lettreMotivation='"+  u.getLettreMotivation()+"'"
                + ", noteTest='"+u.getNoteTest()+"'"
                + ", dateAjout='" + u.getDateAjout()+"'"
                + ", id_offre='"+u.getId_offre()+"'"
         + ", idcondidat='"+u.getIdcondidat()+"'"
                + ", NiveauFrancais='"+u.getNiveauFrancais()+"'"
                 + ", NiveauAnglais='"+u.getNiveauAnglais()+"'"
                 + ", Cv='"+u.getCv()+"'"
                 + ", Experience='"+u.getExperience()+"'"
                  + ", TypeCondidature='"+u.getTypeCondidature()+"'"
                
                + ", diplome='"+u.getDiplome()+"'"
                + ", Domaine='"+u.getDomaine()+"'"
                + ", titre='"+u.getDomaine()+"'"
                + ", dateExpiration='"+   u.getDateExpiration()+"' where id  = "+u.getId()+"";
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);
    }   
     
         public void SupprimerCandidature(Candidature u) throws SQLException {

        String req = "DELETE FROM candidature WHERE id =?";
        try {
            PreparedStatement ps = connexion.prepareStatement(req);
            ps.setInt(1, u.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }
     
    
 public void AjouterCandidateure(Candidature u) throws SQLException {
        String req = "INSERT INTO `candidature` (`statut`,`lettreMotivation`,`noteTest`,`dateAjout`,`id_offre`,`idcondidat`,`NiveauFrancais`,`NiveauAnglais`,`Cv`,`Experience`,`TypeCondidature`,`diplome`,`Domaine`,`titre`,`dateExpiration`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        System.out.println("!!!11111"+req);
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setString(1, "non traité");
         ps.setString(2,  u.getLettreMotivation());
        ps.setString(3, u.getNoteTest());
   ps.setString(4,  u.getDateAjout());
    ps.setInt(5, u.getId_offre());
      ps.setInt(6, u.getIdcondidat());
       ps.setString(7, u.getNiveauFrancais());
        ps.setString(8, u.getNiveauAnglais());
         ps.setString(9, u.getCv());  
    
            ps.setString(10, u.getExperience());   
            ps.setString(11, u.getTypeCondidature());  
ps.setString(12, u.getDiplome());  
ps.setString(13, u.getDomaine());  
ps.setString(14, u.getTitre());  
ps.setString(15,  u.getDateExpiration());  
                System.out.println("!!!"+ps);

        ps.executeUpdate();
                        System.out.println("!!!33"+req);


    }
 
    public List<Candidature> AfficherAllCandidature() throws SQLException {

        List<Candidature> assu = new ArrayList<>();
         
       
        String req = "select * from candidature where TypeCondidature != 'Freelancer' and idcondidat="+SessionManager.getId();
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Candidature u = new Candidature(rst.getInt("id")
                    , rst.getString("statut")
                    , rst.getString("lettreMotivation")
                    , rst.getString("noteTest")
                    , rst.getString("dateAjout")
                     , rst.getInt("id_offre")                    
                     , rst.getInt("idcondidat")
                     , rst.getString("NiveauFrancais")
                     , rst.getString("NiveauAnglais")
                     , rst.getString("Cv")
                     , rst.getString("Experience")
                     , rst.getString("TypeCondidature")
                    , rst.getString("diplome")
                     , rst.getString("Domaine")
                     , rst.getString("titre")
                     , rst.getString("dateExpiration")
            
            );
            assu.add(u);
        }
        return assu;
    }
 
  public List<Candidature> AfficherAllCandidatureTache() throws SQLException {

        List<Candidature> assu = new ArrayList<>();
         
       
        String req = "select * from candidature where TypeCondidature ='Freelancer' and idcondidat="+SessionManager.getId();
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Candidature u = new Candidature(rst.getInt("id")
                    , rst.getString("statut")
                    , rst.getString("lettreMotivation")
                    , rst.getString("noteTest")
                    , rst.getString("dateAjout")
                     , rst.getInt("id_offre")
                     , rst.getInt("idcondidat")
                     , rst.getString("NiveauFrancais")
                     , rst.getString("NiveauAnglais")
                     , rst.getString("Cv")
                     , rst.getString("Experience")
                     , rst.getString("TypeCondidature")
                    , rst.getString("diplome")
             , rst.getString("Domaine")
                     , rst.getString("titre"),
                     rst.getString("dateExpiration"));
            
            System.out.println("ffffff   "+u);
            assu.add(u);
        }
        return assu;
    }
 
 
}
