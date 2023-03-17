package workbot_jobtn.gui;

import workbot_jobtn.gui.MailerAPI;
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
import workbot_jobtn.entites.Certification;
import workbot_jobtn.entites.Cours;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import static workbot_jobtn.gui.N_Afficher_Cours_Liste.co;
import java.util.Optional;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import workbot_jobtn.services.N_Services_Certification;
import workbot_jobtn.services.N_Services_Cours;
import workbot_jobtn.utils.SessionManager;

public class N_Afficher_Certif_Liste implements Initializable {

    @FXML
    private WebView N_AdsView;
    private WebEngine e;
    
    @FXML
    private Button Cours_button_menu;



    @FXML
    private Button N_BCertification;

    @FXML
    private Button N_BHome;


    @FXML
    private Button N_CertifRetour;


    @FXML
    private TableView<Certification> N_Tab_aff_certif;

    @FXML
    private TextField N_certif_recherche_input;

    
    @FXML
    private TableColumn<Certification, String> datea;

    @FXML
    private TableColumn<Certification, Integer> id;

    @FXML
    private TableColumn<Certification, String> lien;


    @FXML
    private TableColumn<Certification, String> titrec;

    @FXML
    private TableColumn<Certification, String> titret;


 private final ObservableList<Certification> dataList = FXCollections.observableArrayList();
    @FXML
    private Button affecter;
    @FXML
    private Button N_CertifActualiser;
    @FXML
    private Button vider;
    @FXML
    private Button N_Certif_Supprimer;
    @FXML
    private Button N_Certif_modifier;
    @FXML
    private Button bu_Ajouter_certif;
    @FXML
    private Button pdf_b;

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         e=N_AdsView.getEngine();    
         e.load("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1");
        
            N_Services_Certification sc=new N_Services_Certification();
            ObservableList<Certification> list;
   
          try {
                 
            FilteredList<Certification> filteredData = new FilteredList<>(dataList, b -> true);
		
		N_certif_recherche_input.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(certif -> {
					
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
		
                                
				String lowerCaseFilter = newValue.toLowerCase();
                                
                                String t=""+certif.getId();
                                if(t.toLowerCase().indexOf(lowerCaseFilter) != -1)
                                {
                                   return true;  
                                }				
                                else if (certif.getTitreCours().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (certif.getTitreTest().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                else if (certif.getDateAjout().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                else if (certif.getLien().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				     else  
				    	 return false; // Does not match.
			});
		});
                
               
            SortedList<Certification> sortedData = new SortedList<>(filteredData);
		
            sortedData.comparatorProperty().bind(N_Tab_aff_certif.comparatorProperty());
		
            dataList.addAll(sc.readAll_Certif());
            System.out.println(dataList);             
            id.setCellValueFactory(new PropertyValueFactory<Certification, Integer>("id"));
            titrec.setCellValueFactory(new PropertyValueFactory<Certification, String>("titreCours"));
            titret.setCellValueFactory(new PropertyValueFactory<Certification, String>("titreTest"));
            datea.setCellValueFactory(new PropertyValueFactory<Certification, String>("dateAjout"));
            lien.setCellValueFactory(new PropertyValueFactory<Certification, String>("lien"));
            N_Tab_aff_certif.setItems(sortedData);
                 
          } catch (SQLException ex) {
          }  
          }

 
 
 
    void Afficher_certif_a_consulter(ActionEvent event) throws IOException {
     
    

    }

    @FXML
    void Ajouter_certif(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_ajouter_Certification.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();

    }

    void B_badge(ActionEvent event) {

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

      static public Certification co1=new Certification();
    @FXML
    void N_Certif_Modifier(ActionEvent event) throws IOException {

                 int index;
       index =  N_Tab_aff_certif.getSelectionModel().getSelectedIndex();
       
       if(index <= -1){
          
            return;
       }
   
    co1.setId(id.getCellData(index).intValue());
    co1.setTitreCours(titrec.getCellData(index).toString());
    co1.setTitreTest(titret.getCellData(index).toString());
    co1.setDateAjout(datea.getCellData(index).toString());
    co1.setLien(lien.getCellData(index).toString());
    
    N_Services_Cours sc=new N_Services_Cours();
    
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_modifier_Certif.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();

    }
    
    
  static public Certification co=new Certification();
    @FXML
    void N_Certif_Supp(ActionEvent event) throws SQLException, IOException {
        int index;
       index =   N_Tab_aff_certif.getSelectionModel().getSelectedIndex();
       
       if(index <= -1){
          
            return;
       }  
    
    		Alert alert = new Alert(AlertType.CONFIRMATION);
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
    
    
    N_Services_Certification sc=new N_Services_Certification();
    sc.supprimerCertif(co);
    N_W_Certif_actualiser(null);
    }
     
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Afficher_Cours_Liste.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();

    }
    
    @FXML
    void N_W_CertifRetour(ActionEvent event) throws IOException {
                
            
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Home_Admin.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
              
        
        
    }

    @FXML
    void N_W_Certif_actualiser(ActionEvent event) throws IOException {
                    
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Afficher_Certif_Liste.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
                
    }

    @FXML
    void pdfGeneration(ActionEvent event) throws SQLException, IOException {
            Document document = new Document();
            N_Services_Certification sc=new N_Services_Certification();
            ObservableList<Certification> data;
            data = sc.read_Certif();
            String pattern = "dd_MM_yyyy HH_mm_ss";
            DateFormat df = new SimpleDateFormat(pattern);
            java.util.Date today = Calendar.getInstance().getTime();
            String reportDate = df.format(today);
        
        try {
   
           
            PdfWriter.getInstance(document, new FileOutputStream( "ReportDate_certif_"+reportDate+".pdf"));
            document.open();
            Image image1 = Image.getInstance(getClass().getResource("/logo.png"));
            image1.scaleToFit(600,300);
            image1.setAbsolutePosition(150f, 550f);
            document.add(image1);
            

            document.add(new Paragraph("\n\n\n\n\n\n\n\n\n\n\n\n\n"));

   
            float[] columnWidths = {1, 3, 3, 3, 4};
            PdfPTable table = new PdfPTable(columnWidths);
            table.setWidthPercentage(100);
            PdfPCell cell = new PdfPCell(new Phrase("Certification Table"));
            cell.setBackgroundColor(GrayColor.GRAYWHITE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(6);
            table.addCell(cell);
            
            table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell("Id");
            table.addCell("Titre Cours");
            table.addCell("Titre Test");
            table.addCell("date d'ajout");
            table.addCell("Lien");
            table.setHeaderRows(1);
            
            table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            
            for (int i = 1; i <= data.size(); i++) {
                Certification actualCours = data.get(i - 1);
                
                String id=(""+actualCours.getId());
                table.addCell(id);
                table.addCell(actualCours.getTitreCours());
                table.addCell(actualCours.getTitreTest());
                table.addCell(actualCours.getDateAjout());
                table.addCell(actualCours.getLien());
               
                
            }
            
            document.add(table);
           
 
            
            Chunk signature = new Chunk("\n\n PDf Cours Generator JOB.TN");
            Paragraph base = new Paragraph(signature);
            document.add(base);

        } catch (Exception e) {
            e.printStackTrace();
        }
        document.close();
        
        File file = new File("ReportDate_certif_"+reportDate+".pdf");
        
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
   void vider(ActionEvent event) throws SQLException, IOException {
             Alert Atc=new Alert(Alert.AlertType.CONFIRMATION);
            Atc.setHeaderText("Supprimer Tout");
            Atc.setContentText("Voulez vous vider supprimer tout les donnee des certifications ?!");
            ButtonType V = new ButtonType("Vider");
            ButtonType q = new ButtonType("quiter");
            
            Atc.getButtonTypes().clear();
            Atc.getButtonTypes().addAll(V,q);
           
            Optional<ButtonType> option = Atc.showAndWait();

            if (option.get() == V) {   
                N_Services_Certification nsc=new N_Services_Certification();
                nsc.vider();
        
            }
}

    @FXML
    private void Browser(MouseEvent event) throws URISyntaxException, IOException {
                Desktop.getDesktop().browse(new URI("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1"));

    }

    @FXML
    private void affecter_certif(ActionEvent event) throws IOException {
          int index;
       index =  N_Tab_aff_certif.getSelectionModel().getSelectedIndex();
       
       if(index <= -1){
          
            return;
       }
   
    co1.setId(id.getCellData(index).intValue());
    co1.setTitreCours(titrec.getCellData(index).toString());
    co1.setTitreTest(titret.getCellData(index).toString());
    co1.setDateAjout(datea.getCellData(index).toString());
    co1.setLien(lien.getCellData(index).toString());
    
    if(co1.getId()!=0)
    {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Affecter_Certification.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }
    }
    
   
       
   
 
}