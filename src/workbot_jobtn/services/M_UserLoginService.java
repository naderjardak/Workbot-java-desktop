/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.services;

import java.sql.SQLException;
import java.sql.Statement;
import workbot_jobtn.entites.User;
import workbot_jobtn.utils.MyDB;

/**
 *
 * @author fnmoh
 */
public class M_UserLoginService implements interface_services.M_Interface_UserLogin{
  private java.sql.Connection on;
    private Statement ste;
    String role ="Admin";
    public M_UserLoginService() {
        on = MyDB.getInstance().getConnection();
    }
    @Override
    public void ajouterAdmin(User u) throws SQLException {
         String query = "INSERT INTO utilisateur (role,nom,prenom,email,mdp,questionSecu,reponseSecu,domaine,adresse,tel) VALUES ('" + u.getRole()+ "','" + u.getNom() + "','" + u.getPrenom() + "','" + u.getEmail() + "','" + u.getMdp() + "','" + u.getQuestionSecu() + "','" + u.getReponseSecu() + "','" + u.getDomaine()+ "','" + u.getAdresse() + "','" + u.getTel() + "')";
        
        executeQuery(query);
    }

    @Override
    public void modifierAdmin(User u) throws SQLException {
        String query = "UPDATE  utilisateur SET  mdp = '" + u.getMdp() + "' WHERE email = '" + u.getEmail() + "' ";
        executeQuery(query);
    }

    @Override
    public void LoginAdmin(User u) throws SQLException {
        
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
