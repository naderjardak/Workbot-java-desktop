/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package workbot_jobtn.services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author hp
 * @param <P>
 */
public interface Parti_crud<P> {
    public void ajouterp(P p) throws SQLException;
    public void updatep(P p) throws SQLException;
   public void deletep(P p) throws SQLException;
    
}
