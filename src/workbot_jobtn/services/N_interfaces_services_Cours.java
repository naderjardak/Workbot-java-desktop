/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.services;

import workbot_jobtn.entites.Cours;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author ADMIN
 * @param <C>
 */
public interface N_interfaces_services_Cours<C> {
   void ajouterCours(C c)throws SQLException;
   void modifierCours(C c)throws SQLException;
   void supprimerCours(C c)throws SQLException;
   List<C> readAll_Cours() throws SQLException;
   ObservableList<C> read_Cours() throws SQLException;
   ObservableList<C> rechercherCours(Cours c) throws SQLException;


}
