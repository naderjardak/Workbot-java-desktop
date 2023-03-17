/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import workbot_jobtn.entites.Evennement;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.codehaus.plexus.util.FileUtils;
import static workbot_jobtn.gui.N_ajouter_Cours.SelectedFile;
import workbot_jobtn.services.EventService;
import workbot_jobtn.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class NewhomeeventController implements Initializable {

 @FXML
    private TextField datedb;

    @FXML
    private Label datefn;

    @FXML
    private Button evconfirm;

    @FXML
    private TextField evideo;

    @FXML
    private TextField flyer;

    @FXML
    private TextField heuredb;

    @FXML
    private TextField heurefin;

    @FXML
    private TextField heurefn;


    @FXML
    private TextField lib;

    @FXML
    private Button listbtnevent;

    @FXML
    private TextField nbplc;

    private Button partbtnevent;

    @FXML
    private TextField prix;
    @FXML
    private Label labelwar;
    @FXML
    private Button flyerchooser1;
    @FXML
    private Button vidchoose;
    @FXML
    private Button btnaddrefrech;
    @FXML
    private Button RETfirstev;
    @FXML
    private Button homeevntaff;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
static public int id=0;
    @FXML
    private void doClickevconfirm(ActionEvent event) throws SQLException, IOException {
    
       
           EventService es=new EventService();
           int nbplce=0;
           nbplce=Integer.parseInt(nbplc.getText());
              int iduser=SessionManager.getId();
              Evennement e=new Evennement(datedb.getText(),datefn.getText(),lib.getText(),heuredb.getText(),heurefn.getText(),nbplce,prix.getText(),f,v,iduser);
    
                if("".equals(flyer.getText())|| 
                        "".equals(datedb.getText())||
                        "".equals(datefn.getText())||
                        "".equals(lib.getText())||
                        "".equals(heuredb.getText())||
                        "".equals(heurefn.getText())||
                        nbplce==0||
                        "".equals(prix.getText())||
                        "".equals(evideo.getText()))  
                labelwar.setText("completer les champs svp");
                   
                else{
                    
            File srcFile = selectedFileVideo;
            File destDir = new File("C:\\Workbot-web\\public\\Upload\\video");
            
            File srcFile1 = selectedFileFlyer;
            File destDir1 = new File("C:\\Workbot-web\\public\\Upload\\flyer");
            try {

            FileUtils.copyFileToDirectory(srcFile, destDir);
            FileUtils.copyFileToDirectory(srcFile1, destDir1);

            System.out.println("File successfully copied in Java");

            } catch (IOException eq) {

            eq.printStackTrace();
            }
         es.ajouter(e);
      //id= es.affid();
      //System.out.println(id);
      
      Stage stage = (Stage) nbplc.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("afficheevent.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();}
    }
 

  

    @FXML
    void doClicklistbtnevent(ActionEvent event) throws IOException {
        Stage stage = (Stage) nbplc.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("afficheevent.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();

    }

    void doClickpartbtnevent(ActionEvent event) {

    }
static public String f="";
static public String v="";
static public File selectedFileFlyer;
    @FXML
    private void doClickflyerchooser1(ActionEvent event) {
        FileChooser fc= new FileChooser();
        selectedFileFlyer=fc.showOpenDialog(null);
        if (selectedFileFlyer !=null){
           f=selectedFileFlyer.getName();
           flyer.setText(f);
        }
        else
        {
            System.out.println("text is not valid");
        }
        
        
        
        
        
    }

    static public File selectedFileVideo;
    @FXML
    private void doClickvidchoose(ActionEvent event) {
        FileChooser fc= new FileChooser();
        selectedFileVideo=fc.showOpenDialog(null);
        if (selectedFileVideo !=null){
           v=selectedFileVideo.getName();
           evideo.setText(v);
        }
        else
        {
            System.out.println("text is not valid");
        }
    }

    @FXML
    private void doclickbtnaddrefrech(ActionEvent event) throws IOException {
        Stage stage = (Stage) nbplc.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("newhomeevent.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }

    @FXML
    private void doclickRETfirstev(ActionEvent event) throws IOException {
         Stage stage = (Stage) nbplc.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("firstevent.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }

    @FXML
    private void homeevntaffich(ActionEvent event) throws IOException {
            Stage stage = (Stage) nbplc.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("HomeSociete.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }

    

}
