/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.services;

import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author Exon
 * @param <T>
 */
public interface ICrud_Interface<T> {

    public void ajouter(T t) throws SQLException;

    public boolean update(T t) throws SQLException;

    public boolean delete(T t) throws SQLException;

    public List<T> readAll() throws SQLException;

}
