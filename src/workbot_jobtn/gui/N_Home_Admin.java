/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import workbot_jobtn.entites.StatCertif;
import workbot_jobtn.services.N_Services_Certification;
import workbot_jobtn.services.N_Services_Cours;
import workbot_jobtn.services.N_Services_Stat;
import workbot_jobtn.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class N_Home_Admin implements Initializable {

    @FXML
    private Button N_BMCours;
    @FXML
    private Button N_BMCertification;
    @FXML
    private Button N_BMHome;
    @FXML
    private WebView N_AdsView;
    private WebEngine e;
    @FXML
    private Button N_BMenuTOP1;
    @FXML
    private Button N_BGererCompte1;
    @FXML
    private Button N_BDeconnecter1;
    @FXML
    private Pane menu_profile;
    @FXML
    private NumberAxis AxeY_Stat;
    @FXML
    private CategoryAxis AxeX_Stat;
    @FXML
    private StackedBarChart<?, ?> stat;

    /**
     * Initializes the controller class.
     */
    Connection connexion;
    @FXML
    private PieChart chart_cours;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            // TODO
            N_Services_Stat ss = new N_Services_Stat();
            int nb = (int) ss.nb_users();
            show();
            N_Services_Certification sc = new N_Services_Certification();
            List<StatCertif> l = sc.calcule_Certif();
            XYChart.Series s = new XYChart.Series<>();
            XYChart.Series s1 = new XYChart.Series<>();
            s1.getData().add(new XYChart.Data("users", nb));
            s1.setName(" Users");
            s.setName(" Certificat");

            for (int i = 0; i < l.size(); i++) {

                s.getData().add(new XYChart.Data(l.get(i).getTitre(), l.get(i).getNb()));

            }
            stat.getData().addAll(s1, s);
            
            
                     N_Services_Cours nsc=new N_Services_Cours();
        stat.setTitle("Les statistiques sur les Cours par Domaine ");
              int nb1=0;
                      
                      nb1=nsc.stat_Cours().size();
    for(int j=0;j<nb1;j++)
    {
        chart_cours.getData().add(new PieChart.Data(nsc.stat_Cours().get(j).getDomaine(),nsc.stat_Cours().get(j).getNb()));
    }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(N_Home_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    

    public void show() {
        e = N_AdsView.getEngine();
        e.load("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1");
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Afficher_Cours_Liste.fxml"));
        Scene stage = new Scene(fXMLLoader);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();

    }

    @FXML
    private void N_menu_certif_Admin(ActionEvent event) throws IOException {

        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Afficher_Certif_Liste.fxml"));
        Scene stage = new Scene(fXMLLoader);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();

    }

    int i = 0;

    @FXML
    private void show_menu(ActionEvent event) {
        if (i % 2 == 0) {
            menu_profile.setVisible(true);
        } else {
            menu_profile.setVisible(false);
        }
        i++;
    }

    @FXML
    private void compte(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        
        
        SessionManager.cleanUserSession();
           
            Parent root = FXMLLoader.load(getClass().getResource("M_Login.fxml"));
            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();

    }

    @FXML
    private void Browser(MouseEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1"));

    }

    @FXML
    private void retour_Admin(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("M_ListAdmin.fxml"));
            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
    }

}
