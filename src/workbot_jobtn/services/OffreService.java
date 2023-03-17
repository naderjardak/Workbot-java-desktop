/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.services;

import static java.lang.String.valueOf;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import workbot_jobtn.entites.DTOCandidature_Offre;
import workbot_jobtn.entites.Offre;
import workbot_jobtn.entites.TypeOffre;
import workbot_jobtn.utils.MyDB;
import workbot_jobtn.utils.SessionManager;

/**
 *
 * @author Exon
 */
public class OffreService implements ICrud_Interface<Offre> {

    private Connection connection;
    private Statement Statement;

    public OffreService() {
        connection = MyDB.getInstance().getConnection();
    }

    @Override
    public void ajouter(Offre O) throws SQLException {
        System.out.println("hellooooooo");
        PreparedStatement prep = connection.prepareStatement("INSERT INTO `offre`( `titre`, `description`, `domaine`, `dateExpiration`, "
                + "  `id_Soc`, `modeTravail`, `typeOffre`, `salaire`, `typeContrat`, `dureeStage`, `typeStage`,`dateAjout`,`lieu`) "
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);");
        prep.setString(1, O.getTitre());
        prep.setString(2, O.getDescription());
        prep.setString(3, SessionManager.getDomaine());
        prep.setString(4, O.getDateExpiration());
        prep.setInt(5, O.getId_soc());
        prep.setString(6, O.getModeTravail());
        prep.setString(7, O.getTypeOffre().name());
        prep.setString(8, O.getSalaire());
        prep.setString(9, O.getTypeContrat());
        prep.setString(10, O.getDureeStage());
        prep.setString(11, O.getTypeStage());
        System.out.println(prep);
        Date d = new Date();
        int year = d.getYear() + 1900;
        int month = d.getMonth() + 1;
        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

        String dayOfMonthStr = String.valueOf(dayOfMonth);
        LocalDate d1 = LocalDate.of(year, month, dayOfMonth);
        System.out.println(d1);
        prep.setString(12, d1.format(DateTimeFormatter.ISO_DATE));
        prep.setString(13, O.getLieu());

        prep.executeUpdate();

    }

    @Override
    public boolean update(Offre O) {
        try {
            PreparedStatement prep = connection.prepareStatement("UPDATE `offre` SET `titre`=?,`description`=?,`domaine`=?,`dateExpiration`=?,`id_Soc`=?,`modeTravail`=?,`typeOffre`=?,`id_test`=? WHERE id=?");
            prep.setInt(9, O.getId());
            prep.setString(1, O.getTitre());
            prep.setString(2, O.getDescription());
            prep.setString(3, O.getDomaine());
            prep.setString(4, O.getDateExpiration());
            prep.setInt(5, O.getId_soc());
            prep.setString(6, O.getModeTravail());
            prep.setString(7, O.getTypeOffre().name());

            prep.setInt(8, O.getId_test());

            prep.executeUpdate();
            return true;
        } catch (SQLException ex) {

        }
        return false;
    }

    public boolean updateEmploi(Offre O) {
        try {

            PreparedStatement prep = connection.prepareStatement("UPDATE `offre` SET `titre`=?,`description`=?,`dateExpiration`=?,`modeTravail`=?, `typeContrat`=?,`lieu`=?,`salaire`=? WHERE id=?");

            prep.setInt(8, O.getId());
            prep.setString(1, O.getTitre());
            prep.setString(2, O.getDescription());
            prep.setString(3, O.getDateExpiration());
            prep.setString(4, O.getModeTravail());
            prep.setString(5, O.getTypeContrat());
            prep.setString(6, O.getLieu());
            prep.setString(7, O.getSalaire());

            prep.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean updateStage(Offre O) {
        try {

            PreparedStatement prep = connection.prepareStatement("UPDATE `offre` SET `titre`=?,`description`=?,`dateExpiration`=?,`modeTravail`=?, `typeStage`=?,`lieu`=?,`dureeStage`=? WHERE id=?");

            prep.setInt(8, O.getId());
            prep.setString(1, O.getTitre());
            prep.setString(2, O.getDescription());
            prep.setString(3, O.getDateExpiration());
            prep.setString(4, O.getModeTravail());
            prep.setString(5, O.getTypeStage());
            prep.setString(6, O.getLieu());
            prep.setString(7, O.getDureeStage());

            prep.executeUpdate();
            return true;
        } catch (SQLException ex) {

        }
        return false;
    }

    public boolean updateFreelancer(Offre O) {
        try {

            PreparedStatement prep = connection.prepareStatement("UPDATE `offre` SET `titre`=?,`description`=?,`dateExpiration`=?,`modeTravail`=?, `salaire`=?,`lieu`=?,`dureeStage`=? WHERE id=?");

            prep.setInt(8, O.getId());
            prep.setString(1, O.getTitre());
            prep.setString(2, O.getDescription());
            prep.setString(3, O.getDateExpiration());
            prep.setString(4, O.getModeTravail());
            prep.setString(5, O.getSalaire());
            prep.setString(6, O.getLieu());
            prep.setString(7, O.getDureeStage());

            prep.executeUpdate();
            return true;
        } catch (SQLException ex) {

        }
        return false;
    }

    public boolean updateNoteTest(DTOCandidature_Offre c) {
        try {

            PreparedStatement prep = connection.prepareStatement("UPDATE `candidature` SET `noteTest`=? WHERE id=?");

            prep.setInt(2, c.getId_cand());
            prep.setString(1, c.getNoteTest());

            prep.executeUpdate();
            return true;
        } catch (SQLException ex) {

        }
        return false;
    }

    @Override
    public boolean delete(Offre O) {
        try {
            PreparedStatement prep = connection.prepareStatement("DELETE FROM `offre` WHERE id=?");
            prep.setInt(1, O.getId());
            prep.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean deleteById(int id) {
        try {
            PreparedStatement prep = connection.prepareStatement("DELETE FROM `offre` WHERE id=?");
            prep.setInt(1, id);
            prep.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<Offre> readAll() {
        List<Offre> listeOffre = new ArrayList<>();
        try {
            Statement = connection.createStatement();
               System.out.println(SessionManager.getId()+" iddddddddddddddd");
            ResultSet r = Statement.executeQuery("SELECT * from `offre` where id_soc="+SessionManager.getId());
            while (r.next()) {
                int id = r.getInt("id");
                int nbCand = nbCandidature(id);
                String titre = r.getString(3);
                String desc = r.getString(5);
                String domaine = r.getString(6);
                String dateExp = r.getString(7);
                int id_soc = r.getInt(12);
                String modeTravail = r.getString(14);
                String typeOffre = r.getString(17);
                TypeOffre tp = TypeOffre.valueOf(typeOffre);
                String dateAjout = r.getString(18);
                // Button bt=new Button("test");
                Offre O = new Offre(id, titre, desc, domaine, dateExp, modeTravail, id_soc, tp, dateAjout, nbCand);

                listeOffre.add(O);

            }
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeOffre;
    }

    public Offre selectById(int id) {
        try {
            Statement = connection.createStatement();
            ResultSet r = Statement.executeQuery("SELECT * from `offre` where id=" + id);

            r.next();
            int id1 = r.getInt(1);
            String titre = r.getString("titre");
            String Salaire = r.getString("salaire");
            String desc = r.getString("description");
            String domaine = r.getString("domaine");
            String dateExp = r.getString("dateExpiration");

            String duree = r.getString("dureeStage");

            //String dureeStage= r.getString("lieu");
            String typeStage = r.getString("typeStage");

            String typeContrat = r.getString("typeContrat");
            int id_soc = r.getInt("id_Soc");

            String modeTravail = r.getString("modeTravail");
            String lieu = r.getString("lieu");
            int id_test = r.getInt("id_test");
            String typeOffre = r.getString("typeOffre");
            String dateAjout = r.getString("dateAjout");
            String tp = valueOf(typeOffre);
            Offre O = new Offre(id1, titre, Salaire, desc, domaine, dateExp, duree, typeStage, lieu, id_test, dateAjout, modeTravail, duree, typeContrat, id_soc, tp);

            return O;
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Offre readLast() {
        try {
            Statement = connection.createStatement();
            ResultSet r = Statement.executeQuery("SELECT * from `offre` where id_soc=" + SessionManager.getId() + " ORDER BY id DESC LIMIT 1");
            while (r.next()) {
                int id = r.getInt("id");
                String titre = r.getString("titre");
                String desc = r.getString("description");
                String domaine = r.getString("domaine");
                String dateExp = r.getString("dateExpiration");
                int id_soc = r.getInt("id_Soc");
                String modeTravail = r.getString("modeTravail");
                String typeOffre = r.getString("typeOffre");
                TypeOffre tp = TypeOffre.valueOf(typeOffre);
                //String dateAjout=r.getString(17);
                //Button bt=new Button("test");
                Offre O = new Offre(id, titre, desc, domaine, dateExp, modeTravail, id_soc, tp);
                return O;

            }
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ObservableList<DTOCandidature_Offre> candidatures_Offre(int id_off) {

        ObservableList<DTOCandidature_Offre> candidatures = FXCollections.observableArrayList();
        try {
            Statement = connection.createStatement();
            ResultSet r = Statement.executeQuery("SELECT u.tel,o.id,o.salaire,u.id,c.id,u.email, u.nom ,c.dateAjout,c.noteTest,c.lettreMotivation,c.statut,o.titre "
                    + "from `candidature` c join `offre` o on c.id_offre=o.id JOIN `utilisateur` u ON u.id=c.idcondidat where o.id=" + id_off);
            while (r.next()) {
                DTOCandidature_Offre cand = new DTOCandidature_Offre();
                cand.setNomCandidat(r.getString("u.nom"));
                cand.setDateAjout(r.getDate("c.dateAjout").toString());
                cand.setNoteTest(r.getString("c.noteTest"));
                cand.setLettreMotivation(r.getString("c.lettreMotivation"));
                cand.setStatut(r.getString("c.statut"));
                cand.setTitreOffre(r.getString("o.titre"));
                cand.setId_cand(r.getInt("c.id"));
                cand.setEmail(r.getString("u.email"));
                cand.setId_user(r.getInt("u.id"));
                cand.setSalaire(r.getString("o.salaire"));
                cand.setId_off(r.getInt("o.id"));
                cand.setSalaire(r.getString("u.tel"));

                System.out.println(cand.getEmail());

                candidatures.add(cand);

            }
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return candidatures;

    }

    public int nbCandidature(int idO) {
        int nb = -1;
        try {
            Statement = connection.createStatement();
            ResultSet r = Statement.executeQuery("SELECT count(*) from `offre` o join `candidature` c on o.id=c.id_offre where o.id=" + idO);
            r.next();
            nb = r.getInt(1);
            return nb;

        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nb;

    }

    public int totNbOffres(int id_soc) {
        int nb = -1;
        try {
            Statement = connection.createStatement();
            ResultSet r = Statement.executeQuery("SELECT count(*) from `offre` where id_Soc=" + SessionManager.getId());
            r.next();
            nb = r.getInt(1);

            return nb;

        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nb;

    }

    public int totNbOffresParSemaine(int id_soc) {
        int nb = -1;
        try {
            Statement = connection.createStatement();
            ResultSet r = Statement.executeQuery("SELECT COUNT(*) FROM `offre` WHERE id_Soc=" + SessionManager.getId() + " and DATEDIFF(CURRENT_DATE(),dateAjout)<7");
            r.next();
            nb = r.getInt(1);

            return nb;

        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nb;

    }

    public List<Offre> AfficherAllOffre() throws SQLException {
        Statement st = connection.createStatement();
        /*  String typeOffre = r.getString(16);
                TypeOffre tp = TypeOffre.valueOf(typeOffre);*/

        List<Offre> assu = new ArrayList<>();
        String req = "select * from offre ";
        // String req = "select * from offre ";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Offre u = new Offre(rst.getInt("id"),
                    rst.getString("titre"),
                    rst.getString("salaire"),
                    rst.getString("description"),
                    rst.getString("domaine"),
                    rst.getString("dateExpiration"),
                    rst.getString("dureeStage"),
                    rst.getString("typeStage"),
                    rst.getString("dureeContrat"),
                    rst.getString("typeContrat"),
                    rst.getString("typeOffre"),
                    rst.getInt("id_Soc"),
                    rst.getString("modeTravail"),
                    rst.getString("lieu"),
                    rst.getInt("id_test"),
                    TypeOffre.valueOf(rst.getString("typeOffre"))
            );
            assu.add(u);
        }
        return assu;
    }


     public boolean updateStatut(DTOCandidature_Offre dto) {
        try {

            PreparedStatement prep = connection.prepareStatement("UPDATE `candidature` SET `statut`=? WHERE id=?");
              prep.setInt(2, dto.getId_cand());
            prep.setString(1, dto.getStatut());
          
    
            prep.executeUpdate();
            return true;
        } catch (SQLException ex) {

        }
        return false;
    }

         public int totNbCandidature() {
        int nb = -1;
        try {
            Statement = connection.createStatement();
            ResultSet r = Statement.executeQuery("SELECT count(*) from `candidature` c join offre o on c.id_offre=o.id where o.id_Soc=" + SessionManager.getId());
            r.next();
            nb = r.getInt(1);

            return nb;

        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nb;

    }

    public int totNbCandidatureParSemaine() {
        int nb = -1;
        try {
            Statement = connection.createStatement();
            ResultSet r = Statement.executeQuery("SELECT COUNT(*) FROM `candidature` c join offre o on c.id_offre=o.id where o.id_Soc=" + SessionManager.getId() + " and DATEDIFF(CURRENT_DATE(),c.dateAjout)<7");
            r.next();
            nb = r.getInt(1);

            return nb;

        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nb;

    }
     public int totNbEvenement() {
        int nb = -1;
        try {
            Statement = connection.createStatement();
            ResultSet r = Statement.executeQuery("SELECT count(*) from `evennement` where id_user=" + SessionManager.getId());
            r.next();
            nb = r.getInt(1);

            return nb;

        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nb;

    }

    public int totNbevennementParSemaine() {
        int nb = -1;
        try {
            Statement = connection.createStatement();
            ResultSet r = Statement.executeQuery("SELECT COUNT(*) FROM `evennement` WHERE id_user=" + SessionManager.getId() + " and DATEDIFF(CURRENT_DATE(),dateDebut)>0");
            r.next();
            nb = r.getInt(1);

            return nb;

        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nb;

    }
    
    
         public int totNbParticipations() {
        int nb = -1;
        try {
            Statement = connection.createStatement();
            ResultSet r = Statement.executeQuery("SELECT count(*) from `participation` where id_userP=" + SessionManager.getId());
            r.next();
            nb = r.getInt(1);

            return nb;

        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nb;

    }

    public int totNbParticipationsPrévu() {
        int nb = -1;
        try {
            Statement = connection.createStatement();
            ResultSet r = Statement.executeQuery("SELECT COUNT(*) FROM `participation` p join evennement e on e.id=p.id_event WHERE id_userP=" + SessionManager.getId() + " and DATEDIFF(CURRENT_DATE(),e.dateDebut)>0");
            r.next();
            nb = r.getInt(1);

            return nb;

        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nb;

    }
       public int totNbCandbyCandidat() {
        int nb = -1;
        try {
            Statement = connection.createStatement();
            ResultSet r = Statement.executeQuery("SELECT COUNT(*) FROM `candidature` WHERE idcondidat=" + SessionManager.getId()+" and TypeCondidature ='Freelancer'");
            r.next();
            nb = r.getInt(1);

            return nb;

        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nb;

    }
       
       public int totNbCandOfrre() {
        int nb = -1;
        try {
            Statement = connection.createStatement();
            ResultSet r = Statement.executeQuery("SELECT COUNT(*) FROM `candidature` WHERE idcondidat=" + SessionManager.getId()+" and TypeCondidature !='Freelancer'");
            r.next();
            nb = r.getInt(1);

            return nb;

        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nb;

    }
}
