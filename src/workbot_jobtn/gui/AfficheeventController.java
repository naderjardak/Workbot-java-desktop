/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import workbot_jobtn.entites.Evennement;
import static workbot_jobtn.gui.NewhomeeventController.f;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import workbot_jobtn.services.EventService;
import workbot_jobtn.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author hp
 */

public class AfficheeventController implements Initializable {
ObservableList<Evennement> list = FXCollections.observableArrayList();

    @FXML
    private TableView<Evennement> HTABV;
    @FXML
    private TableColumn<Evennement, String> aff_datedb;
    @FXML
    private TableColumn<Evennement, String> aff_datefin;
    @FXML
    private TableColumn<Evennement, String> aff_lib;
    @FXML
    private TableColumn<Evennement, String> aff_heuredb;
    @FXML
    private TableColumn<Evennement, String> aff_heurefin;
    @FXML
    private TableColumn<Evennement, Integer> aff_nbplc;
    @FXML
    private TableColumn<Evennement, String> aff_prix;
    @FXML
    private TableColumn<Evennement, String> aff_flyer;
    @FXML
    private TableColumn<Evennement, String> aff_video;
    @FXML
    private TextField datdb;
    @FXML
    private TextField datfn;
    @FXML
    private TextField libel;
    @FXML
    private TextField nbplace;
    @FXML
    private TextField heurfn;
    @FXML
    private TextField heurdb;
    @FXML
    private TextField flyer;
    @FXML
    private TextField video;
    @FXML
    private Label datefn;
    @FXML
    private Button H_btnupdateevent;
    @FXML
    private Button H_btndeleteevent;
    @FXML
    private TextField prix;
    @FXML
    private TableColumn<Evennement, Integer> idev;
    @FXML
    private Button H_afficheparticip;
    @FXML
    private Button affiche_spon;
    @FXML
    private Button homeevntaff;
    @FXML
    private AnchorPane alertafficheev;
    @FXML
    private Label alertaffev;
    @FXML
    private Button vidchoose;
    @FXML
    private Button flychoose;
    @FXML
    private Button retouraffevent;
    @FXML
    private Button refrechev;
    @FXML
    private TextField searchinputaffev;
    @FXML
    private Button btnaddrefrech;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
         FilteredList<Evennement> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		searchinputaffev.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(admin -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (admin.getLibelle().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter prenom.
				}
                                
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Evennement> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(HTABV.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		HTABV.setItems(sortedData);
               
        try {
         EventService es=new EventService();
         Evennement e = new Evennement();
        sortedData.comparatorProperty().bind(HTABV.comparatorProperty());        
         System.out.println(list);
         int ids=SessionManager.getId();
         list.addAll(es.readALL(ids));
           

         
         
         aff_datedb.setCellValueFactory(new PropertyValueFactory<Evennement, String>("dateDebut"));
         aff_datefin.setCellValueFactory(new PropertyValueFactory<Evennement, String>("dateFin"));
         aff_lib.setCellValueFactory(new PropertyValueFactory<Evennement, String>("libelle"));
         aff_heuredb.setCellValueFactory(new PropertyValueFactory<Evennement, String>("heureDebut"));
         aff_heurefin.setCellValueFactory(new PropertyValueFactory<Evennement, String>("heureFin"));
         aff_nbplc.setCellValueFactory(new PropertyValueFactory<Evennement, Integer>("nbPlaces"));
         aff_prix.setCellValueFactory(new PropertyValueFactory<Evennement, String>("prix"));
         aff_flyer.setCellValueFactory(new PropertyValueFactory<Evennement, String>("flyer"));
         aff_video.setCellValueFactory(new PropertyValueFactory<Evennement, String>("video"));
         idev.setCellValueFactory(new PropertyValueFactory<Evennement, Integer>("id"));
         sortedData.comparatorProperty().bind(HTABV.comparatorProperty());
         HTABV.setItems(sortedData);
         
         //} catch (SQLException ex) {
         
         //}
     } catch (SQLException ex) {
         Logger.getLogger(AfficheeventController.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    }    

    @FXML
    private void updateevents(ActionEvent event) throws SQLException, IOException {
 
 
         int ids=SessionManager.getId();
   Evennement e = new Evennement(idev1,datdb.getText(),
           datfn.getText(),
           libel.getText(),
           heurdb.getText(),
           heurfn.getText(),
         parseInt(nbplace.getText()),
          prix.getText(),
           flyer.getText(),
            video.getText(),ids);
            EventService es=new EventService();
            
            if("".equals(datdb.getText())||
                    "".equals(datfn.getText())||
                    "".equals(libel.getText())||
                    "".equals(heurdb.getText())||
                    "".equals(heurfn.getText())||
                    //parseInt(nbplace.getText())==0||
                    "".equals(nbplace.getText())||
                    "".equals(prix.getText())||
                    "".equals(flyer.getText())||
                    "".equals(video.getText()))
                alertaffev.setText("completer les champs s'il vous plait");
            else
            {
                
            
            es.update(e);

            Stage stage = (Stage) flyer.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("afficheevent.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,895,535)); 
                stage.show();
                
                
            
    
            }
    }

    @FXML
    private void deleteevents(ActionEvent event) throws SQLException, IOException {
        int index;
        
        
       index =  HTABV.getSelectionModel().getSelectedIndex();
       
       if(index <= -4){
          
            return;
       }
       Evennement e=new Evennement(idev.getCellData(index).intValue());
       EventService es=new EventService();
       es.delete(e);
        Stage stage = (Stage) video.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("afficheevent.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,895,535)); 
                stage.show();
        
    }
static public int idev1=0;
    @FXML
    private void remplire_update(MouseEvent event) {
         int index;
        Evennement e=new Evennement();
        
       index =  HTABV.getSelectionModel().getSelectedIndex();
       
       if(index <= -4){
          
            return;
       }
   //e.setId(aff_datedb.getCellData(index).intValue());
    e.setDateDebut(aff_datedb.getCellData(index).toString());
    e.setDateFin(aff_datefin.getCellData(index).toString());
    e.setLibelle(aff_lib.getCellData(index).toString());
    e.setHeureDebut(aff_heuredb.getCellData(index).toString());
    e.setHeureFin(aff_heurefin.getCellData(index).toString());
    e.setNbPlaces(aff_nbplc.getCellData(index).intValue());
    e.setPrix(aff_prix.getCellData(index).toString());
    e.setFlyer(aff_flyer.getCellData(index).toString());
    e.setVideo(aff_video.getCellData(index).toString());
    e.setId(idev.getCellData(index).intValue());
    idev1=e.getId();
    
    datdb.setText(e.getDateDebut());
     datfn.setText(e.getDateFin());
      libel.setText(e.getLibelle());
       heurdb.setText(e.getHeureDebut());
        heurfn.setText(e.getHeureFin());
       nbplace.setText(""+e.getNbPlaces());
          prix.setText(e.getPrix());
           flyer.setText(e.getFlyer());
            video.setText(e.getVideo());
    }

    static public int ide=0;
    @FXML
    private void H_affichepart(ActionEvent event) throws IOException {
           int index;        
       index =  HTABV.getSelectionModel().getSelectedIndex();
       
       if(index <= -4){
          
            return;
       }
            ide=(idev.getCellData(index).intValue());
            
            Stage stage = (Stage) prix.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("afficheparticipant.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();

        
    }
 static public int idsp=0;
    @FXML
    private void affichesponbtn(ActionEvent event) throws IOException {
        int index;        
       index =  HTABV.getSelectionModel().getSelectedIndex();
       
       if(index <= -4){
          
            return;
       }
            idsp=(idev.getCellData(index).intValue());
            Stage stage = (Stage) prix.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("ajoutsponsor.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
        
    }

    @FXML
    private void homeevntaffich(ActionEvent event) throws IOException {
      Stage stage = (Stage) prix.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("HomeSociete.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }

    @FXML
    private void doclickvidchoose(ActionEvent event) {
        FileChooser fc= new FileChooser();
        File selectedFile=fc.showOpenDialog(null);
        if (selectedFile !=null){
           vl=selectedFile.getName();
           video.setText(vl);
    }
        
    }
public static String fl="";
public static String vl="";
    @FXML
    private void doclickflychoose(ActionEvent event) {
        FileChooser fc= new FileChooser();
        File selectedFile=fc.showOpenDialog(null);
        if (selectedFile !=null){
           fl=selectedFile.getName();
           flyer.setText(fl);
    }

    
}

    @FXML
    private void doclickretouraffevent(ActionEvent event) throws IOException {
        Stage stage = (Stage) prix.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("firstevent.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
        
    }

    @FXML
    private void doclickrefrechev(ActionEvent event) throws IOException {
            Stage stage = (Stage) prix.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("HomeSociete.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }

    @FXML
    private void doclickbtnaddrefrech(ActionEvent event) throws IOException {
            Stage stage = (Stage) prix.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("newhomeevent.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }
}
