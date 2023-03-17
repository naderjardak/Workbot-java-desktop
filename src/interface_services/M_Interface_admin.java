/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interface_services;
import java.sql.SQLException;
import java.util.List;
import workbot_jobtn.entites.User;
/**
 *
 * @author fnmoh
 */
public interface M_Interface_admin< u> {
    void ajouterAdmin(User u)throws SQLException;
    void modifierAdmin(User u)throws SQLException;
       void supprimerAdmin(User u)throws SQLException;
       List<User> readAll_Admin() throws SQLException;
       
}
