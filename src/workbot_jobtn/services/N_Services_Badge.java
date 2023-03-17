/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.services;

import workbot_jobtn.entites.Badge;
import workbot_jobtn.services.N_interfaces_services_Badge;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import workbot_jobtn.utils.MyDB;

/**
 *
 * @author ADMIN
 */
public class N_Services_Badge implements N_interfaces_services_Badge<Badge> {
    
      Connection connexion;
    
    public N_Services_Badge() {
        connexion = MyDB.getInstance().getConnection();
    }


    @Override
    public void ajouterBadge(Badge b) throws SQLException {
        String req = "INSERT INTO `badge` (`nom`) VALUES ( '"+b.getNom() +"') ";
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);
 
    }

    @Override
    public void supprimerBadge(Badge b) throws SQLException {
        String req = "DELETE FROM `badge` WHERE `id`="+b.getId();
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);
        System.out.println(req);
    }    
    

    
    @Override
    public List<Badge> readAll_Badge(int idu) throws SQLException {
        List<Badge> arr=new ArrayList<>();
        Statement stm = connexion.createStatement();
        String req="select id,nom from `badge` b join `certif_badge` c on c.id_badge=b.id where c.id_user='"+idu+"'";
        ResultSet r=stm.executeQuery(req);
        System.out.println(req);
        while (r.next()) {
            Badge b = new Badge(r.getInt("id"),r.getString("nom"));
            arr.add(b);
        }
        System.out.println(arr); 
        return arr;
    }
    
}
