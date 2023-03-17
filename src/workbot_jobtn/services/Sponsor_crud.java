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
 * @param <S>
 */
public interface Sponsor_crud<S> {
    public void ajouterspon(S s) throws SQLException;
    public void updatespon(S s) throws SQLException;
   public void deletespon(S s) throws SQLException;
   public List<S> readALLspon(int idsp) throws SQLException;
    
}
