/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbot_jobtn.gui;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Header;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import workbot_jobtn.services.CondidatureService;
import workbot_jobtn.services.ContratService;
import workbot_jobtn.entites.Candidature;
import workbot_jobtn.entites.Contrat;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import workbot_jobtn.entites.DTOCandidature_Offre;
import static workbot_jobtn.gui.CandOffreController.dto;
import workbot_jobtn.services.OffreService;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class ContratCreationController implements Initializable {
private Label label;
    @FXML
    private DatePicker datedebut;
    @FXML
    private DatePicker debutfin;
    @FXML
    private ComboBox<String> inputtypecontrat;
    @FXML
    private TextField inputsalaire;
    private TextField inputlien;
    @FXML
    private Button ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inputtypecontrat.getItems().addAll("Stage", "Alternance", "CDD", "CDI");

    }
            OffreService offreService=new OffreService();

    @FXML
    private void insert(ActionEvent event) throws IOException, SQLException {
        ContratService productService = new ContratService();
 System.out.println(inputsalaire.getText().matches("[0-9.]"));

        if (inputsalaire.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Veuillez saisir tous les champs ");
            a.setHeaderText(null);
            a.showAndWait();
        } 
        
        else if(!inputsalaire.getText().matches("[0-9.]+")==true) {
            
                    Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("le salaire doit etre un nombre ");
            a.setHeaderText(null);
            a.showAndWait();
            
        }
        else {
            // Date Ajourd'hui
            Date date = new Date(System.currentTimeMillis());
            java.sql.Date sqlDate2 = new java.sql.Date(date.getTime());

            //date debut 
            java.util.Date date2 = java.util.Date.from(this.datedebut.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDatedebut = new java.sql.Date(date2.getTime());

            //date fin
            java.util.Date date3 = java.util.Date.from(this.debutfin.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDateFin = new java.sql.Date(date3.getTime());
                        
            DTOCandidature_Offre candOffre = offreService.candidatures_Offre(dto.getId_off()).get(0);

            Contrat ccc = new Contrat(inputtypecontrat.getValue(), sqlDatedebut, inputsalaire.getText(),
                    sqlDateFin, "C:\\PDFapi\\" + candOffre.getId_cand() + ".pdf", dto.getId_cand(), sqlDate2
            );

            
            
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Confirmer ");
      alert.setHeaderText("Confirmer");
      alert.setContentText(" ");
            Optional<ButtonType> option = alert.showAndWait();

      if (option.get() == null) {
       
      } else if (option.get() == ButtonType.OK) {
          productService.AjouterContrat(ccc);
          
                TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.SLIDE;
            tray.setAnimationType(type);
            tray.setTitle("Contrat ajouté avec succées");
            tray.setMessage("Contrat ajouté avec succées");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
                Document doc = new Document();
                try {
                    PdfWriter.getInstance(doc, new FileOutputStream("C:\\PDFapi\\" + candOffre.getId_cand() + ".pdf"));
                    doc.open();

                    doc.add(new Header("Contrat", "Contrat"));
                    doc.add(new Paragraph("Contrat"));
                    Image image1 = Image.getInstance(getClass().getResource("temp.png"));
                    image1.scaleToFit(2000, 840);
                    image1.setAbsolutePosition(0f, 450f);
                    doc.add(image1);
                    PdfPTable table1 = new PdfPTable(4);
                    table1.setWidthPercentage(100);
                    /////////////////////////////
                    PdfPCell cell;

                    ////////////
                    cell = new PdfPCell(new Phrase("Nom", FontFactory.getFont("arial")));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GRAY);
                    table1.addCell(cell);

                    cell = new PdfPCell(new Phrase("Email", FontFactory.getFont("arial")));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GRAY);
                    table1.addCell(cell);

                    cell = new PdfPCell(new Phrase("Poste", FontFactory.getFont("arial")));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GRAY);
                    table1.addCell(cell);

                    cell = new PdfPCell(new Phrase("Salaire", FontFactory.getFont("arial")));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GRAY);
                    table1.addCell(cell);

                    cell = new PdfPCell(new Phrase(candOffre.getNomCandidat(), FontFactory.getFont("arial")));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);

                    table1.addCell(cell);

                    cell = new PdfPCell(new Phrase(candOffre.getEmail(), FontFactory.getFont("arial")));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);

                    table1.addCell(cell);

                    cell = new PdfPCell(new Phrase(candOffre.getTitreOffre(), FontFactory.getFont("arial")));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);

                    table1.addCell(cell);

                    cell = new PdfPCell(new Phrase(candOffre.getSalaire(), FontFactory.getFont("arial")));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);

                    table1.addCell(cell);

                    doc.add(table1);

                    doc.close();
                    Desktop.getDesktop().open(new File("C:\\PDFapi\\" + candOffre.getId_cand() + ".pdf"));

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CandOffreController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(CandOffreController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(CandOffreController.class.getName()).log(Level.SEVERE, null, ex);
                }
          
                dto.setStatut("Acceptée");
                offreService.updateStatut(dto);
                
           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.close();
       
      } else if (option.get() == ButtonType.CANCEL) {
      
      } else {
         this.label.setText("-");
      }
            
            
            
            
            

          

        };

    }

    private void prec(ActionEvent event) throws IOException {
        
               Parent page1 = FXMLLoader.load(getClass().getResource("ContratList.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }

}
