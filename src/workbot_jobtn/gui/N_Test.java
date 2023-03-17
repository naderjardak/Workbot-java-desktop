/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import workbot_jobtn.gui.MailerAPI;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import workbot_jobtn.entites.Certification;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import workbot_jobtn.services.N_Services_Certification;
import workbot_jobtn.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class N_Test implements Initializable {

    @FXML
    private Button N_BMCours;
    @FXML
    private Button N_BMHome;
    @FXML
    private Pane menu_profile;

    /**
     * Initializes the controller class.
     */
     int id=0;
     String titreT="",titreC="",lien="",datea="";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        id =N_Rechercher_Certif_Liste.co1.getId();
        titreT=N_Rechercher_Certif_Liste.co1.getTitreTest();
        titreC=N_Rechercher_Certif_Liste.co1.getTitreCours();
        lien=N_Rechercher_Certif_Liste.co1.getLien();
        datea=N_Rechercher_Certif_Liste.co1.getDateAjout();
         System.out.println(id+" "+titreC+" "+titreT+" "+datea+" "+lien+" valider");
        
        
    }    

    @FXML
    private void Refuser(ActionEvent event) {
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("Desolé "+SessionManager.getNom()+" !!");
        tray.setMessage("Votre note est inferieur à 10 !!");
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndDismiss(Duration.millis(2000));
        //window refuser
    }

    @FXML
    private void Valider(ActionEvent event) throws SQLException, IOException {
    
        Thread th = new Thread(() -> {

 N_Services_Certification nsc=new N_Services_Certification();
 System.out.println(id+" "+titreC+" "+titreT+" "+datea+" "+lien+" valider");
 Certification c=new Certification(id,titreC,titreT,datea,lien);
    try {
        nsc.affecter(c,SessionManager.getId());
    } catch (SQLException ex) {
        Logger.getLogger(N_Test.class.getName()).log(Level.SEVERE, null, ex);
    }
 
 Document document = new Document();
            N_Services_Certification sc=new N_Services_Certification();
            ObservableList<Certification> data;
    try {
        data = sc.read_Certif();
    } catch (SQLException ex) {
        Logger.getLogger(N_Test.class.getName()).log(Level.SEVERE, null, ex);
    }
            String pattern = "dd_MM_yyyy HH_mm_ss";          
            DateFormat df = new SimpleDateFormat(pattern);
            java.util.Date today = Calendar.getInstance().getTime();
            String reportDate = df.format(today);
            
            String nd="dd MM yyyy";
            DateFormat ndc =new SimpleDateFormat(nd);
            String dateCertif = ndc.format(today);

        
        try {
   
           
            PdfWriter.getInstance(document, new FileOutputStream( "certif_"+titreC+"_"+reportDate+".pdf"));
            document.open();
            Image image1 = Image.getInstance(getClass().getResource("/certif.png"));
            image1.scaleToFit(700,420);
            image1.setAbsolutePosition(0f, 456f);
            document.add(image1);
            

            document.add(new Paragraph("\n\n\n\n\n\n                              "+SessionManager.getNom()+" "+SessionManager.getPrenom()+"\n\n                                             "+titreC+"\n\n\n\n\n\n                                 "+dateCertif));


        } catch (Exception e) {
            e.printStackTrace();
        }
        document.close();
        
        File file = new File("certif_"+titreC+"_"+reportDate+".pdf");
        
        //Vérifier si le système prend en charge la classe Desktop ou non
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop n'est pas prise en charge");
            return ;
        }
        
       Desktop d = Desktop.getDesktop();
        if(file.exists()) 
            try {
                d.open(file);
 } catch (IOException ex) {
     Logger.getLogger(N_Test.class.getName()).log(Level.SEVERE, null, ex);
 }
     

       
     
           String UN ="jardak.nader@esprit.tn";
           String PW = "23neymar1999";  
           String mto = SessionManager.getEmail();
           String msub = "Feliciation ";
           String cTEXT ="Cher Client , Félicitation vous etes certifier en " +titreC;
           MailerAPI.Mail(UN, PW, mto, msub, cTEXT);

      });
        th.setDaemon(true);
        th.start();  
    }
    
}
