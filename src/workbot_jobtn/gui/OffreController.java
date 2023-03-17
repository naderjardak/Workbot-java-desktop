/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.io.IOException;
import static java.lang.String.valueOf;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import workbot_jobtn.entites.Offre;
import workbot_jobtn.services.OffreService;

/**
 * FXML Controller class
 *
 * @author Exon
 */
public class OffreController implements Initializable {

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
    private Pane s;
    @FXML
    private TextField inputsearch;
    @FXML
    private Button btnUser;
    @FXML
    private Button settings;
    @FXML
    private TableView<Offre> table;
    @FXML
    private TableColumn<Offre, String> OffreTab;
    @FXML
    private TableColumn<Offre, String> dateTab;
    @FXML
    private TableColumn<Offre, String> typeTab;
    @FXML
    private TableColumn<Offre, Button> totCandTab;
    @FXML
    private TableColumn<Offre, String> btnsTab;

    OffreService offreService = new OffreService();

    ObservableList<Offre> list = FXCollections.observableArrayList(offreService.readAll());
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnModif;
    @FXML
    private Button btnSupp;
    @FXML
    private Button fb;
    @FXML
    private Button fb1;
    @FXML
    private TableColumn<Offre, Integer> id_disabled;
    @FXML
    private TableColumn<Offre, String> testtab;

    /**
     * Initializes the controller class.
     *
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        OffreTab.setCellValueFactory(new PropertyValueFactory<>("titre"));
        dateTab.setCellValueFactory(new PropertyValueFactory<>("dateAjout"));
        typeTab.setCellValueFactory(new PropertyValueFactory<>("typeOffre"));
        id_disabled.setCellValueFactory(new PropertyValueFactory<>("id"));
        totCandTab.setCellValueFactory(new PropertyValueFactory<>("btn"));
        testtab.setCellValueFactory(new PropertyValueFactory<>("btn2"));

        // ObservableList<Offre> offreSelected=table.getSelectionModel().getSelectedItems();
        Callback<TableColumn<Offre, String>, TableCell<Offre, String>> cellFactory
                = //
                (final TableColumn<Offre, String> param) -> {
                    final TableCell<Offre, String> cell = new TableCell<Offre, String>() {

                final Button btn = new Button("Voir candidatures");

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {
                        btn.setOnAction(event -> {
                            Offre offre = getTableView().getItems().get(getIndex());
                            if (offreService.nbCandidature(offre.getId()) < 1) {
                                Alert Atc = new Alert(Alert.AlertType.WARNING);
                                Atc.setHeaderText("Erreur");
                                Atc.setContentText("Aucune candidature trouvée");
                                Atc.showAndWait();
                                return;
                            }

                            try {
                                //  ResourceBundle resources = ResourceBundle.getBundle("Language/lang_pt");

                                FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("CandOffre.fxml"));
                                Parent root = fXMLLoader.load();
                                CandOffreController liste = fXMLLoader.getController();
                                System.out.println(offre.getId());
                                liste.setId_offre(offre.getId());
                                System.out.println("2");

                                Scene stage = new Scene(root);

                                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                window.setScene(stage);
                                window.show();
                            } catch (IOException ex) {
                                Logger.getLogger(OffreController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        });
                        setGraphic(btn);
                        setText(null);
                    }
                }
            };
                    return cell;
                };
        btnsTab.setCellFactory(cellFactory);

        Callback<TableColumn<Offre, String>, TableCell<Offre, String>> cellFactory2
                = //
                (final TableColumn<Offre, String> param) -> {
                    final TableCell<Offre, String> cell = new TableCell<Offre, String>() {

                final Button btn2 = new Button("Modifier test");

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        btn2.setOnAction(event -> {
                            Offre offre = getTableView().getItems().get(getIndex());

                            try {
                                //  ResourceBundle resources = ResourceBundle.getBundle("Language/lang_pt");

                                FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("ModifTest.fxml"));
                                Parent root = fXMLLoader.load();
                                ModifTestController liste1 = fXMLLoader.getController();
                                System.out.println(offre.getId());
                                liste1.setId_offre(offre.getId());
                                System.out.println("2");

                                Scene stage = new Scene(root);

                                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                window.setScene(stage);
                                window.show();
                            } catch (IOException ex) {
                                Logger.getLogger(OffreController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        });
                        setGraphic(btn2);
                        setText(null);
                    }
                }
            };
                    return cell;
                };
        testtab.setCellFactory(cellFactory2);

        FilteredList<Offre> filteredList = new FilteredList<>(list, b -> true);

        inputsearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(Offre -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (Offre.getTitre().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<Offre> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(table.comparatorProperty());

        table.setItems(sortedList);
    }

    @FXML
    private void onClicked_menuOffre(ActionEvent event) {
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
        {

            Parent fXMLLoader = FXMLLoader.load(getClass().getResource("DisplayEntretiens.fxml"));
            Scene stage = new Scene(fXMLLoader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        }

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

    @FXML
    private void AjouterOffre(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("AjouterOffre.fxml"));
        Scene stage = new Scene(fXMLLoader);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }

    @FXML
    private void modifierOffre(ActionEvent event) throws IOException {
        ObservableList<Offre> offreSelected = table.getSelectionModel().getSelectedItems();
        String type = valueOf(offreSelected.get(0).getTypeOffre());
        if ("Emploi".equals(type)) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierOffreEmploi.fxml"));
            Parent root = loader.load();
            ModifierOffreEmploiController modifEmploi = loader.getController();

            System.out.println("id : " + offreSelected.get(0).getId());
            modifEmploi.setId(offreSelected.get(0).getId());
            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        }
        if ("Stage".equals(type)) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierOffreStage.fxml"));
            Parent root = loader.load();
            ModifierOffreStageController modifStage = loader.getController();

            System.out.println("id : " + offreSelected.get(0).getId());
            modifStage.setId(offreSelected.get(0).getId());
            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        }

        if ("Freelancer".equals(type)) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierOffreFreelancer.fxml"));
            Parent root = loader.load();
            ModifierOffreFreelancerController modifFreelancer = loader.getController();

            System.out.println("id : " + offreSelected.get(0).getId());
            modifFreelancer.setId(offreSelected.get(0).getId());
            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        }

    }

    @FXML
    private void supprimerOffre(ActionEvent event) {
        ObservableList<Offre> offreSelected = table.getSelectionModel().getSelectedItems();

        if (!offreSelected.isEmpty()) {

            Alert Atc = new Alert(Alert.AlertType.CONFIRMATION);
            Atc.setHeaderText("Alert");
            Atc.setContentText("Confirmerla suppression");
            Optional<ButtonType> result = Atc.showAndWait();
            if (result.get() == ButtonType.OK) {

                offreService.delete(offreSelected.get(0));
                ObservableList<Offre> list = FXCollections.observableArrayList(offreService.readAll());
                OffreTab.setCellValueFactory(new PropertyValueFactory<>("titre"));
                dateTab.setCellValueFactory(new PropertyValueFactory<>("dateAjout"));
                typeTab.setCellValueFactory(new PropertyValueFactory<>("modeTravail"));
                // nbTab.setCellValueFactory(new PropertyValueFactory<Offre,String>("titre"));

                FilteredList<Offre> filteredList = new FilteredList<>(list, b -> true);

                inputsearch.textProperty().addListener((observable, oldValue, newValue) -> {
                    filteredList.setPredicate(Offre -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lowerCaseFilter = newValue.toLowerCase();
                        if (Offre.getTitre().toLowerCase().contains(lowerCaseFilter)) {
                            return true;
                        } else {
                            return false;
                        }
                    });
                });

                SortedList<Offre> sortedList = new SortedList<>(filteredList);
                sortedList.comparatorProperty().bind(table.comparatorProperty());

                table.setItems(sortedList);
            } else {
                Atc.close();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Alert");
            alert.setContentText("Vous devez selectionnez une offre!!");
            Optional<ButtonType> result = alert.showAndWait();
        }

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
    private void Onclicked_fb(ActionEvent event) {
    }

}
