/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Exon
 */
public class MyDB {
    
 final String url = "jdbc:mysql://localhost:3306/workbot_db";
    final String login ="root";
    final String pwd = "";

    Connection connection;
    static MyDB instance;

    private MyDB() {
        try {
            connection = DriverManager.getConnection(url,login,pwd);
            System.out.println("connection reussie");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static MyDB getInstance(){
        if(instance==null)
            instance=new MyDB();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
