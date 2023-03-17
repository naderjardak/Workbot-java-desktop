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
 * @param <E>
 */
  public interface Event_crud <E> {
    public void ajouter(E e) throws SQLException;
    public void update(E e) throws SQLException;
   public void delete(E e) throws SQLException;
   public List<E> readALL(int ids) throws SQLException;

}
