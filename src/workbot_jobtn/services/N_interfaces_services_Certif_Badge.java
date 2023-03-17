/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package workbot_jobtn.services;

import workbot_jobtn.entites.Certif_Badge;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 * @param <cb>
 */
public interface N_interfaces_services_Certif_Badge<cb> {
       void ajouterCertifBadge(cb b)throws SQLException;
       void supprimerCertifBadge(cb b)throws SQLException;
       void ajouterCertifBadgeUser(Certif_Badge b) throws SQLException;
}
