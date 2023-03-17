/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.services;

import workbot_jobtn.entites.Certif_Badge;
import workbot_jobtn.services.N_interfaces_services_Certif_Badge;
import workbot_jobtn.utils.MyDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author ADMIN
 */
public class N_Services_Certif_Badge implements N_interfaces_services_Certif_Badge<Certif_Badge>{
    
    Connection connexion;
    public N_Services_Certif_Badge() {
        connexion = MyDB.getInstance().getConnection();
    }

    @Override
    public void ajouterCertifBadgeUser(Certif_Badge b) throws SQLException {
        String req = "INSERT INTO `certif_badge` (`id_user`,`id_certif`,`id_badge`) VALUES ( "+b.getId_user() +","+b.getId_certif()+","+b.getId_badge()+") ";
        Statement stm = connexion.createStatement();
        System.out.println(req);
        stm.executeUpdate(req);    }
    
    public void ajouterCertifBadge(Certif_Badge b) throws SQLException {
        String req = "INSERT INTO `certif_badge` (`id_certif`,`id_badge`) VALUES ("+b.getId_certif()+","+b.getId_badge()+") ";
        Statement stm = connexion.createStatement();
        System.out.println(req);
        stm.executeUpdate(req);    }

    @Override
    public void supprimerCertifBadge(Certif_Badge b) throws SQLException {
        String req = "DELETE FROM `certif_badge` WHERE `id_badge`=`"+b.getId_badge()+"` and '"+b.getId_certif()+"'";
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);}
    
           
}
