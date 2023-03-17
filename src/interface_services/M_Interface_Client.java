/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interface_services;

import java.sql.SQLException;
import java.util.List;
import workbot_jobtn.entites.Candidat;
import workbot_jobtn.entites.User;

/**
 *
 * @author fnmoh
 */
public interface M_Interface_Client {
    
    
       void supprimerAdmin(Candidat c)throws SQLException;
       List<User> readAll_Client() throws SQLException;
       
}
