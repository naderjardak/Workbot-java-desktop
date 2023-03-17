/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
import workbot_jobtn.entites.Certification;
import static workbot_jobtn.gui.N_Afficher_Certif_Liste.co1;
import workbot_jobtn.services.N_Services_Certification;
import workbot_jobtn.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class N_Affecter_Certification implements Initializable {

    @FXML
    private Button Cours_button_menu;
    @FXML
    private Button N_BCertification;
    @FXML
    private Button N_BHome;
    @FXML
    private Button N_CertifRetour;
    @FXML
    private WebView N_AdsView;
    @FXML
    private Button affecter;
    @FXML
    private TextField N_user_mail;
    @FXML
    private Label err;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void B_cours(ActionEvent event) {
    }

    @FXML
    private void B_home(ActionEvent event) {
    }

    @FXML
    private void N_W_CertifRetour(ActionEvent event) {
    }

    @FXML
    private void Browser(MouseEvent event) {
    }

    @FXML
    private void affecter_certif(ActionEvent event) throws SQLException {
        N_Services_Certification nsc=new N_Services_Certification();
        String mail="";
        mail=N_user_mail.getText();
        if(mail.equals(""))
        {
          err.setText("Il faut remplire la case Mail !!");  
        }
        else if(nsc.affU(mail)==0)
        {
          err.setText("Mail does not exist !!");  
        }
        else
        {
        System.out.println(co1.getId()+" "+co1.getTitreCours());
        nsc.affecter(co1,nsc.affU(mail));
        err.setText("Affectation terminé !!");  
        }
            
    }
    
}
