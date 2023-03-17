/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.services;

import workbot_jobtn.services.Event_crud;
import workbot_jobtn.entites.Evennement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import workbot_jobtn.utils.MyDB;
import workbot_jobtn.utils.SessionManager;

/**
 *
 * @author hp
 */
public class EventService implements Event_crud<Evennement>{
Connection connection;
private Statement ste;



    public EventService() {
        connection = MyDB.getInstance().getConnection();
    }

@Override
    public void ajouter(Evennement e) throws SQLException {
ste=connection.createStatement();
String req="INSERT INTO `evennement`(`dateDebut`,`dateFin`,`libelle`,`heureDebut`,`heureFin`,`nbPlaces`,`prix`,`flyer`,`video`,`id_user`) VALUES "
        + "('"+e.getDateDebut()+"','"+e.getDateFin()+"','"+e.getLibelle()+"','"+e.getHeureDebut()+"','"+e.getHeureFin()+"','"+e.getNbPlaces()+"','"+e.getPrix()+"','"+e.getFlyer()+"','"+e.getVideo()+"','"+e.getId_user()+"')";
System.out.println(req);    
ste.executeUpdate(req);
    }

    @Override
    public void update(Evennement e) throws SQLException {
     String req = "UPDATE`evennement` SET `dateDebut`='"+e.getDateDebut()+"',`dateFin`='"+e.getDateFin()+"',`libelle`='"+e.getLibelle()+"',`heureDebut`='"+e.getHeureDebut()+"',`heureFin`='"+e.getHeureFin()+"',`nbPlaces`='"+e.getNbPlaces()+"',`prix`='"+e.getPrix()+"',`flyer`='"+e.getFlyer()+"',`video`='"+e.getVideo()+"',`id_user`='"+e.getId_user()+"' WHERE `id_user`='"+e.getId_user()+"' and id='"+e.getId()+"'";   
    Statement ste = connection.createStatement();
    System.out.println(req);
    ste.executeUpdate(req);
    
    }

    
    public void update_place(int id) throws SQLException {
     String req = "UPDATE`evennement` SET `nbPlaces`=(nbPlaces-1) where id='"+id+"'";   
    Statement ste = connection.createStatement();
    System.out.println(req);
    ste.executeUpdate(req);
    
    }
    
    
    @Override
    public void delete(Evennement e) throws SQLException {
        
        String req="DELETE FROM evennement WHERE id='"+e.getId()+"'";
        ste = connection.createStatement();
    System.out.println(req);
    ste.executeUpdate(req);
        
        
    }


    @Override
    public ObservableList<Evennement> readALL(int ids) throws SQLException {
         ObservableList<Evennement> arr=FXCollections.observableArrayList();
         ste = connection.createStatement();
         ids=SessionManager.getId();
        String req="SELECT * FROM `evennement` where id_user='"+ids+"'";
        ResultSet r=ste.executeQuery(req);
        System.out.println(req);
        
        while (r.next()) {
            Evennement e = new Evennement(r.getInt("id"),r.getString("dateDebut"),r.getString("dateFin"),r.getString("libelle"),r.getString("heureDebut"),
            r.getString("heureFin"),r.getInt("nbPlaces"),r.getString("prix"),r.getString("flyer"),r.getString("video"),r.getInt("id_user"));
           
            arr.add(e);
      
            //System.out.println(arr);
        }
        return arr;
    }
    
    public ObservableList<Evennement> readALL_p() throws SQLException {
         ObservableList<Evennement> arr=FXCollections.observableArrayList();
         ste = connection.createStatement();
        String req="SELECT * FROM evennement e WHERE id NOT IN(select id_event from participation p WHERE nbPlaces>0 and p.id_event=e.id and p.id_userP='"+SessionManager.getId()+"')";
        ResultSet r=ste.executeQuery(req);
        System.out.println(req);
        
        while (r.next()) {
            Evennement e = new Evennement(r.getInt("id"),r.getString("dateDebut"),r.getString("dateFin"),r.getString("libelle"),r.getString("heureDebut"),
            r.getString("heureFin"),r.getInt("nbPlaces"),r.getString("prix"),r.getString("flyer"),r.getString("video"),r.getInt("id_user"));
           
            arr.add(e);
      
            //System.out.println(arr);
        }
        return arr;
    }
    
    
    
     public ObservableList<Evennement> readALL_p_Ann() throws SQLException {
         ObservableList<Evennement> arr=FXCollections.observableArrayList();
         ste = connection.createStatement();
        String req="SELECT * FROM evennement e WHERE id IN(select id_event from participation p WHERE nbPlaces>0 and p.id_event=e.id and p.id_userP='"+SessionManager.getId()+"')";
        ResultSet r=ste.executeQuery(req);
        System.out.println(req);
        
        while (r.next()) {
            Evennement e = new Evennement(r.getInt("id"),r.getString("dateDebut"),r.getString("dateFin"),r.getString("libelle"),r.getString("heureDebut"),
            r.getString("heureFin"),r.getInt("nbPlaces"),r.getString("prix"),r.getString("flyer"),r.getString("video"),r.getInt("id_user"));
           
            arr.add(e);
      
            //System.out.println(arr);
        }
        return arr;
    }
    
    public int affid() throws SQLException{
         int id1=0;
         String req="SELECT MAX(id) FROM `evennement'";
         ResultSet r=ste.executeQuery(req);
         while (r.next()) {
         id1=r.getInt("id");
         }
        return id1;
    }
}

 