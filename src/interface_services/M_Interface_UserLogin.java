/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interface_services;

import java.sql.SQLException;
import workbot_jobtn.entites.User;

/**
 *
 * @author fnmoh
 */
public interface M_Interface_UserLogin {
    void ajouterAdmin(User u)throws SQLException;
    void modifierAdmin(User u)throws SQLException;
    void LoginAdmin(User u)throws SQLException;
}
