/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package workbot_jobtn.services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface N_interfaces_services_Badge<Ba> {
       void ajouterBadge(Ba b)throws SQLException;
       void supprimerBadge(Ba b)throws SQLException;
       List<Ba> readAll_Badge(int idu) throws SQLException;
}
