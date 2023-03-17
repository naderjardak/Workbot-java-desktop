/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.services;

import workbot_jobtn.entites.Evennement;
import workbot_jobtn.entites.Participation;
import workbot_jobtn.entites.Sponsor;
import workbot_jobtn.services.Sponsor_crud;
import static workbot_jobtn.gui.AfficheeventController.ide;
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
public class Sponservice_1 implements Sponsor_crud<Sponsor> {
  Connection connection;
private Statement ste;  
public Sponservice_1() {
        connection = MyDB.getInstance().getConnection();
    }
    @Override
    public void ajouterspon(Sponsor s) throws SQLException {
   ste=connection.createStatement();
String req="INSERT INTO `sponsor`(`nom`,`logo`,`id_evenement`) VALUES "
        + "('"+s.getNom()+"','"+s.getLogo()+"','"+s.getId_evenement()+"')"; 
System.out.println(req);    
ste.executeUpdate(req);
        
    }

    @Override
    public void updatespon(Sponsor s) throws SQLException {
        String req= "UPDATE`sponsor` SET `nom`='"+s.getNom()+"',`logo`='"+s.getLogo()+"',`id_evenement`='"+s.getId_evenement()+"' WHERE `id`="+s.getId();
        ste = connection.createStatement();
    System.out.println(req);
    ste.executeUpdate(req);
    }

    @Override
    public void deletespon(Sponsor s) throws SQLException {
        String req="DELETE FROM sponsor WHERE id="+s.getId();
        ste = connection.createStatement();
    System.out.println(req);
    ste.executeUpdate(req);
    }

    @Override
    public ObservableList<Sponsor> readALLspon(int idsp) throws SQLException {
        ObservableList<Sponsor> arr=FXCollections.observableArrayList();
        
       //ObservableList<Sponsor> arr=new ArrayList<>();
         ste = connection.createStatement();
        String req="select * from sponsor where id_evenement='"+idsp+"'";
        ResultSet r=ste.executeQuery(req);
        while (r.next()) {
            Sponsor s = new Sponsor(r.getInt("id"), r.getString("nom"),r.getString("logo"),r.getInt("id_evenement"));
           
            arr.add(s);
            
        }
        return arr;
    }
    }
