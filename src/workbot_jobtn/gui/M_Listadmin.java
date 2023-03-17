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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;
import workbot_jobtn.entites.User;

import workbot_jobtn.utils.MyDB;

/**
 *
 * @author fnmoh
 */
public class M_Listadmin implements Initializable {

    @FXML
    private Button M_supprimer;

    @FXML
    private Button M_ImprimerLa;

    @FXML
    private TextField M_rechercheLA;

    @FXML
    private Button M_modifier;

    @FXML
    private TableView<User> M_tableLCC;

    @FXML
    private TableColumn<User, Integer> M_idLC;

    @FXML
    private TableColumn<User, String> M_prenomLC;

    @FXML
    private TableColumn<User, String> M_nomLC;

    @FXML
    private TableColumn<User, String> M_emailLC;

    @FXML
    private TableColumn<User, String> m_passwordLC;

    @FXML
    private TextField M_id;

    @FXML
    private TextField M_nomLCtextfuild;

    @FXML
    private TextField M_prenomLCtextfuild;

    @FXML
    private TextField M_mailLCtextfuild;

    @FXML
    private Button M_logoutLAid;

    @FXML
    private Button M_ajouter;

    @FXML
    private TextField M_passwordLCtextfuild;

    @FXML
    private Button M_listclientLS;
    @FXML
    private Button M_actualiser;
    @FXML
    private Button Stat;

    public void initialize(URL url, ResourceBundle rb) {
        showAdmin();
        M_rechercheL();
    }

    @FXML
    void Add(ActionEvent event) throws SQLException {
        if (event.getSource() == M_ajouter) {

            insertRecord();

        }

    }

    void M_rechercheL() {
        ObservableList<User> list = getAdminList();

        showAdmin();

        FilteredList<User> filteredData = new FilteredList<>(list, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        M_rechercheLA.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(admin -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (admin.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter prenom.
                } else if (admin.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter nom.
                } else if (String.valueOf(admin.getEmail()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(admin.getMdp()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false; // Does not match.
                }
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<User> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(M_tableLCC.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        M_tableLCC.setItems(sortedData);

    }

    @FXML
    void Delete(ActionEvent event) {
        if (event.getSource() == M_supprimer) {
            deleteButton();
            M_rechercheL();
        }
    }

    @FXML
    void Update(ActionEvent event) {
        if (event.getSource() == M_modifier) {
            updateRecord();
            M_rechercheL();
        }
    }

    int index = -1;

    ////////select user ////////
    @FXML
    void getSelected(MouseEvent event) {
        index = M_tableLCC.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        M_id.setText(M_idLC.getCellData(index).toString());
        M_nomLCtextfuild.setText(M_nomLC.getCellData(index).toString());
        M_prenomLCtextfuild.setText(M_prenomLC.getCellData(index).toString());
        M_mailLCtextfuild.setText(M_emailLC.getCellData(index).toString());
        M_passwordLCtextfuild.setText(m_passwordLC.getCellData(index).toString());

    }

    @FXML
    void actualiserLCC(ActionEvent event) {
        showAdmin();
        M_rechercheL();
    }

    ////////////
    private Connection on;
    private Statement ste;

    public M_Listadmin() {
        on = MyDB.getInstance().getConnection();
    }
    String role = "Admin";

    public ObservableList<User> getAdminList() {
        ObservableList<User> adminList = FXCollections.observableArrayList();

        String query = "SELECT * FROM utilisateur where role ='Admin' ";
        Statement st;
        ResultSet rs;
        try {
            st = on.createStatement();
            rs = st.executeQuery(query);
            User user;
            while (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("prenom"), rs.getString("nom"), rs.getString("email"), rs.getString("mdp"));
                adminList.add(user);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return adminList;

    }
///////////////////////////////////////

////////////////////////////////////////
    public void showAdmin() {
        ObservableList<User> list = getAdminList();

        M_idLC.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        M_nomLC.setCellValueFactory(new PropertyValueFactory<User, String>("prenom"));
        M_prenomLC.setCellValueFactory(new PropertyValueFactory<User, String>("nom"));
        M_emailLC.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        m_passwordLC.setCellValueFactory(new PropertyValueFactory<User, String>("mdp"));

        M_tableLCC.setItems(list);

    }

    ////////////////////////////////////////////
    private void insertRecord() throws SQLException {

        String email = null;
        String queryy = "select email from utilisateur where email='" + M_mailLCtextfuild.getText() + "'";
        on = MyDB.getInstance().getConnection();
        PreparedStatement smt = on.prepareStatement(queryy);
        ResultSet rs = smt.executeQuery();
        while (rs.next()) {
            email = rs.getString("email");
        }

        if (M_prenomLCtextfuild.getText().isEmpty()
                | M_nomLCtextfuild.getText().isEmpty()
                | M_mailLCtextfuild.getText().isEmpty()
                | M_passwordLCtextfuild.getText().length() < 8) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Job Tn :: Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Verifier fields !!");
            alert.showAndWait();
        } /*
      else if (email.equals(M_mailLCtextfuild.getText())==true){
         
          Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Job Tn :: Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Verifier email  !!");
                alert.showAndWait();
      }
         */ else {
            /*
        M_prenomLCtextfuild.setText(u.getPrenom());
        M_nomLCtextfuild.setText(u.getNom());
        M_mailLCtextfuild.setText(u.getEmail());
        M_passwordLCtextfuild.setText(u.getMdp());
          M_AdminService mds= new M_AdminService ();
             */
 /*
          description.setText(r.getDescriptionR());
             */
String rolea ="[\"ROLE_a\"]";
String i = BCrypt.hashpw(M_passwordLCtextfuild.getText(), BCrypt.gensalt());
            String query = "INSERT INTO utilisateur (prenom,nom,email,mdp,role,roles) VALUES ('" + M_prenomLCtextfuild.getText() + "','" + M_nomLCtextfuild.getText() + "','" + M_mailLCtextfuild.getText() + "','"
                    + i + "','" + role + "','" + rolea + "')";

            executeQuery(query);
            showAdmin();;
        }

    }

    ///////////////////////////////////////////
    private void executeQuery(String query) {
        Statement st;
        try {
            st = on.createStatement();
            st.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //////////////////////////////////////////
    String prenom;

    private void deleteButton() {
        if (M_prenomLCtextfuild.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Job Tn :: Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Verifier l'operation !!");
            alert.showAndWait();
        } else {
            String query = "DELETE FROM utilisateur WHERE id =" + M_id.getText() + "";
            executeQuery(query);
            showAdmin();
        }
    }
    ///////////////////////////////////

    private void updateRecord() {
        if (M_prenomLCtextfuild.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Job Tn :: Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Verifier l'operation !!");
            alert.showAndWait();
        } else {
            String query = "UPDATE  utilisateur SET id =" + M_id.getText() + ",prenom = '" + M_prenomLCtextfuild.getText() + "', nom = '" + M_nomLCtextfuild.getText() + "', email = '"
                    + M_mailLCtextfuild.getText() + "', mdp = '" + M_passwordLCtextfuild.getText() + "' WHERE id = " + M_id.getText() + " ";
            executeQuery(query);
            showAdmin();
        }
    }
    //////////////////////////////////////////////////////////////

    @FXML
    void ListClient(ActionEvent event) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("M_ListClient.fxml"));

            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    ////////////////////////
    @FXML
    void M_logoutLAaction(ActionEvent event) {
        /*
          
         */
        try {

            Parent root = FXMLLoader.load(getClass().getResource("M_Login.fxml"));

            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //////////////////////
    @FXML
    void M_ImprimerLA(ActionEvent event) throws IOException, SQLException {
        Document doc = new Document();

        String query = "Select * from utilisateur";

        Statement st;
        ResultSet rs;

        try {
            st = on.createStatement();
            rs = st.executeQuery(query);

            PdfWriter.getInstance(doc, new FileOutputStream("C:\\pdfMohsen\\admin.pdf"));
            doc.open();

            Image img = Image.getInstance("C:\\pdfMohsen\\logo.png");
            img.scaleAbsoluteWidth(100);
            img.scaleAbsoluteHeight(100);
            img.setAlignment(Image.ALIGN_CENTER);

            doc.add(img);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Liste Admin"));
            doc.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            /////////////////////////////
            PdfPCell cell;

            ////////////
            cell = new PdfPCell(new Phrase("Prenom", FontFactory.getFont("arial")));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Nom", FontFactory.getFont("arial")));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Email", FontFactory.getFont("arial")));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Password", FontFactory.getFont("arial")));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);

            //////////////////////////////////////
            while (rs.next()) {
                cell = new PdfPCell(new Phrase(rs.getString("prenom").toString(), FontFactory.getFont("arial")));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);

                table.addCell(cell);

                cell = new PdfPCell(new Phrase(rs.getString("nom").toString(), FontFactory.getFont("arial")));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);

                table.addCell(cell);

                cell = new PdfPCell(new Phrase(rs.getString("email").toString(), FontFactory.getFont("arial")));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);

                table.addCell(cell);

                cell = new PdfPCell(new Phrase(rs.getString("mdp").toString(), FontFactory.getFont("arial")));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);

                table.addCell(cell);
            }

            ////////////////////////         
            doc.add(table);

            doc.close();
            Desktop.getDesktop().open(new File("C:\\pdfMohsen\\admin.pdf"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(M_Listadmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(M_Listadmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //////////////////////
    @FXML
    private void M_statbutton(ActionEvent event) {
        /*
       
         */
        try {

            Parent root = FXMLLoader.load(getClass().getResource("M_Statistique.fxml"));

            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    private void On_reclamtion(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("yadmin_reclamation.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }

}
