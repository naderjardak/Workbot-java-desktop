/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package workbot_jobtn.services;
import java.sql.SQLException;
import javafx.collections.ObservableList;
/**
 *
 * @author youcef
 * @param <T>
 */
public interface InterfaceServiceCategorie<T> {
    
    void ajouter(T t) throws SQLException;
    boolean modifier(T t) throws SQLException;
    boolean supprimer(T t) throws SQLException;
    ObservableList<T> afficherTout() throws SQLException;
    T afficher(int i) throws SQLException;
}
