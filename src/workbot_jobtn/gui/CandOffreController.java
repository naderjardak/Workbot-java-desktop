/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import workbot_jobtn.entites.DTOCandidature_Offre;
import workbot_jobtn.services.OffreService;
import java.io.ByteArrayOutputStream;
import java.util.Optional;
import javafx.scene.control.ButtonType;
import net.glxn.qrgen.image.ImageType;
import net.glxn.qrgen.QRCode;

/**
 * FXML Controller class
 *
 * @author Exon
 */
public class CandOffreController implements Initializable {

    @FXML
    private HBox root;
    @FXML
    private VBox menu;
    @FXML
    private AnchorPane side_anker;
    @FXML
    private Button btnDashboard;
    @FXML
    private Button btnMenuOffre;
    @FXML
    private Button btnMenuEvent;
    @FXML
    private Button btnMenuEntretien;
    @FXML
    private Button fb;
    @FXML
    private Button fb1;
    @FXML
    private Pane s;
    @FXML
    private TextField inputsearch;
    @FXML
    private Button btnUser;
    @FXML
    private Button settings;
    @FXML
    private TableView<DTOCandidature_Offre> table;
    @FXML
    private TableColumn<DTOCandidature_Offre, String> NomCand;
    @FXML
    private TableColumn<DTOCandidature_Offre, String> emailCand;
    @FXML
    private TableColumn<DTOCandidature_Offre, String> NoteTest;
    @FXML
    private TableColumn<DTOCandidature_Offre, String> actionTest;
    @FXML
    private TableColumn<DTOCandidature_Offre, String> statut;
    @FXML
    private TableColumn<DTOCandidature_Offre, String> actionStatut;
    @FXML
    private TableColumn<DTOCandidature_Offre, String> dateAjout;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnSupp;
    @FXML
    private Label offreLab;

    OffreService offreService = new OffreService();
    int id_passed;

//     int idOff=Integer.parseInt(offreLab.getText());
    @FXML
    private Pane test;
    int id2;

    public void setId_offre(int id) {

        ObservableList<DTOCandidature_Offre> list = offreService.candidatures_Offre(id);
        id2 = id;
        displaytabview(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void displaytabview(ObservableList<DTOCandidature_Offre> list) {
        NomCand.setCellValueFactory(new PropertyValueFactory<>("nomCandidat"));
        emailCand.setCellValueFactory(new PropertyValueFactory<>("email"));
        //NoteTest.setCellValueFactory(new PropertyValueFactory<>("noteTest"));
        actionTest.setCellValueFactory(new PropertyValueFactory<>("noteTest"));
        statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        // actionStatut.setCellValueFactory(new PropertyValueFactory<>("button"));
        dateAjout.setCellValueFactory(new PropertyValueFactory<>("dateAjout"));

        // nbTab.setCellValueFactory(new PropertyValueFactory<Offre,String>("dateAjout"));
        /*   Callback<TableColumn<DTOCandidature_Offre, String>, TableCell<DTOCandidature_Offre, String>> cellFactory
                =                 //
       (final TableColumn<DTOCandidature_Offre, String> param) -> {
           final TableCell<DTOCandidature_Offre, String> cell = new TableCell<DTOCandidature_Offre, String>() {
               
               final Button btn = new Button("Noter");
               
               @Override
               public void updateItem(String item, boolean empty) {
                   super.updateItem(item, empty);
                   if (empty) {
                       setGraphic(null);
                       setText(null);
                   } else {
                       btn.setOnAction(event -> {
                         
                           
                       });
                       setGraphic(btn);
                       setText(null);
                   }
               }
           };
           return cell;
       };
              actionTest.setCellFactory(cellFactory);*/
        Callback<TableColumn<DTOCandidature_Offre, String>, TableCell<DTOCandidature_Offre, String>> cellFactory2
                = //
                (final TableColumn<DTOCandidature_Offre, String> param) -> {
                    final TableCell<DTOCandidature_Offre, String> cell = new TableCell<DTOCandidature_Offre, String>() {

                final Button btn = new Button("Entretien");

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        btn.setOnAction(event -> {
                            try {
                                DTOCandidature_Offre Offre = getTableView().getItems().get(getIndex());
                                // ObservableList<DTOCandidature_Offre> offreSelected=table.getSelectionModel().getSelectedItems();
                                //  DTOCandidature_Offre candOffre=offreService.candidatures_Offre(offreSelected.get(0).getId_off()).get(0);
                              dto=Offre;
                                System.out.println(dto.getId_cand()+"entrein!!!!!!!!!!!!!!!!!!!!!!!");
                                //ouvrir une nouv interface pour proposer une date d'entretien(datepicker)
                                FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Entretien.fxml"));
                                Parent root = fXMLLoader.load();
                                EntretienController entretienController = fXMLLoader.getController();
                                entretienController.setId(Offre.getId_off());
                                entretienController.setIdCandidature(Offre.getId_cand());
                                Scene scene = new Scene(root);
                                Stage stage = new Stage();

                                stage.setScene(scene);
                                stage.show();
                            } catch (IOException ex) {
                                Logger.getLogger(CandOffreController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                        );
                        setGraphic(btn);
                        setText(null);
                    }
                }
            };
                    return cell;
                };
        actionStatut.setCellFactory(cellFactory2);

        Callback<TableColumn<DTOCandidature_Offre, String>, TableCell<DTOCandidature_Offre, String>> cellFactory3
                = //
                (final TableColumn<DTOCandidature_Offre, String> param) -> {
                    final TableCell<DTOCandidature_Offre, String> cell = new TableCell<DTOCandidature_Offre, String>() {

                final TextField btn = new TextField();

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        btn.setOnKeyTyped(event -> {
                            DTOCandidature_Offre Offre = getTableView().getItems().get(getIndex());
                            if (btn.getText().length() == 2) {
                                Offre.setNoteTest(btn.getText());
                                offreService.updateNoteTest(Offre);
                                ObservableList<DTOCandidature_Offre> list = offreService.candidatures_Offre(id2);
                                NomCand.setCellValueFactory(new PropertyValueFactory<>("nomCandidat"));
                                emailCand.setCellValueFactory(new PropertyValueFactory<>("email"));
                                //NoteTest.setCellValueFactory(new PropertyValueFactory<>("noteTest"));
                                actionTest.setCellValueFactory(new PropertyValueFactory<>("noteTest"));
                                statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
                                // actionStatut.setCellValueFactory(new PropertyValueFactory<>("button"));
                                dateAjout.setCellValueFactory(new PropertyValueFactory<>("dateAjout"));
                                actionTest.setCellValueFactory(new PropertyValueFactory<>("noteTest"));
                                FilteredList<DTOCandidature_Offre> filteredList = new FilteredList<>(list, b -> true);

                                inputsearch.textProperty().addListener((observable, oldValue, newValue) -> {
                                    filteredList.setPredicate(Offre1 -> {
                                        if (newValue == null || newValue.isEmpty()) {
                                            return true;
                                        }
                                        String lowerCaseFilter = newValue.toLowerCase();
                                        if (Offre1.getNomCandidat().toLowerCase().contains(lowerCaseFilter)) {
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    });
                                });

                                SortedList<DTOCandidature_Offre> sortedList = new SortedList<>(filteredList);
                                sortedList.comparatorProperty().bind(table.comparatorProperty());

                                table.setItems(sortedList);
                            }
                            if (btn.getText().length() > 2) {
                                Alert error = new Alert(Alert.AlertType.WARNING);
                                error.setHeaderText("Alert");
                                error.setContentText("erreur");
                                error.showAndWait();
                                return;
                            }
                        });
                        setGraphic(btn);
                        setText(null);
                    }
                }
            };
                    return cell;
                };
        NoteTest.setCellFactory(cellFactory3);

        FilteredList<DTOCandidature_Offre> filteredList = new FilteredList<>(list, b -> true);

        inputsearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(Offre -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (Offre.getNomCandidat().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<DTOCandidature_Offre> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(table.comparatorProperty());

        table.setItems(sortedList);

    }

    @FXML
    private void onclick_dash(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("HomeSociete.fxml"));
        Scene stage = new Scene(fXMLLoader);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }

    @FXML
    private void onClicked_menuOffre(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("Offre.fxml"));
        Scene stage = new Scene(fXMLLoader);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }

    @FXML
    private void OnClicked_menuEvent(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("firstevent.fxml"));
        Scene stage = new Scene(fXMLLoader);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }

    @FXML
    private void OnClicked_menuEntretiens(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("DisplayEntretiens.fxml"));
        Scene stage = new Scene(fXMLLoader);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }

    @FXML
    private void Onclicked_fb(ActionEvent event) {
    }

    @FXML
    private void onKeyRealeased_showSearchPropositions(KeyEvent event) {
    }

    @FXML
    private void OnClick_UserIcon(ActionEvent event) {
    }

    @FXML
    private void OnClick_settings(ActionEvent event) {
    }
    
    public static DTOCandidature_Offre dto=new DTOCandidature_Offre();

    @FXML
    private void AjouterOffre(ActionEvent event) throws IOException {

         ObservableList<DTOCandidature_Offre> offreSelected = table.getSelectionModel().getSelectedItems();
        if (!offreSelected.isEmpty()) {
            dto=offreSelected.get(0);
             if(dto.getStatut().equals("Acceptée")){
                  Alert alert2 = new Alert(Alert.AlertType.WARNING);
            alert2.setHeaderText("Erreur");
            alert2.setContentText("Vous avez deja accepté ce candidat");
            alert2.showAndWait();return;
                  }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Confirmation");
            alert.setContentText("Vous êtes sur le point d'embaucher ce candidat! Confirmer?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
       
       
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("ContratCreation.fxml"));
                                Parent root = fXMLLoader.load();
                                Scene scene = new Scene(root);
                                Stage stage = new Stage();
                                     stage.setScene(scene);
                                stage.show();
        
                
              
            } else {
                alert.close();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERREUR");
            alert.setContentText("Vous devez selectionnez un candidat");
            alert.showAndWait();

        }

    }

    @FXML
    private void supprimerOffre(ActionEvent event) throws FileNotFoundException, IOException {

        ObservableList<DTOCandidature_Offre> offreSelected = table.getSelectionModel().getSelectedItems();
        DTOCandidature_Offre dto = offreSelected.get(0);
        String detailsCand = "Nom du Candidat :" + dto.getNomCandidat() + " Email du candidat :" + dto.getEmail() + " Note Test :" + dto.getNoteTest();
        ByteArrayOutputStream out = QRCode.from(detailsCand).to(ImageType.PNG).stream();
        File f = new File("C:\\PDFapi\\QRgenerator.PNG");

        FileOutputStream fos = new FileOutputStream(f);
        fos.write(out.toByteArray());
        fos.flush();
        fos.close();
        Desktop.getDesktop().open(new File("C:\\PDFapi\\QRgenerator.PNG"));
    }

}
