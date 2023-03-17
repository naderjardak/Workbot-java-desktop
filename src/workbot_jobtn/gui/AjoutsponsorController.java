package workbot_jobtn.gui;

import workbot_jobtn.entites.Evennement;
import workbot_jobtn.entites.Sponsor;
import static workbot_jobtn.gui.AfficheeventController.idsp;
import static workbot_jobtn.gui.NewhomeeventController.v;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import static java.util.Collections.list;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.codehaus.plexus.util.FileUtils;
import static workbot_jobtn.gui.N_ajouter_Certification.SelectedFile1;
import workbot_jobtn.services.EventService;
import workbot_jobtn.services.Sponservice;
import workbot_jobtn.utils.SessionManager;

public class AjoutsponsorController implements Initializable {
ObservableList<Sponsor> list = FXCollections.observableArrayList();
    @FXML
    private TextField aj_logo;

    @FXML
    private TextField aj_sponsor;

    @FXML
    private Button confirmajsponsor;
    @FXML
    private TableColumn<Sponsor, String> H_nomspon;
    @FXML
    private TableColumn<Sponsor, String> H_logo;
    @FXML
    private Button upspon;
    @FXML
    private Button delspon;
    @FXML
    private TableView<Sponsor> HTABSPON;
    @FXML
    private TableColumn<Sponsor, Integer> idspn;
    @FXML
    private Label alertajspon;
    @FXML
    private Button homeajspon;
    @FXML
    private Button logoajoutev;
    @FXML
    private Button retajspons;
    @FXML
    private TextField sponinputsearch;
    @FXML
    private Button Toaddevent;
    @FXML
    private Button Toeventlist;

    @FXML
    void confirmajspon(ActionEvent event) throws SQLException, IOException {
        Sponservice sp=new Sponservice();
        
        Sponsor s=new Sponsor(aj_sponsor.getText(),aj_logo.getText(),AfficheeventController.idsp);
        if("".equals(aj_sponsor.getText())|| "".equals(aj_logo.getText()))
        
             alertajspon.setText("Completer les champs svp");
                else{
         sp.ajouterspon(s);
         
                     File srcFile = selectedFilehous;
            File destDir = new File("C:\\Workbot-web\\public\\Upload\\logo");
            
            try {

            FileUtils.copyFileToDirectory(srcFile, destDir);

            System.out.println("File successfully copied in Java");

            } catch (IOException e) {

            e.printStackTrace();
            }
         
         Stage stage = (Stage) aj_logo.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("ajoutsponsor.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,895,535)); 
                stage.show();
                }
         
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         FilteredList<Sponsor> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		sponinputsearch.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(admin -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (admin.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter prenom.
				}
                                
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Sponsor> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(HTABSPON.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		HTABSPON.setItems(sortedData);
               
        
    try {
        Sponservice ps=new Sponservice();
        sortedData.comparatorProperty().bind(HTABSPON.comparatorProperty());
        int id=AfficheeventController.idsp;
        list.addAll(ps.readALLspon(id));
        
        
        H_nomspon.setCellValueFactory(new PropertyValueFactory<Sponsor, String>("nom"));
        H_logo.setCellValueFactory(new PropertyValueFactory<Sponsor, String>("logo"));
        idspn.setCellValueFactory(new PropertyValueFactory<Sponsor, Integer>("id"));
         sortedData.comparatorProperty().bind(HTABSPON.comparatorProperty());
        HTABSPON.setItems(sortedData);
    } catch (SQLException ex) {
        Logger.getLogger(AjoutsponsorController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
            
			
 
      //  sp.ajouter(s);
static public int idsp=0;
    @FXML
    private void H_sponclick(MouseEvent event) {
        
        int index;
        Sponsor s=new Sponsor();
        
       index =  HTABSPON.getSelectionModel().getSelectedIndex();
       
       if(index <= -4){
          
            return;
       }
   
    s.setNom(H_nomspon.getCellData(index).toString());
    s.setLogo(H_logo.getCellData(index).toString());
    
    idsp=idspn.getCellData(index).intValue();
    aj_sponsor.setText(s.getNom());
     aj_logo.setText(s.getLogo());
     
    }

    @FXML
    private void Updatespon(ActionEvent event) throws SQLException, IOException {
        int id=AfficheeventController.idsp;
        Sponsor s = new Sponsor(idsp,aj_sponsor.getText(),aj_logo.getText(),id);
        Sponservice sp=new Sponservice();
        if("".equals(aj_sponsor.getText())|| "".equals(aj_logo.getText()))
        
             alertajspon.setText("saisir le sponsor pour le mis a jour");
        else{
        sp.updatespon(s);
        Stage stage = (Stage) aj_logo.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("ajoutsponsor.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1)); 
                stage.show();
        }
       
        
    }

    @FXML
    private void deletespon(ActionEvent event) throws SQLException, IOException {
        
        int index;
        
        
       index =  HTABSPON.getSelectionModel().getSelectedIndex();
       
       if(index <= -4){
          
            return;
       }
       Sponsor s=new Sponsor(idspn.getCellData(index).intValue());
       Sponservice sp=new Sponservice();
       //if("".equals(aj_sponsor.getText())|| "".equals(aj_logo.getText()))
        
             //alertajspon.setText("saisir le sponsor a supprimer");
        //else{
       sp.deletespon(s);
        Stage stage = (Stage) aj_logo.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("ajoutsponsor.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1)); 
                stage.show();
    //}
    }

    private void retoursp(ActionEvent event) throws IOException {
        
        
        Stage stage = (Stage) aj_logo.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("afficheevent.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1)); 
                stage.show();
    }
static public String lg="";
static public File selectedFilehous;
    @FXML
    private void doclicklogochoose(ActionEvent event) {
        
        
        FileChooser fc= new FileChooser();
         selectedFilehous=fc.showOpenDialog(null);
        if (selectedFilehous !=null){
           lg=selectedFilehous.getName();
           aj_logo.setText(lg);
        }
        else
        {
            System.out.println("text is not valid");
        }
    }

    @FXML
    private void homeajspon(ActionEvent event) throws IOException {
        Stage stage = (Stage) aj_logo.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("firstevent.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,895,535)); 
                stage.show();
    }

    @FXML
    private void doclickretajspon(ActionEvent event) throws IOException {
        Stage stage = (Stage) aj_logo.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("HomeSociete.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1)); 
                stage.show();
    }

    @FXML
    private void doclickToaddevent(ActionEvent event) throws IOException {
           Stage stage = (Stage) aj_logo.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("newhomeevent.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1)); 
                stage.show();
    }

    @FXML
    private void doclickToeventlist(ActionEvent event) throws IOException {
           Stage stage = (Stage) aj_logo.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("afficheevent.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1)); 
                stage.show();
    }

    
    
    
}
