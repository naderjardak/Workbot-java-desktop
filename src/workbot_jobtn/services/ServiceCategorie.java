/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.services;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import workbot_jobtn.entites.*;
import workbot_jobtn.utils.MyDB;

/**
 *
 * @author youcef
 */
public class ServiceCategorie implements InterfaceServiceCategorie<Categorie>{
    private Statement statement ;
    private PreparedStatement pst;
    private Connection connection;
    public ServiceCategorie() {
        connection=(Connection) MyDB.getInstance().getConnection();
    }

    @Override
    public void ajouter(Categorie t) throws SQLException {
        statement=connection.createStatement();
    String req="INSERT INTO categorie(nomCategorie) VALUES ('"+ t.getNomCategorie()+"');";
    
    statement.executeUpdate(req);
        
    }

    @Override
    public boolean modifier(Categorie t) throws SQLException {
     String req="update categorie set nomCategorie = '"+t.getNomCategorie()+"' where id ="+t.getId()+";";
        try {
            statement=connection.createStatement();
            statement.executeUpdate(req);

        } catch (SQLException ex) {
        }
       return true;  
    }

    @Override
    public boolean supprimer(Categorie t) throws SQLException {
        String req="delete from categorie where id="+t.getId()+";";
        try {
            statement=connection.createStatement();
            statement.executeUpdate(req);

        } catch (SQLException ex) {
        }
        return true; 
    }

    @Override
    public ObservableList<Categorie> afficherTout() throws SQLException {
        
        ObservableList<Categorie> l=FXCollections.observableArrayList();
     statement = connection.createStatement();
     ResultSet r= statement.executeQuery("select * from Categorie");
     while (r.next()){
         int id=r.getInt("id");
         String nomCategorie=r.getString("nomCategorie");
         Categorie categorie=new Categorie(id,nomCategorie);
         l.add(categorie);
     }
     return l;
    }

    @Override
    public Categorie afficher(int i) throws SQLException {
        Categorie l=new Categorie();
     statement = connection.createStatement();
     ResultSet r= statement.executeQuery("select * from Categorie where id="+i+";");
     while (r.next()){
         int id=r.getInt("id");
         String nomCategorie=r.getString("nomCategorie");
         l=new Categorie(id,nomCategorie);
     }
     return  l;
    }

    
    
}
