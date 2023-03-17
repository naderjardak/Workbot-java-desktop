/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbot_jobtn.gui;

import com.itextpdf.text.BadElementException;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import workbot_jobtn.entites.Candidat;
import workbot_jobtn.entites.User;
import workbot_jobtn.utils.MyDB;

/**
 *
 * @author fnmoh
 */
public class M_Listclient implements Initializable {

    @FXML
    private TextField M_id;

    @FXML
    private TableColumn<User, Integer> colid;
    @FXML
    private Button M_listclientLS;
    @FXML
    private TableView<User> M_tableLC;
    @FXML
    private TableColumn<User, String> M_roleLCC;
    @FXML
    private TableColumn<User, String> M_preLCC;
    @FXML
    private TableColumn<User, String> M_nomLCC;
    @FXML
    private TableColumn<User, String> M_emailLCC;
    @FXML
    private TableColumn<User, String> M_telLCC;
    @FXML
    private TableColumn<User, String> M_adresseLCC;
    @FXML
    private TableColumn<User, String> M_domaineCC;
    @FXML
    private Button M_rechercheLAA;
    @FXML
    private Button M_supprimLCC;
    @FXML
    private TextField M_mailLCtextfuild;
    @FXML
    private Button imprimer_LC;
    @FXML
    private Button M_logoutLAid;

    void M_rechercheLAAA(ActionEvent event) {

    }
    //////////////
    private Connection on;
    private Statement ste;

    public M_Listclient() {
        on = MyDB.getInstance().getConnection();
    }

    ///////////
    public ObservableList<User> getClientList() {
        ObservableList<User> userList = FXCollections.observableArrayList();

        String query = "SELECT * FROM utilisateur where role = 'sociéte' || role = 'candidat'";
        Statement st;
        ResultSet rs;
        try {
            st = on.createStatement();
            rs = st.executeQuery(query);
            User user;
            while (rs.next()) {
                user = new Candidat(rs.getString("nom"), rs.getString("prenom"), rs.getString("tel"), rs.getString("email"), rs.getString("adresse"), rs.getString("domaine"), rs.getString("role"));
                userList.add(user);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return userList;
    }

    public void showUser() {
        ObservableList<User> list = getClientList();
        M_nomLCC.setCellValueFactory(new PropertyValueFactory<User, String>("domaine"));
        M_roleLCC.setCellValueFactory(new PropertyValueFactory<User, String>("adresse"));
        M_preLCC.setCellValueFactory(new PropertyValueFactory<User, String>("nom"));

        M_emailLCC.setCellValueFactory(new PropertyValueFactory<User, String>("role"));
        M_telLCC.setCellValueFactory(new PropertyValueFactory<User, String>("prenom"));
        M_adresseLCC.setCellValueFactory(new PropertyValueFactory<User, String>("tel"));
        M_domaineCC.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        M_tableLC.setItems(list);

    }

    @FXML
    void M_listclientLS(ActionEvent event) {
        /*
        try {
    
                        Parent root = FXMLLoader.load(getClass().getResource("M_ListAdmin.fxml"));
                        
        Scene stage=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
         */
        try {

            Parent root = FXMLLoader.load(getClass().getResource("M_ListAdmin.fxml"));

            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void executeQuery(String query) {
        Statement st;
        try {
            st = on.createStatement();
            st.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void deleteButton() {

        String query = "DELETE FROM utilisateur WHERE email ='" + M_mailLCtextfuild.getText() + "'";
        executeQuery(query);
        showUser();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showUser();
        M_rechercheL();
    }

    @FXML
    private void M_supprimLCC(ActionEvent event) {
        deleteButton();
    }
    int index = -1;

    @FXML
    private void getSelected(MouseEvent event) {
        index = M_tableLC.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        M_mailLCtextfuild.setText(M_emailLCC.getCellData(index).toString());

    }

    void M_rechercheL() {
        ObservableList<User> list = getClientList();

        showUser();

        FilteredList<User> filteredData = new FilteredList<>(list, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        M_id.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(user -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (user.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter prenom.
                } else if (user.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter nom.
                } else if (String.valueOf(user.getEmail()).indexOf(lowerCaseFilter) != -1) {
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
        sortedData.comparatorProperty().bind(M_tableLC.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        M_tableLC.setItems(sortedData);

    }

    @FXML
    private void imprimer_LC(ActionEvent event) throws SQLException, BadElementException, IOException {
        Document doc = new Document();

        String query = "Select * from utilisateur";

        Statement st;
        ResultSet rs;

        try {
            st = on.createStatement();
            rs = st.executeQuery(query);

            PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\fnmoh\\Desktop\\client.pdf"));
            doc.open();

            Image img = Image.getInstance("C:\\Users\\fnmoh\\Desktop\\Pdf Emplacement JavaFx\\logo.png");
            img.scaleAbsoluteWidth(100);
            img.scaleAbsoluteHeight(100);
            img.setAlignment(Image.ALIGN_CENTER);

            doc.add(img);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Liste Client"));
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

            cell = new PdfPCell(new Phrase("role", FontFactory.getFont("arial")));
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

                cell = new PdfPCell(new Phrase(rs.getString("role").toString(), FontFactory.getFont("arial")));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);

                table.addCell(cell);
            }

            ////////////////////////         
            doc.add(table);

            doc.close();
            Desktop.getDesktop().open(new File("C:\\Users\\fnmoh\\Desktop\\client.pdf"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(M_Listadmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(M_Listadmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void statiquem(ActionEvent event) {
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
    private void M_logoutLAaction(ActionEvent event) {
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

    @FXML
    private void cours_open(ActionEvent event) throws IOException {
             Parent root = FXMLLoader.load(getClass().getResource("N_Home_Admin.fxml"));
            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
