/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.services;

import java.io.File;
import static java.lang.Math.round;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import workbot_jobtn.entites.*;
import workbot_jobtn.utils.MyDB;

/**
 *
 * @author youcef
 */
public class ServiceReclamation implements InterfaceServiceReclamation<Reclamation>{
    private Statement statement ;
    private PreparedStatement pst;
    private Connection connection;
    public ServiceReclamation() {
        connection=(Connection) MyDB.getInstance().getConnection();
    }

    @Override
    public void ajouter(Reclamation t) throws SQLException {
        statement=connection.createStatement();
        String req;
        req = null;
        if(t.getImage()!=null){
        req="INSERT INTO reclamation(objet,description,id_categorie,image,id_utilisateur) VALUES ('"+ t.getObjet()+"','"+t.getDescription()+"',"+t.getCategorie().getId()+",'"+t.getImage()+"',"+t.getUser().getId()+");";
        }
        else {req="INSERT INTO reclamation(objet,description,id_categorie,id_utilisateur) VALUES ('"+ t.getObjet()+"','"+t.getDescription()+"',"+t.getCategorie().getId()+","+t.getUser().getId()+");";}
        statement.executeUpdate(req);
        
    }

    

    @Override
    public boolean modifier(Reclamation t) throws SQLException {
        String req;
        req=null;
        if(t.getImage()!=null){
        req="update reclamation set objet = '"+t.getObjet()+"',description='"+t.getDescription()+"',image='"+t.getImage()+"' where id ="+t.getId()+";";
        }
        else{
        req="update reclamation set objet = '"+t.getObjet()+"',description='"+t.getDescription()+"',image=null'"+"' where id ="+t.getId()+";";
        }
        try {
            statement=connection.createStatement();
            statement.executeUpdate(req);

        } catch (SQLException ex) {                                
        }
       return true;
        
    }

    @Override
    public boolean supprimer(Reclamation t) throws SQLException {
        String req="delete from reclamation where id ="+t.getId()+";";
        try {
            statement=connection.createStatement();
            statement.executeUpdate(req);

        } catch (SQLException ex) {                                
        }
       return true;
    }

    @Override
    public ObservableList<Reclamation> afficherTout() throws SQLException {
        
        ObservableList<Reclamation> l=FXCollections.observableArrayList();
     statement = connection.createStatement();
     ResultSet r= statement.executeQuery("select * from reclamation");
     while (r.next()){
         int id=r.getInt("id");
         String objet=r.getString("objet");
         String date=(r.getDate("dateAjout")).toString();
         String description=r.getString("description");
         String image=r.getString("image");
         String etat=r.getString("etat");
         int id_categorie=r.getInt("id_categorie");
         ServiceCategorie serv1=new ServiceCategorie();
         Categorie categorie= serv1.afficher(id_categorie);
         String nomCat=categorie.getNomCategorie();
         Reclamation reclamation=new Reclamation(id, objet, date, description,image,categorie,etat,nomCat);
         
         l.add(reclamation);
     }
     return l;
    }

    @Override
    public Reclamation afficher(int i) throws SQLException {
        Reclamation l=new Reclamation();
        statement = connection.createStatement();
        ResultSet r= statement.executeQuery("select * from reclamation where id="+i+";");
        while (r.next()){
        int id=r.getInt("id");
         String objet=r.getString("objet");
         String date=(r.getDate("dateAjout")).toString();
         String description=r.getString("description");
         String image=r.getString("image");
         String etat=r.getString("etat");
         int id_categorie=r.getInt("id_categorie");
         ServiceCategorie serv1=new ServiceCategorie();
         Categorie categorie= serv1.afficher(id_categorie);
         String nomCat=categorie.getNomCategorie();
         l=new Reclamation(id, objet, date, description,image,categorie,etat,nomCat);
         }
     return l;
        
    }

    public User afficherUser(int i) throws SQLException {
        User l=new User();
        statement = connection.createStatement();
        ResultSet r= statement.executeQuery("select * from utilisateur where id="+i+";");
        while (r.next()){
        int id=r.getInt("id");
         l=new User(id);
         }
     return l;
        
    }
    public int countEnvoyer() throws SQLException{
        int total = 0;
        statement = connection.createStatement();
        ResultSet r= statement.executeQuery("select count(*)as total from reclamation where etat='envoyée';");
        while (r.next()){
            total=r.getInt("total");
        }
        return total;
    }
    public int countEnCour() throws SQLException{
        int total = 0;
        statement = connection.createStatement();
        ResultSet r= statement.executeQuery("select count(*)as total from reclamation where etat='en cours de traitement';");
        while (r.next()){
            total=r.getInt("total");
        }
        return total;
    }
    public int countTraitee() throws SQLException{
        int total = 0;
        statement = connection.createStatement();
        ResultSet r= statement.executeQuery("select count(*)as total from reclamation where etat='traitée';");
        while (r.next()){
            total=r.getInt("total");
        }
        return total;
    }
    public int countTechnique() throws SQLException{
        int total = 0;
        statement = connection.createStatement();
        ResultSet r= statement.executeQuery("select count(*)as total from reclamation where id_categorie=11;");
        while (r.next()){
            total=r.getInt("total");
        }
        return total;
    }
    public int countOffre() throws SQLException{
        int total = 0;
        statement = connection.createStatement();
        ResultSet r= statement.executeQuery("select count(*)as total from reclamation where id_categorie=17;");
        while (r.next()){
            total=r.getInt("total");
        }
        return total;
    }
    public boolean modifier_etat_enCour(Reclamation t) throws SQLException {
        String req;
        
        req="update reclamation set etat = 'en cours de traitement' where id ="+t.getId()+";";
        
        try {
            statement=connection.createStatement();
            statement.executeUpdate(req);

        } catch (SQLException ex) {                                
        }
       return true;
        
    }
    public boolean modifier_etat_traitee(Reclamation t) throws SQLException {
        String req;
        
        req="update reclamation set etat = 'traitée' where id ="+t.getId()+";";
        
        try {
            statement=connection.createStatement();
            statement.executeUpdate(req);

        } catch (SQLException ex) {                                
        }
       return true;
        
    }
}
