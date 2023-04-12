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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.bilan;
import model.facture;
import model.service;
import service.Bilanservice;
import service.serviceservice;
import static view.FactureController.isAlpha;
import static view.FactureController.isNumeric;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class ServiceController implements Initializable {

    @FXML
    private TableColumn<service, Integer> ids;
    @FXML
    private TableColumn<service, String> noms;
    @FXML
    private TableColumn<service, String> types;
    @FXML
    private TableView<service> tableservice;
    @FXML
    private TextField Ids;
    @FXML
    private TextField names;
    @FXML
    private TextField typeser;

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
    {   serviceservice  ls= new serviceservice();
     ObservableList<service> list=ls.getlivraisonList(); 
 
     ids.setCellValueFactory(new PropertyValueFactory<service,Integer>("id"));
  noms.setCellValueFactory(new PropertyValueFactory<service,String>("nom_service"));
   types.setCellValueFactory(new PropertyValueFactory<service,String>("type_service"));
    

   tableservice.setItems(list);
     
        
    }
     public void setCellValue(){
    
    tableservice.setOnMouseClicked(new EventHandler<MouseEvent>(){
    public void handle(MouseEvent event)
    { 
       
        service p1=tableservice.getItems().get(tableservice.getSelectionModel().getSelectedIndex());
     //   datefact.setValue(String.valueOf(p1.getDate_facture()));
              Ids.setText(String.valueOf(p1.getId()));
     //date_livraison.setValue(p1.getDateLivraison()); 
           names.setText(String.valueOf(p1.getNom_service()));
               typeser.setText(String.valueOf(p1.getType_service()));
                  
                      
    }
});
}
    
      @FXML 
    private void AddService(ActionEvent event) throws Exception { 
                serviceservice  ls= new serviceservice();
         
            
     
        
            service l =new service();

if (((isAlpha(names.getText()))&& (names.getText().length() != 0) ) && ((isAlpha(typeser.getText()))&& (typeser.getText().length() != 0)) )
                 {
       
          l.setNom_service(names.getText());
  
          l.setType_service(typeser.getText());
         

            try {
                ls.Add(l) ;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("service is added successfully!");
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
    
    @FXML
 private void UpdateService(ActionEvent event){
            serviceservice  ls= new serviceservice();
                       
        
            service l =new service();
           
       int id=Integer.parseInt(Ids.getText());
          l.setNom_service(names.getText());
  
          l.setType_service(typeser.getText());   
           
          

            try {
               ls.Update(id,names.getText(),typeser.getText()) ;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("service is updated successfully!");
            alert.show();
      
            showLivraison();
        }
 
   catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
             } 
    @FXML
 private void DeleteService(ActionEvent event) {
            serviceservice  cs= new serviceservice();
                                       
           
        
            service c =new service();
           
            int id=Integer.parseInt(Ids.getText()) ; 
               
           
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
