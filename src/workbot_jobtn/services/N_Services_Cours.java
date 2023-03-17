/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import workbot_jobtn.entites.Cours;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import workbot_jobtn.utils.MyDB;
import workbot_jobtn.services.N_interfaces_services_Cours;

/**
 *
 * @author ADMIN
 */
public class N_Services_Cours implements N_interfaces_services_Cours<Cours> {
    
    Connection connexion;
    
    public N_Services_Cours() {
        connexion = MyDB.getInstance().getConnection();
    }

    @Override
    public void ajouterCours(Cours c) throws SQLException {
        String req = "INSERT INTO `cours` (`titre`,`matiere`,`domaine`,`categorie`,`chemin`,`logo`) VALUES ( '"
                +c.getTitre()+"', '"+c.getMatiere()+"', '" +c.getDomaine()+"', '" + c.getCategorie()+"', '"+c.getChemin() +"','"+c.getLogo() +"') ";
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);
    }

    @Override
    public void modifierCours(Cours c) throws SQLException {
        String req = "UPDATE`cours` SET `titre`='"+c.getTitre()+
                                     "',`matiere`='"+c.getMatiere()+
                                     "',`domaine`='"+c.getDomaine()+
                                    "',`categorie`='"+c.getCategorie()+
                                      "',`chemin`='"+c.getChemin() +"' WHERE `id`="+c.getId();
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);
    }

    @Override
    public void supprimerCours(Cours c) throws SQLException {
        String req = "DELETE FROM `cours` WHERE `id`="+c.getId();
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);}

    @Override
    public ObservableList<Cours>  rechercherCours(Cours c) throws SQLException {
           
        ObservableList<Cours> arr=FXCollections.observableArrayList();
        Statement stm = connexion.createStatement();
        int i=0;
        String cond="";
if(c.getDomaine()!=null)
{cond="LOCATE('"+c.getDomaine()+"',`domaine`)>0";
i=1;}

if (!(c.getCategorie().equals((String)" ")))
if(i==1)
{cond+=" and `categorie`='"+c.getCategorie()+"'";
i+=1;

}
else
{cond="`categorie`= '"+c.getCategorie()+"'";
i+=1;
}

if(c.getTitre()!=null)
if(i>0)
{cond+=" and LOCATE('"+c.getTitre()+"',`titre`)>0";
i+=1;
}
else
{cond="LOCATE('"+c.getTitre()+"',`titre`)>0";
i+=1;
}

        String req="Select * from `cours` where "+cond;
        System.out.println(req);
        
        ResultSet r=stm.executeQuery(req);
        
        while (r.next()) {
            c = new Cours(r.getInt("id")
                    , r.getString("titre")
                    , r.getString("matiere")
                    , r.getString("domaine")
                    , r.getString("categorie")
                    , r.getString("chemin")
                    , r.getString("logo"));
            arr.add(c);
        }
        
        return arr;}

    
    
    
    @Override
    public List<Cours> readAll_Cours() throws SQLException {
        List<Cours> arr=new ArrayList<>();
        Statement stm = connexion.createStatement();
        String req="select * from cours";
        ResultSet r=stm.executeQuery(req);
        
        while (r.next()) {
            Cours c = new Cours(r.getInt("id")
                    , r.getString("titre")
                    , r.getString("matiere")
                    , r.getString("domaine")
                    , r.getString("categorie")
                    , r.getString("chemin"));
            arr.add(c);
        }
        
        return arr;
    }
    
   


    @Override
    public ObservableList<Cours> read_Cours() throws SQLException {
    ObservableList<Cours> arr=FXCollections.observableArrayList();
        Statement stm = connexion.createStatement();
        String req="select * from cours";
        ResultSet r=stm.executeQuery(req);
        
        while (r.next()) {
            Cours c = new Cours(r.getInt("id")
                    , r.getString("titre")
                    , r.getString("matiere")
                    , r.getString("domaine")
                    , r.getString("categorie")
                    , r.getString("chemin")
                    , r.getString("logo"));
            arr.add(c);
        }
        
        return arr;
 
   }
    
        public List<Cours> stat_Cours() throws SQLException {
    List<Cours> arr=new ArrayList();
        Statement stm = connexion.createStatement();
        String req="select count(*) nb ,domaine from cours group by domaine";
        ResultSet r=stm.executeQuery(req);
        
        while (r.next()) {
            Cours c = new Cours(r.getInt("nb")
                    , r.getString("domaine"));
            arr.add(c);
        }
        
        return arr;
   }
    
}
