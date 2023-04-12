/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.Console;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import model.facture;
import service.factureservice; 
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author pc
 */

public class FactureController implements Initializable {

    @FXML
    private TableView<facture> facturetable;
    @FXML
    private TableColumn<facture, Integer> Id;
    @FXML
    private TableColumn<facture, Date> date;
    @FXML
    private TableColumn<facture, String> designation;
    @FXML
    private TableColumn<facture, Float> Prix_designation;
    @FXML
    private TableColumn<facture, Float> montant;
    @FXML
    private DatePicker datefact;
    @FXML
    private TextField prix_des;
    @FXML
    private TextField patientId;
    @FXML
    private Button add;
    @FXML
    private TextField des;
    @FXML
    private TextField numm;
    @FXML
    private TextField mon;
    @FXML
    private TextField idfact;
    @FXML
    private TableColumn<facture, Integer> patient;
    @FXML
    private TableColumn<facture, String> aa;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showLivraison(); 
        setCellValue() ; 
        // TODO
    }    
    
     
    @FXML
    public void showLivraison()
    {   factureservice  ls= new factureservice();
     ObservableList<facture> list=ls.getlivraisonList(); 
 
     Id.setCellValueFactory(new PropertyValueFactory<facture,Integer>("id"));
  date.setCellValueFactory(new PropertyValueFactory<facture,Date>("date_facture"));
   designation.setCellValueFactory(new PropertyValueFactory<facture,String>("designation"));
    Prix_designation.setCellValueFactory(new PropertyValueFactory<facture,Float>("prix_designation"));
     montant.setCellValueFactory(new PropertyValueFactory<facture,Float>("montant")); 
     patient.setCellValueFactory(new PropertyValueFactory<facture,Integer>("patient_id"));
      aa.setCellValueFactory(new PropertyValueFactory<facture,String>("numero_facture"));
   facturetable.setItems(list);
     
        
    }
    @FXML 
    private void Addfacture(ActionEvent event) throws Exception { 
                factureservice  ls= new factureservice();
         
            
     
        
            facture l =new facture();
            if (((isAlpha(des.getText()))&& (des.getText().length() != 0) ) && ((isNumeric(prix_des.getText()))&& (prix_des.getText().length() != 0) )
                && ((isNumeric(mon.getText())))&& ((isNumeric(numm.getText()))&& (numm.getText().length() != 0) )&& ((isNumeric(patientId.getText()) && ((patientId.getText().length()!= 0))))) {
         //int id=Integer.parseInt(id_livr.getText());
          Date date=Date.valueOf(datefact.getValue()); 
           float prix_des = Float.parseFloat(this.prix_des.getText()) ; 
             float montant = Float.parseFloat(mon.getText()) ;
          int pid= Integer.parseInt(patientId.getText()) ;  
       
          
          
          //l.setIdLiv(id);
          l.setDate_facture(date);
  
          l.setDesignation(des.getText());
          l.setPrix_designation(prix_des);
          l.setMontant(montant);
          l.setPatient_id(pid);
          l.setNumero_facture(numm.getText());

            try {
                ls.Add(l) ;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Livraison is added successfully!");
           // EnvoyerMail.sendMail("salim.sghaier@esprit.tn","Vous avez un nouveau client: \n" +"Son identifiant est:");
            alert.show();
         
            showLivraison();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }}
              else{
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Invalid champ!");
            alert.show();
        }
    
    } 
    
public void setCellValue(){
    
    facturetable.setOnMouseClicked(new EventHandler<MouseEvent>(){
    public void handle(MouseEvent event)
    { 
       
        facture p1=facturetable.getItems().get(facturetable.getSelectionModel().getSelectedIndex());
     //   datefact.setValue(String.valueOf(p1.getDate_facture()));
              idfact.setText(String.valueOf(p1.getId()));
     //date_livraison.setValue(p1.getDateLivraison()); 
           des.setText(String.valueOf(p1.getDesignation()));
               prix_des.setText(String.valueOf(p1.getPrix_designation()));
                   mon.setText(String.valueOf(p1.getMontant()));
                       patientId.setText(String.valueOf(p1.getPatient_id()));
                           numm.setText(String.valueOf(p1.getNumero_facture()));
                      
    }
});
}

    @FXML
 private void Updatefacture(ActionEvent event){
            factureservice  ls= new factureservice();
                       
        
            facture l =new facture();
           
       int id=Integer.parseInt(idfact.getText());
              Date date=Date.valueOf(datefact.getValue()); 
           float prix_des = Float.parseFloat(this.prix_des.getText()) ; 
             float montant = Float.parseFloat(mon.getText()) ;
          int pid= Integer.parseInt(patientId.getText()) ;  
       
          
          
          //l.setIdLiv(id);
          l.setDate_facture(date);
  
          l.setDesignation(des.getText());
          l.setPrix_designation(prix_des);
          l.setMontant(montant);
          l.setPatient_id(pid);
          l.setNumero_facture(numm.getText());

            try {
               ls.Update(id,date,des.getText(),prix_des,montant,pid,numm.getText()) ;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("facture is updated successfully!");
            alert.show();
      
            showLivraison();
        }
 
   catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
             } 
 
    @FXML
 private void Deletefacture(ActionEvent event) {
            factureservice  cs= new factureservice();
                                       
           
        
            facture c =new facture();
           
            int id=Integer.parseInt(idfact.getText()) ; 
               
           
            c.setId(id);
                        

            try 
            {
            cs.Delete(id); 
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Commande is deleted successfully!");
            alert.show();
         showLivraison(); 
            
            } 
               catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


 }  
 
 public static boolean isAlpha(String s) {
        return s != null && s.matches("^[a-zA-Z]*$");
    } 
   public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}

