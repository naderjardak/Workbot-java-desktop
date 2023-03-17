/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package workbot_jobtn.services;

import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author ADMIN
 * @param <Cer>
 */
public interface N_interfaces_services_Certification<Cer> {
   void affecter(Cer c,int idUser)throws SQLException;
   void modifierCertif(Cer c)throws SQLException;
   void supprimerCertif(Cer c)throws SQLException;
   List<Cer> readAll_Certif() throws SQLException;
   List<Cer> readAll_Certif_U(int ids) throws SQLException;
   ObservableList<Cer> read_Certif() throws SQLException;
   void ajouterCertif(Cer c) throws SQLException;

    
}
