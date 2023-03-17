/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import workbot_jobtn.utils.MyDB;

/**
 * FXML Controller class
 *
 * @author fnmoh
 */
public class M_StatisitiqueController implements Initializable {

    @FXML
    private Button M_listclientLS;
    @FXML
    private BarChart<String, Integer> batChart;

    /**
     * Initializes the controller class.
     */
    private java.sql.Connection on;
    private Statement ste;
    String role = "Admin";
    @FXML
    private Button M_logoutLAid;

    public M_StatisitiqueController() {
        on = MyDB.getInstance().getConnection();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chart();
    }

    @FXML
    private void M_listclientLS(ActionEvent event) {
        /*
         try {
    
                        Parent root = FXMLLoader.load(getClass().getResource("M_ListClient.fxml"));
                        
        Scene stage=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
         */
        try {

            Parent root = FXMLLoader.load(getClass().getResource("M_ListClient.fxml"));

            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chart() {

        String query = "select role ,count(id) from utilisateur GROUP BY role ";

        try {
            XYChart.Series chartData = new XYChart.Series();
            PreparedStatement smt = on.prepareStatement(query);
            ResultSet rs = smt.executeQuery();
            while (rs.next()) {
                chartData.getData().add(new XYChart.Data(rs.getString(1), rs.getInt(2)));
            }
            batChart.getData().add(chartData);
            

        } catch (Exception e) {

        }
    }

    private void executeQuery(String query) {
        Statement st;
        try {
            st = on.createStatement();
            st.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void M_logoutLAaction(ActionEvent event) {
        /*
         try {
    
                        Parent root = FXMLLoader.load(getClass().getResource("M_LoginUser.fxml"));
                        
        Scene stage=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
         */

        try {

            Parent root = FXMLLoader.load(getClass().getResource("M_LoginUser.fxml"));

            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void M_listclientLA(ActionEvent event) {
        /*
        try {
    
                        Parent root = FXMLLoader.load(getClass().getResource("M_ListAdmin.fxml"));
                        
        Scene stage=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
         */
        try {

            Parent root = FXMLLoader.load(getClass().getResource("M_ListAdmin.fxml"));

            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

@FXML
    private void cours_open(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("N_Home_Admin.fxml"));

            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();

    }

      @FXML
    private void On_reclamtion(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("yadmin_reclamation.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }


}