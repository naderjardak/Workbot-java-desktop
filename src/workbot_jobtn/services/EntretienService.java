/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import workbot_jobtn.entites.DTOCandidature_Offre;
import workbot_jobtn.entites.DTOEntretien;
import workbot_jobtn.entites.Entretien;
import workbot_jobtn.entites.Test;
import workbot_jobtn.utils.MyDB;

/**
 *
 * @author Exon
 */
public class EntretienService implements ICrud_Interface<Entretien> {

    private Connection connection;
    private Statement Statement;

    public EntretienService() {
        connection = MyDB.getInstance().getConnection();
    }

    @Override
    public void ajouter(Entretien e) throws SQLException {
        PreparedStatement prep = connection.prepareStatement("INSERT INTO `entretien`( `date`, `lienMeet`, `id_candidature`, `heure`)"
                +" VALUES (?,?,?,?)");
        prep.setString(1, e.getDate());
        prep.setString(2, e.getLienMeet());
        prep.setInt(3, e.getId_Candidature());
        prep.setInt(4, e.getHeure());
        System.out.println("2-" +e.getId_Candidature());
        prep.executeUpdate();
    }

    @Override
    public boolean update(Entretien e) {
        try {
            PreparedStatement prep = connection.prepareStatement("UPDATE `entretien` SET `date`=?,`lienMeet`=?,`id_candidature`=? WHERE id=?");
            prep.setInt(4, e.getId());
            prep.setString(1, e.getDate());
            prep.setString(2, e.getLienMeet());
            prep.setInt(3, e.getId_Candidature());

            prep.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EntretienService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Entretien t) throws SQLException {
        try {
            PreparedStatement prep = connection.prepareStatement("DELETE FROM `entretien` WHERE id=?");
            prep.setInt(1, t.getId());
            prep.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public List<Entretien> readAll() {
        List<Entretien> listEntretiens = new ArrayList<>();
        try {
            Statement = connection.createStatement();
            ResultSet r = Statement.executeQuery("SELECT * from `entretien`");
            while (r.next()) {
                int id = r.getInt(1);
                String date = r.getString(2);
                String lien = r.getString(3);
                int id_candidature = r.getInt(5);
                Integer heure = r.getInt(4);

                Entretien entretien = new Entretien(id, date, lien, id_candidature, heure);
                listEntretiens.add(entretien);

            }
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listEntretiens;
    }

    public ObservableList<DTOEntretien> displayEntretiens() throws SQLException {

        ObservableList<DTOEntretien> list1 = FXCollections.observableArrayList();
        Statement = connection.createStatement();

        ResultSet r = Statement.executeQuery("SELECT e.lienMeet,e.date,e.heure,u.nom from `entretien` e join `candidature` c on e.id_candidature=c.id"
                + " join `utilisateur` u on u.id=c.idcondidat");
        while (r.next()) {
            DTOEntretien dTOEntretien = new DTOEntretien();

            dTOEntretien.setDate(r.getString("e.date"));
            dTOEntretien.setHeure(r.getString("e.heure"));
            dTOEntretien.setNomCand(r.getString("u.nom"));
            dTOEntretien.setLien(r.getString("e.lienMeet"));

            System.out.println(dTOEntretien);
            list1.add(dTOEntretien);

        }
        System.out.println("1/" + list1);

        return list1;
    }

}
