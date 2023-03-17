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
public class ContratService {

    Connection connexion;

    public ContratService() {
        connexion = MyDB.getInstance().getConnection();
    }

    
    
      public void modifierContrat(Contrat u) throws SQLException, NoSuchAlgorithmException {
        String req = "UPDATE contrat SET "
                + "typeContrat ='"   +   u.getTypeContrat()+"'"
                + ", dateDebut='"+ (java.sql.Date) (Date) u.getDateDebut()+"'"
                + ", salaire='"+u.getSalaire()+"'"
                + ", dateFin='" + (java.sql.Date) (Date)u.getDateFin()+"'"
                + ", lien='"+u.getLien()+"'"
                + ", id_candidature='"+u.getId_candidature()+"'"
         
                + ", dateCreation='"+ (java.sql.Date) (Date)u.getDateCreation()+"' where id  = "+u.getId()+"";
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);
    }   
    
    public void AjouterContrat(Contrat u) throws SQLException {
        String req = "INSERT INTO `contrat` (`typeContrat`,`dateDebut`,`salaire`,`dateFin`,`lien`,`id_candidature`,`dateCreation`) "
                + "VALUES (?,?,?,?,?,?,?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setString(1, u.getTypeContrat());
        ps.setDate(2, (java.sql.Date) (Date) u.getDateDebut());
        ps.setString(3, u.getSalaire());
        ps.setDate(4, (java.sql.Date) (Date) u.getDateFin());
        ps.setString(5, u.getLien());
        ps.setInt(6, u.getId_candidature());

        ps.setDate(7, (java.sql.Date) (Date) u.getDateCreation());
        ps.executeUpdate();
    }

    public List<Contrat> AfficherAllContrat() throws SQLException {
        List<Contrat> assu = new ArrayList<>();
        String req = "select * from contrat c join candidature ca on c.id_candidature=ca.id where ca.idcondidat="+SessionManager.getId();
                
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
            Contrat u = new Contrat(rst.getInt("id"),
                     rst.getString("typeContrat"),
                     rst.getDate("dateDebut"),
                     rst.getString("salaire"),
                     rst.getDate("dateFin"),
                     rst.getString("lien"),
                    rst.getInt("id_candidature"),
                    rst.getDate("dateCreation"));
            assu.add(u);
        }
        return assu;
    }
   public List<Contrat> AfficherAllContratBySalaire() throws SQLException {
        List<Contrat> assu = new ArrayList<>();
        String req = "select * from contrat c join candidature ca on c.id_candidature=ca.id where ca.idcondidat="+SessionManager.getId()+ " order by salaire";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
            Contrat u = new Contrat(rst.getInt("id"),
                     rst.getString("typeContrat"),
                     rst.getDate("dateDebut"),
                     rst.getString("salaire"),
                     rst.getDate("dateFin"),
                     rst.getString("lien"),
                    rst.getInt("id_candidature"),
                    rst.getDate("dateCreation"));
            assu.add(u);
        }
        return assu;
    }
    public void SupprimerContrat(Contrat u) throws SQLException {

        String req = "DELETE FROM contrat WHERE id =?";
        try {
            PreparedStatement ps = connexion.prepareStatement(req);
            ps.setInt(1, u.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }

}
