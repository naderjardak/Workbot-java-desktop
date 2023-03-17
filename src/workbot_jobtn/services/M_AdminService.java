/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.services;

import com.sun.jdi.connect.spi.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import workbot_jobtn.entites.User;
import workbot_jobtn.utils.MyDB;

/**
 *
 * @author fnmoh
 */
public class M_AdminService implements interface_services.M_Interface_admin{
   private java.sql.Connection on;
    private Statement ste;
    String role ="Admin";
    public M_AdminService() {
        on = MyDB.getInstance().getConnection();
    }
    @Override
    public void ajouterAdmin(User u) throws SQLException {
        String query = "INSERT INTO utilisateur (prenom,nom,email,mdp,role) VALUES ('" + u.getPrenom() + "','" + u.getNom() + "','" + u.getEmail()+ "','"
                + u.getMdp()+ "','" + role + "')"; 
       executeQuery(query);
      
        
    }

    @Override
    public void modifierAdmin(User u) throws SQLException {
       String query = "UPDATE  utilisateur SET id ="+ u.getId()+",prenom = '" +u.getPrenom()  + "', nom = '" + u.getNom() + "', email = '" +u.getEmail() + "', mdp = '" +  u.getMdp() + "' WHERE id = " +  u.getId() + " ";
        executeQuery(query);
    }

    @Override
    public void supprimerAdmin(User u) throws SQLException {
        String query = "DELETE FROM utilisateur WHERE id =" + u.getId() + "";
        executeQuery(query);
    }

    @Override
    public List readAll_Admin() throws SQLException {
       ObservableList<User> adminList= FXCollections.observableArrayList();
   
    String query = "SELECT * FROM utilisateur where role ='Admin' ";
    Statement st;
    ResultSet rs;
    try{
        st=on.createStatement();
        rs=st.executeQuery(query);
        User user;
        while(rs.next()){
            user= new User(rs.getInt("id"),rs.getString("prenom"),rs.getString("nom"),rs.getString("email"),rs.getString("mdp"));
            adminList.add(user);
            
        }
    }     catch (SQLException ex) {
             ex.printStackTrace();
          }
   
    return adminList;
    }

    
     private void executeQuery(String query) {
        Statement st;
        try{
            st = on.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
