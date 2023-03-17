/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 //*/
package workbot_jobtn.services;

import workbot_jobtn.entites.Badge;
import workbot_jobtn.entites.Certif_Badge;
import java.sql.Connection;
import workbot_jobtn.entites.Certification;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import workbot_jobtn.services.N_interfaces_services_Certification;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import workbot_jobtn.entites.StatCertif;
import workbot_jobtn.entites.User;

import workbot_jobtn.utils.MyDB;

/**
 *
 * @author ADMIN
 */

public class N_Services_Certification implements N_interfaces_services_Certification<Certification> {

     Connection connexion;
     public N_Services_Certification() {
        connexion = MyDB.getInstance().getConnection();
    }
     
    @Override
    public void affecter(Certification c,int id) throws SQLException {
    
        
        N_Services_Badge sb=new N_Services_Badge();
        Badge b=new Badge(c.getTitreCours());
        sb.ajouterBadge(b);
        
        Statement stm2 = connexion.createStatement();
        String req2="select id from badge";
        ResultSet k1=stm2.executeQuery(req2);
        int b1=0;
        while (k1.next()) {
        b1 = k1.getInt("id");}
          

        N_Services_Certif_Badge scb = new N_Services_Certif_Badge();
        Certif_Badge cb=new Certif_Badge(id,c.getId(),b1);
        scb.ajouterCertifBadgeUser(cb);
        
        
    }
    @Override
    public void modifierCertif(Certification c) throws SQLException {
 String req = "UPDATE`certification` SET `titreCours`='"+c.getTitreCours()+
                                        "',`titreTest`='"+c.getTitreTest()+
                                        "',`dateAjout`='"+c.getDateAjout()+
                                             "',`lien`='"+c.getLien()+
                                         "' WHERE `id`="+c.getId();
        Statement stm = connexion.createStatement();
                System.out.println(req);

        stm.executeUpdate(req);    }

    @Override
    public void supprimerCertif(Certification c) throws SQLException {
        
        N_Services_Certif_Badge scb=new N_Services_Certif_Badge();
        
        String req = "DELETE FROM `certification` WHERE `id`="+c.getId();
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);    
    }

    @Override
    public List<Certification> readAll_Certif() throws SQLException {
List<Certification> arr=new ArrayList<>();
        Statement stm = connexion.createStatement();
        String req="select * from certification ";
        ResultSet r=stm.executeQuery(req);
        
        while (r.next()) {
            Certification c = new Certification(r.getInt("id")
                    , r.getString("titreCours")
                    , r.getString("titreTest")
                    , r.getString("dateAjout")
                    , r.getString("lien"));
            arr.add(c);
        }
        
        return arr;    }
    
    
        @Override
    public List<Certification> readAll_Certif_U(int ids) throws SQLException {
List<Certification> arr=new ArrayList<>();
        Statement stm = connexion.createStatement();
        String req="select * from certification where id NOT IN (select id_certif from certif_badge where id_user ='"+ids+"')";
        ResultSet r=stm.executeQuery(req);
        
        while (r.next()) {
            Certification c = new Certification(r.getInt("id")
                    , r.getString("titreCours")
                    , r.getString("titreTest")
                    , r.getString("dateAjout")
                    , r.getString("lien"));
            arr.add(c);
        }
        
        return arr;    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ObservableList<Certification> read_Certif() throws SQLException {
    ObservableList<Certification> arr=FXCollections.observableArrayList();
        Statement stm = connexion.createStatement();
        String req="select * from certification c join certif_badge cb on c.id = cb.id_certif";
        ResultSet r=stm.executeQuery(req);
        
        while (r.next()) {
            Certification c = new Certification(r.getInt("id")
                    , r.getString("titreCours")
                    , r.getString("titreTest")
                    , r.getString("dateAjout")
                    , r.getString("lien"));
            arr.add(c);
        }
        
        return arr;    
    }    
    
     public void ajouterCertif(Certification c) throws SQLException {
    String req = "INSERT INTO `certification` (`titreCours`,`titreTest`,`dateAjout`,`lien`) VALUES ( '"
                  +c.getTitreCours()+"','"+c.getTitreTest()+"', '" +c.getDateAjout()+"', '" + c.getLien()+"')";
        Statement stm = connexion.createStatement();
        System.out.println(req);
        stm.executeUpdate(req);       
    }
     
     
        public List<StatCertif> calcule_Certif() throws SQLException {
        List<StatCertif> arr=new ArrayList<>();
        Statement stm = connexion.createStatement();
        String req="select titreCours ,count(cb.id_user) nb from certification c join certif_badge cb on c.id=cb.id_certif GROUP BY titreCours";
        ResultSet r=stm.executeQuery(req);
        
        
        while (r.next()) {
            StatCertif sc=new StatCertif(r.getString("titreCours")
                    ,r.getInt("nb"));
            arr.add(sc);
        }
        
        return arr;    }
        
 public void vider() throws SQLException {
        
        N_Services_Certif_Badge scb=new N_Services_Certif_Badge();
        
        String req = "DELETE FROM `certification` WHERE 1";
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);    
    }
 
   public int affU(String em) throws SQLException{
       List<User> arr=new ArrayList<>();
        Statement stm = connexion.createStatement();
        String req="select id,email from utilisateur where email='"+em+"'";
        ResultSet r=stm.executeQuery(req);
        int id=0;
        while (r.next()) {
            User c = new User(r.getInt("id")
                    ,r.getString("email"));
            id=r.getInt("id");
            arr.add(c);
        }
        
        return id;
       
   }
}
