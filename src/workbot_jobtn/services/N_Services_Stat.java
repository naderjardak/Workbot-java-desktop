/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import workbot_jobtn.utils.MyDB;

/**
 *
 * @author ADMIN
 */

       // Statement stm = connexion.createStatement();
       // String req="select count(*) nb from user where role=Candidat";
       // ResultSet r=stm.executeQuery(req);
       // r.getInt("nb");
public class N_Services_Stat {
    
     Connection connexion;
    public N_Services_Stat() {
        connexion = MyDB.getInstance().getConnection();
    }
    
    public int nb_users() throws SQLException
    {
        Statement stm = connexion.createStatement();
        String req="select count(*) nb from utilisateur where role='candidat'";
        ResultSet r=stm.executeQuery(req);
        int b=0;
        while (r.next()) {
        b=r.getInt("nb");
        }
         return b;
    }
    
}
