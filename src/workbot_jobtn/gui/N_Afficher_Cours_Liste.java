   /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import workbot_jobtn.entites.Cours;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import workbot_jobtn.services.N_Services_Cours;
//import jdbc.JDBC;
/**
 *
 * @author ADMIN
 */
public class N_Afficher_Cours_Liste implements Initializable {

     @FXML
        private WebView N_AdsView;
        private WebEngine e;
 
        
       
           @FXML
    private TextField N_cours_recherche_input;

    @FXML
    private Button N_BCertification;

    @FXML
    private Button N_BHome;

    @FXML
    private Button N_CAjouterActualiser;

    @FXML
    private Button N_CAjouterRetour;
    
    
    private Button N_C_consulter;
   
    
    @FXML
    private Button N_C_Supprimer;

    @FXML
    private Button pdf_b;
    
    @FXML
    private Button N_C_modifier;
    
    
    
    @FXML
    private TableView<Cours> N_Tab_aff_cours;
   
    @FXML private TableColumn<Cours,Integer> id;
    @FXML private TableColumn<Cours,String> titre;
    @FXML private TableColumn<Cours,String> matiere;
    @FXML private TableColumn<Cours,String> domaine;
    @FXML private TableColumn<Cours,String> categorie;
    @FXML private TableColumn<Cours,String> chemin;
    
    private final ObservableList<Cours> dataList = FXCollections.observableArrayList();
    @FXML
    private Button Cours_button_menu;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
          
		// TODO Auto-generated method stub  
         e=N_AdsView.getEngine();
         e.load("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1");
        
            N_Services_Cours sc=new N_Services_Cours();
            ObservableList<Cours> list;
   
          try {
                 
            FilteredList<Cours> filteredData = new FilteredList<>(dataList, b -> true);
		
		N_cours_recherche_input.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(cours -> {
					
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
							
				String lowerCaseFilter = newValue.toLowerCase();
				
				 String t=""+cours.getId();
                                if(t.toLowerCase().indexOf(lowerCaseFilter) != -1)
                                {
                                   return true;  
                                }				
                                else if (cours.getTitre().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (cours.getCategorie().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				     else  
				    	 return false; // Does not match.
			});
		});
                
               
            SortedList<Cours> sortedData = new SortedList<>(filteredData);
		
            sortedData.comparatorProperty().bind(N_Tab_aff_cours.comparatorProperty());
		
            dataList.addAll(sc.read_Cours());
            System.out.println(dataList);             
              id.setCellValueFactory(new PropertyValueFactory<Cours, Integer>("id"));
            titre.setCellValueFactory(new PropertyValueFactory<Cours, String>("titre"));
            matiere.setCellValueFactory(new PropertyValueFactory<Cours, String>("matiere"));
            domaine.setCellValueFactory(new PropertyValueFactory<Cours, String>("domaine"));
            categorie.setCellValueFactory(new PropertyValueFactory<Cours, String>("categorie"));
            chemin.setCellValueFactory(new PropertyValueFactory<Cours, String>("chemin"));
            N_Tab_aff_cours.setItems(sortedData);
                 
          } catch (SQLException ex) {
          }  
      
        }
        

        @FXML
    void N_W_CAjouter_actualiser(ActionEvent event) throws IOException {

        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Afficher_Cours_Liste.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
               
             
    }
    
    @FXML
    void N_W_CAjouterRetour(ActionEvent event) throws IOException {

        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Home_Admin.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();

    }

     static public Cours co=new Cours();
    void Afficher_cours_a_consulter(ActionEvent event) throws IOException
    {
        
       int index;
       index =  N_Tab_aff_cours.getSelectionModel().getSelectedIndex();
       
       if(index <= -1){
          
            return;
       }
       
   
    co.setId(id.getCellData(index).intValue());
    co.setTitre(titre.getCellData(index).toString());
    co.setMatiere(matiere.getCellData(index).toString());
    co.setDomaine(domaine.getCellData(index).toString());
    co.setChemin(chemin.getCellData(index).toString());
    System.out.println(co.getId()+"  "+co.getChemin());
    
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_CoursHtml_Admin.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
  
    }
      @FXML
    void N_C_Supp(ActionEvent event) throws SQLException, IOException {
        int index;
       index =  N_Tab_aff_cours.getSelectionModel().getSelectedIndex();
       
       if(index <= -1){
          
            return;
       }
       		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Supprimer");
		alert.setHeaderText("Voulez-vous vraiment supprimer ?");

		ButtonType an = new ButtonType("Annuler");
		ButtonType va = new ButtonType("Valider");
                
     		// Remove default ButtonTypes
		alert.getButtonTypes().clear();

		alert.getButtonTypes().addAll(va,an);

		// option != null.
		Optional<ButtonType> option = alert.showAndWait();
     if (option.get() == va)
             {       
                 co.setId(id.getCellData(index).intValue()); 
                 System.out.println(co.getId()+"  "+co.getChemin());
                 N_Services_Cours sc=new N_Services_Cours();
                 sc.supprimerCours(co);
                 N_W_CAjouter_actualiser(null);
             }
     
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Afficher_Certif_Liste.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();

     
    }
    
    @FXML
    void N_C_Modifier(ActionEvent event) throws IOException {
         int index;
       index =  N_Tab_aff_cours.getSelectionModel().getSelectedIndex();
       
       if(index <= -1){
          
            return;
       }
   
    co.setId(id.getCellData(index).intValue());
    co.setTitre(titre.getCellData(index).toString());
    co.setMatiere(matiere.getCellData(index).toString());
    co.setDomaine(domaine.getCellData(index).toString());
    co.setChemin(chemin.getCellData(index).toString());
    co.setCategorie(categorie.getCellData(index).toString());
    
    N_Services_Cours sc=new N_Services_Cours();
    
       Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_modifier_Cours.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();

    }

    @FXML
    public void pdfGeneration() throws SQLException, IOException {
            Document document = new Document();
            N_Services_Cours sc=new N_Services_Cours();
            ObservableList<Cours> data;
            data = sc.read_Cours();
            String pattern = "dd_MM_yyyy HH_mm_ss";
            DateFormat df = new SimpleDateFormat(pattern);
            java.util.Date today = Calendar.getInstance().getTime();
            String reportDate = df.format(today);
        
        try {
   
           
            PdfWriter.getInstance(document, new FileOutputStream( "ReportDate"+reportDate+".pdf"));
            document.open();
            Image image1 = Image.getInstance(getClass().getResource("/logo.png"));
            image1.scaleToFit(600,300);
            image1.setAbsolutePosition(150f, 550f);
            document.add(image1);
            

            document.add(new Paragraph("\n\n\n\n\n\n\n\n\n\n\n\n\n"));

   
            float[] columnWidths = {1, 3, 3, 3, 4, 8};
            PdfPTable table = new PdfPTable(columnWidths);
            table.setWidthPercentage(100);
            PdfPCell cell = new PdfPCell(new Phrase("Cours Table"));
            cell.setBackgroundColor(GrayColor.GRAYWHITE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(6);
            table.addCell(cell);
            
            table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell("Id");
            table.addCell("Titre");
            table.addCell("Matiere");
            table.addCell("Domaine");
            table.addCell("Categorie");
            table.addCell("Chemin");
            table.setHeaderRows(1);
            
            table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            
            for (int i = 1; i <= data.size(); i++) {
                Cours actualCours = data.get(i - 1);
                
                String id=(""+actualCours.getId());
                table.addCell(id);
                table.addCell(actualCours.getTitre());
                table.addCell(actualCours.getMatiere());
                table.addCell(actualCours.getDomaine());
                table.addCell(actualCours.getCategorie());
                table.addCell(actualCours.getChemin());
                
            }
            
            document.add(table);
           
 
            
            Chunk signature = new Chunk("\n\n PDf Cours Generator JOB.TN");
            Paragraph base = new Paragraph(signature);
            document.add(base);

        } catch (Exception e) {
            e.printStackTrace();
        }
        document.close();
        
        File file = new File("ReportDate"+reportDate+ ".pdf");
        
        //Vérifier si le système prend en charge la classe Desktop ou non
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop n'est pas prise en charge");
            return;
        }
        
        Desktop d = Desktop.getDesktop();
        if(file.exists()) 
            d.open(file);


}

    @FXML
    void B_cours(ActionEvent event) throws IOException {

       Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Afficher_Cours_Liste.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();

    }

    @FXML
    void B_home(ActionEvent event) throws IOException {
        
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Home_Admin.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
        
    }  
    
    @FXML
    void Ajouter_cours(ActionEvent event) throws IOException {
        
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_ajouter_Cours.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();

    }

    @FXML
    private void N_B_certif(ActionEvent event) throws IOException {
        
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Afficher_Certif_Liste.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
                   
    }

    @FXML
    private void Browser(MouseEvent event) throws URISyntaxException, IOException {
                Desktop.getDesktop().browse(new URI("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1"));

    }
}