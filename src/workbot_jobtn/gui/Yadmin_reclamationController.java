/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbot_jobtn.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import workbot_jobtn.entites.Categorie;
import workbot_jobtn.entites.Reclamation;
import workbot_jobtn.services.ServiceCategorie;
import workbot_jobtn.services.ServiceReclamation;

/**
 * FXML Controller class
 *
 * @author youcef
 */
public class Yadmin_reclamationController implements Initializable {
    ServiceCategorie serv=new ServiceCategorie();
    ServiceReclamation serv2=new ServiceReclamation();
    Reclamation rec= new Reclamation();
    Categorie cat=new Categorie();
    Categorie cat1=new Categorie();
    private Stage stage;
    private Scene scene;
    private Parent root;
    private final ObservableList<Reclamation> list = FXCollections.observableArrayList();
    private final ObservableList<Categorie> listc = FXCollections.observableArrayList();

    @FXML
    private TableView<Reclamation> table_reclamation;
    @FXML
    private TableColumn<Reclamation, Integer> col_id;
    @FXML
    private TableColumn<Reclamation, String>col_objet;
    @FXML
    private TableColumn<Reclamation, String> col_date;
    @FXML
    private TableColumn<Reclamation, String> col_description;
    @FXML
    private TableColumn<Reclamation, String> col_categorie;
    @FXML
    private TableColumn<Reclamation, String> col_image;
    @FXML
    private TableColumn<Reclamation, String> col_etat;
    @FXML
    private TextField tf_recherche;
    @FXML
    private ImageView recherchericon;
    @FXML
    private ImageView retouricon;
    @FXML
    private ImageView refreshicon;
    @FXML
    private ImageView iv_imagea;
    @FXML
    private Label lab_description;
    @FXML
    private Label lab_titre;
    @FXML
    private Label lab_date;
    @FXML
    private Label lab_categorie;
    @FXML
    private Label lab_etat;
    @FXML
    private Label etat_encours;
    @FXML
    private Label etat_traite;
    @FXML
    private Label etat_envoye;
    @FXML
    private Label cat_tech;
    @FXML
    private Label cat_offre;
    @FXML
    private Pane pane_affichage;
    @FXML
    private Label lab_reference;
    @FXML
    private Button bt_traitee;
    @FXML
    private AnchorPane anchor_reclamation;
    @FXML
    private AnchorPane anchor_categorie;
    @FXML
    private TableView<Categorie> table_categorie;
    @FXML
    private TableColumn<Categorie, Integer> col_idcat;
    @FXML
    private TableColumn<Categorie, String> col_nom_categorie;
    @FXML
    private Pane pane_affichage1;
    @FXML
    private Button bt_ajouter;
    @FXML
    private TextField tf_nomCategorie;
    @FXML
    private Button bt_supprimer;
    @FXML
    private Button bt_modifier;
    @FXML
    private Button categories;
    @FXML
    private ImageView refreshiconc;
    @FXML
    private Button bt_annuler;
    @FXML
    private Label champ_obligatoire;
    @FXML
    private Button M_listclientLS;
    @FXML
    private Button Stat;
    @FXML
    private Button M_logoutLAid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showReclamations();
        showCategories();
    }    

    public void showReclamations(){
        
        try {
            list.clear();
            ObservableList<Reclamation> liste = serv2.afficherTout();//we statically set the client id to just show his reclamations
            list.setAll(liste);                       
            col_date.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("date"));
            col_id.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("id"));
            col_objet.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("objet"));
            col_description.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("description"));
            col_image.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("image"));
            col_categorie.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nomCat"));
            col_etat.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("etat"));            
            table_reclamation.setItems(list);
            etat_envoye.setText(Integer.toString(serv2.countEnvoyer()));
            etat_encours.setText(Integer.toString(serv2.countEnCour()));
            etat_traite.setText(Integer.toString(serv2.countTraitee()));
            cat_tech.setText(Integer.toString(serv2.countTechnique()));
            cat_offre.setText(Integer.toString(serv2.countOffre()));
        } catch (SQLException ex) {
        }
        
    }
    @FXML
    private void lineselected(MouseEvent event) throws SQLException {
        iv_imagea.setImage(null);
        pane_affichage.setVisible(true);
        
        if(table_reclamation.getSelectionModel().getSelectedIndex()>=0){
        rec = table_reclamation.getItems().get(table_reclamation.getSelectionModel().getSelectedIndex());
        if(rec.getEtat().equals("envoyée")){
            serv2.modifier_etat_enCour(rec);
            showReclamations();
            bt_traitee.setDisable(false);
            bt_traitee.setVisible(true);
            lab_etat.setText("en cours de traitement");
            //mail******************************************************************
        }
        else if(rec.getEtat().equals("en cours de traitement")){
            bt_traitee.setDisable(false);
            bt_traitee.setVisible(true);
            lab_etat.setText(rec.getEtat());
        }
        else{
            bt_traitee.setVisible(false);
            lab_etat.setText(rec.getEtat());
        }
        lab_titre.setText(rec.getObjet());
        lab_description.setText(rec.getDescription());
        lab_date.setText(rec.getDate());
        lab_categorie.setText(rec.getNomCat());
        lab_reference.setText(Integer.toString(rec.getId()));
        if(rec.getImage()!=null && !rec.getImage().equals("") && rec.getImage().startsWith("f"))
        {
        Image image = new Image(rec.getImage());
        iv_imagea.setImage(image);
        }
        }
        else{
            pane_affichage.setVisible(false);
        }
    }

    @FXML
    private void rechercher(ActionEvent event) throws SQLException {
            list.clear();
            rec = serv2.afficher(Integer.parseInt(tf_recherche.getText()));//we statically set the client id to just show his reclamations
            list.setAll(rec);  
            col_date.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("date"));
            col_id.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("id"));
            col_objet.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("objet"));
            col_description.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("description"));
            col_image.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("image"));
            col_categorie.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nomCat"));
            col_etat.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("etat"));
            table_reclamation.setItems(list);
            retouricon.setVisible(true);
            rec=null;
            pane_affichage.setVisible(false);
    }

    @FXML
    private void recherchericon(MouseEvent event) throws SQLException {
            list.clear();
            rec = serv2.afficher(Integer.parseInt(tf_recherche.getText()));//we statically set the client id to just show his reclamations
            list.setAll(rec);  
            col_date.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("date"));
            col_id.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("id"));
            col_objet.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("objet"));
            col_description.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("description"));
            col_image.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("image"));
            col_categorie.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nomCat"));
            col_etat.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("etat"));
            table_reclamation.setItems(list);
            retouricon.setVisible(true);
            rec=null;
            pane_affichage.setVisible(false);
    }

    @FXML
    private void retouricon(MouseEvent event) {
        showReclamations();
        retouricon.setVisible(false);
        tf_recherche.setText("");
        pane_affichage.setVisible(false);
    }

    @FXML
    private void refreshricon(MouseEvent event) {
        try {
            list.clear();
            ObservableList<Reclamation> liste = serv2.afficherTout();//we statically set the client id to just show his reclamations
            list.setAll(liste);
            col_date.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("date"));
            col_id.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("id"));
            col_objet.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("objet"));
            col_description.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("description"));
            col_image.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("image"));
            col_categorie.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nomCat"));
            col_etat.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("etat"));            
            table_reclamation.setItems(list);
            pane_affichage.setVisible(false);
        } catch (SQLException ex) {
        }
    }


    @FXML
    private void traitee(ActionEvent event) throws SQLException {
            serv2.modifier_etat_traitee(rec);
            showReclamations();
            bt_traitee.setDisable(true);
            lab_etat.setText("traitée");
            //mail *************************************************************
    }
    

    @FXML
    private void Onclicked_categories(ActionEvent event) {
        anchor_categorie.setVisible(true);
        anchor_reclamation.setVisible(false);
        showCategories();
        tf_nomCategorie.setText("");
        bt_modifier.setVisible(false);
        bt_supprimer.setVisible(false);
        bt_annuler.setVisible(false);
        bt_ajouter.setVisible(true);
    }

    private void Onclicked_reclamations(ActionEvent event) {
        anchor_categorie.setVisible(false);
        anchor_reclamation.setVisible(true);
        try {
            list.clear();
            ObservableList<Reclamation> liste = serv2.afficherTout();//we statically set the client id to just show his reclamations
            list.setAll(liste);
            col_date.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("date"));
            col_id.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("id"));
            col_objet.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("objet"));
            col_description.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("description"));
            col_image.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("image"));
            col_categorie.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nomCat"));
            col_etat.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("etat"));            
            table_reclamation.setItems(list);
            pane_affichage.setVisible(false);
        } catch (SQLException ex) {
        }
    }
    
    public void showCategories(){
    try {
            listc.clear();
            ObservableList<Categorie> listec = serv.afficherTout();
            listc.setAll(listec);                       
            col_idcat.setCellValueFactory(new PropertyValueFactory<Categorie, Integer>("id"));
            col_nom_categorie.setCellValueFactory(new PropertyValueFactory<Categorie, String>("nomCategorie"));            
            table_categorie.setItems(listc);
        } catch (SQLException ex) {
        }
    }


    @FXML
    private void Onclicked_bt_ajouter(ActionEvent event) throws SQLException {
        if(tf_nomCategorie.getText().equals("")){
            champ_obligatoire.setVisible(true);
        }
        else{
        champ_obligatoire.setVisible(false);
        cat1.setNomCategorie(tf_nomCategorie.getText());
        serv.ajouter(cat1);
        tf_nomCategorie.setText("");
        showCategories();
        }
    }

    @FXML
    private void Onclicked_bt_supprimer(ActionEvent event) throws SQLException {
        serv.supprimer(cat);
        champ_obligatoire.setVisible(false);
        tf_nomCategorie.setText("");
        bt_modifier.setVisible(false);
        bt_supprimer.setVisible(false);
        bt_annuler.setVisible(false);
        bt_ajouter.setVisible(true);
        showCategories();
    }

    @FXML
    private void Onclicked_bt_modifier(ActionEvent event) throws SQLException {
        if(tf_nomCategorie.getText().equals("")){
            champ_obligatoire.setVisible(true);
        }
        else{
        champ_obligatoire.setVisible(false);
        cat.setNomCategorie(tf_nomCategorie.getText());
        serv.modifier(cat);
        tf_nomCategorie.setText("");
        bt_modifier.setVisible(false);
        bt_supprimer.setVisible(false);
        bt_annuler.setVisible(false);
        bt_ajouter.setVisible(true);
        showCategories();
        }
    }

    @FXML
    private void lineselectedc(MouseEvent event) {
        if(table_categorie.getSelectionModel().getSelectedIndex()>=0){
        cat = table_categorie.getItems().get(table_categorie.getSelectionModel().getSelectedIndex());
        tf_nomCategorie.setText(cat.getNomCategorie());
        bt_modifier.setVisible(true);
        bt_supprimer.setVisible(true);
        bt_annuler.setVisible(true);
        champ_obligatoire.setVisible(false);
        bt_ajouter.setVisible(false);
    }
    }

    @FXML
    private void refreshriconc(MouseEvent event) {
        showCategories();
        tf_nomCategorie.setText("");
        champ_obligatoire.setVisible(false);
        bt_modifier.setVisible(false);
        bt_supprimer.setVisible(false);
        bt_annuler.setVisible(false);
        bt_ajouter.setVisible(true);
    }

    @FXML
    private void Onclicked_bt_annuler(ActionEvent event) {
        champ_obligatoire.setVisible(false);
        tf_nomCategorie.setText("");
        bt_modifier.setVisible(false);
        bt_supprimer.setVisible(false);
        bt_annuler.setVisible(false);
        bt_ajouter.setVisible(true);
    }

    @FXML
    private void On_reclamtion(ActionEvent event) throws IOException {
          Parent fXMLLoader = FXMLLoader.load(getClass().getResource("yadmin_reclamation.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }

    @FXML
    private void ListClient(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("M_ListClient.fxml"));

            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
    }

    @FXML
    private void M_statbutton(ActionEvent event) throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("M_Statistique.fxml"));

            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
    }

    @FXML
    private void cours_open(ActionEvent event) throws IOException {
             Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Home_Admin.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }

    @FXML
    private void M_logoutLAaction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("M_Login.fxml"));

            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
    }
    
}
