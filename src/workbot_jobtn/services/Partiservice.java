/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.services;

import workbot_jobtn.entites.Evennement;
import workbot_jobtn.entites.Participation;
import workbot_jobtn.entites.User;
import workbot_jobtn.services.Parti_crud;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import workbot_jobtn.utils.MyDB;

/**
 *
 * @author hp
 */
public class Partiservice implements Parti_crud <Participation> {
    Connection connection;
private Statement ste;
public Partiservice() {
        connection = MyDB.getInstance().getConnection();
    }

    @Override
    public void ajouterp(Participation p) throws SQLException {
         ste=connection.createStatement();
String req="INSERT INTO `participation`(`id_event`,`id_userP`) VALUES "
        + "('"+p.getId_event()+"','"+p.getId_userP()+"')"; 
        System.out.println(req);    
        ste.executeUpdate(req);
    }

    @Override
    public void updatep(Participation p) throws SQLException {
       String req= "UPDATE`participation` SET `id_event`='"+p.getId_event()+"',`id_userP`='"+p.getId_userP()+"' WHERE `id`="+p.getId();
       ste = connection.createStatement();
    System.out.println(req);
    ste.executeUpdate(req);
    }

    @Override
    public void deletep(Participation p) throws SQLException {
     String req="DELETE FROM `participation` WHERE id_userP='"+p.getId_userP()+"' and id_event='"+p.getId_event()+"'";
        ste = connection.createStatement();
    System.out.println(req);
    ste.executeUpdate(req);
    }

   
   
    public ObservableList<User> readALLpr(int ide) throws SQLException {
       ObservableList<User> arr1=FXCollections.observableArrayList();
       
         ste = connection.createStatement();
        String req="SELECT * FROM utilisateur u JOIN participation p ON u.id=p.id_userP WHERE p.id_event='"+ide+"'";
        ResultSet r=ste.executeQuery(req);
        while (r.next()) {
            User  u = new User(r.getString("nom"), r.getString("prenom")," "," ",r.getString("email")," "," "," "," "," "," ");
           
            arr1.add(u);
            
        }
        return arr1;
    }
}
