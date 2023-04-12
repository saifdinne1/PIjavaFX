/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.bilan;
import model.chambre;
import model.reservation;
import service.Bilanservice;
import service.chambreservice;
import service.reservationservice;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class ReservationController implements Initializable {

    @FXML
    private TableColumn<reservation, Integer    > idr;
    @FXML
    private TableColumn<reservation, Integer> servicer;
    @FXML
    private TableColumn<reservation, Integer> chambrer;
    @FXML
    private TableColumn<reservation, Date> ddr;
    @FXML
    private TableColumn<reservation, Date> ddf;
    @FXML
    private TableView<reservation> tablereservation;
    private TextField service;
    private TextField chambre;
    @FXML
    private DatePicker dfr;
    @FXML
    private Button addbilan11;
    @FXML
    private DatePicker dddr;
    @FXML
    private TextField textidr;
    @FXML
    private Button UpdateReservation;
    @FXML
    private TextField txtchambre;
    @FXML
    private TextField txtservice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         showLivraison();
          setCellValue();
    }     
       public void showLivraison()
    {   reservationservice  ls= new reservationservice();
     ObservableList<reservation> list=ls.getlivraisonList(); 
 
     idr.setCellValueFactory(new PropertyValueFactory<reservation,Integer>("id"));
  ddr.setCellValueFactory(new PropertyValueFactory<reservation,Date>("date_debut"));
   ddf.setCellValueFactory(new PropertyValueFactory<reservation,Date>("date_fin"));
    chambrer.setCellValueFactory(new PropertyValueFactory<reservation,Integer>("chambre_id"));
     servicer.setCellValueFactory(new PropertyValueFactory<reservation,Integer>("service_id")); 

   tablereservation.setItems(list);
     
        
    }
       
      public void setCellValue(){
    
    tablereservation.setOnMouseClicked(new EventHandler<MouseEvent>(){
    public void handle(MouseEvent event)
    { 
       
        reservation p1=tablereservation.getItems().get(tablereservation.getSelectionModel().getSelectedIndex()); 
        textidr.setText(String.valueOf(p1.getChambre_id()));
                txtchambre.setText(String.valueOf(p1.getChambre_id()));
                txtservice.setText(String.valueOf(p1.getService_id()));
                      
    }
});
}
    
    @FXML
    private void AddReservation(ActionEvent event) throws Exception { 
                reservationservice  ls= new reservationservice();
         
            
     
        
            reservation l =new reservation();
            
             int id=Integer.parseInt(textidr.getText());
              Date datedebut=Date.valueOf(dddr.getValue()); 
              Date datefin=Date.valueOf(dfr.getValue());  
          
             int c= Integer.parseInt(txtchambre.getText()) ;  
             int s= Integer.parseInt(txtservice.getText()) ;  

          l.setChambre_id(c);
          l.setDate_debut(datedebut);
          l.setDate_debut(datedebut);
          l.setService_id(s);
         

            try {
                  ls.Add(l) ;  
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("reservation is added successfully!");
           
            alert.show();
         
            showLivraison();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
}
    
    @FXML
 private void UpdateReservation(ActionEvent event){
            reservationservice  ls= new reservationservice();
                       
        
            reservation l =new reservation();
           
       int id=Integer.parseInt(textidr.getText());
        int chm=Integer.parseInt(chambre.getText());
        int ser=Integer.parseInt(service.getText());
       Date datedebut=Date.valueOf(dddr.getValue()); 
       Date datefin=Date.valueOf(dfr.getValue()); 
          l.setChambre_id(chm);
          l.setId(id);
          l.setDate_debut(datedebut);
           l.setDate_fin(datefin);
          
          l.setService_id(ser);   
           
           

            try {
               ls.Update(id,datedebut,datefin,chm,ser) ;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("chambre is updated successfully!");
            alert.show();
      
            showLivraison();
        }
 
   catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
             } 
    @FXML
 private void DeleteReservation(ActionEvent event) {
            reservationservice  cs= new reservationservice();
                                       
           
        
            reservation c =new reservation();
           
            int id=Integer.parseInt(textidr.getText()) ; 
               
           
            c.setId(id);
                        

            try 
            {
            cs.Delete(id); 
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("service is deleted successfully!");
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
