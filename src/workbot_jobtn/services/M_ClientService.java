/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import workbot_jobtn.entites.Candidat;
import workbot_jobtn.entites.User;
import workbot_jobtn.utils.MyDB;

/**
 *
 * @author fnmoh
 */
public class M_ClientService implements interface_services.M_Interface_Client{
  private java.sql.Connection on;
    private Statement ste;
    String role ="Admin";
    public M_ClientService() {
        on = MyDB.getInstance().getConnection();
    }
    @Override
    public void supprimerAdmin(Candidat c) throws SQLException {
        String query = "DELETE FROM utilisateur WHERE email ='" + c.getEmail() + "'";
        executeQuery(query);
    }

  
   
    @Override
    public List<User> readAll_Client() throws SQLException {
       ObservableList<User> userList= FXCollections.observableArrayList();
 
    String query = "SELECT * FROM utilisateur where role = 'sociéte' || role = 'candidat'";
    Statement st;
    ResultSet rs;
    try{
        st=on.createStatement();
        rs=st.executeQuery(query);
        User user;
        while(rs.next()){
            user= new Candidat(rs.getString("nom"),rs.getString("prenom"),rs.getString("tel"),rs.getString("email"),rs.getString("adresse"),rs.getString("domaine"),rs.getString("role"));
            userList.add(user);
            
        }
    }     catch (SQLException ex) {
             ex.printStackTrace();
          }
   
    return userList;
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
