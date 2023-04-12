/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
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
import model.chambre;
import model.service;
import service.chambreservice;
import service.serviceservice;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class ChambreController implements Initializable {

    @FXML
    private TableColumn<chambre, Integer> idc;
    @FXML
    private TableColumn<chambre, Integer> numc;
    @FXML
    private TableColumn<chambre, Integer> serc;
    @FXML
    private TableView<chambre> tablechambre;
    @FXML
    private TextField Idc;
    @FXML
    private TextField servicech;
    @FXML
    private TextField numch;

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
    {   chambreservice  ls= new chambreservice();
     ObservableList<chambre> list=ls.getlivraisonList(); 
 
     idc.setCellValueFactory(new PropertyValueFactory<chambre,Integer>("id"));
  numc.setCellValueFactory(new PropertyValueFactory<chambre,Integer>("numero_chambre"));
   serc.setCellValueFactory(new PropertyValueFactory<chambre,Integer>("service_affecter_id"));
    

   tablechambre.setItems(list);
     
        
    }
         public void setCellValue(){
    
    tablechambre.setOnMouseClicked(new EventHandler<MouseEvent>(){
    public void handle(MouseEvent event)
    { 
       
        chambre p1=tablechambre.getItems().get(tablechambre.getSelectionModel().getSelectedIndex());
     //   datefact.setValue(String.valueOf(p1.getDate_facture()));
              Idc.setText(String.valueOf(p1.getId()));
     //date_livraison.setValue(p1.getDateLivraison()); 
           numch.setText(String.valueOf(p1.getNumero_chambre()));
               servicech.setText(String.valueOf(p1.getService_affecter_id()));
                  
                      
    }
});
}
    
      @FXML 
    private void AddChambre(ActionEvent event) throws Exception { 
                chambreservice  ls= new chambreservice();
         
            
     
        
            chambre l =new chambre();
             int n= Integer.parseInt(numch.getText()) ;  
             int s= Integer.parseInt(servicech.getText()) ;  

          l.setNumero_chambre(n);
  
          l.setService_affecter_id(s);
         

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
        }
    
}
    
    @FXML
 private void UpdateChambre(ActionEvent event){
            chambreservice  ls= new chambreservice();
                       
        
            chambre l =new chambre();
           
       int id=Integer.parseInt(Idc.getText());
        int num=Integer.parseInt(numch.getText());
        int ser=Integer.parseInt(servicech.getText());
        l.setId(id);
          l.setNumero_chambre(num);
  
          l.setService_affecter_id(ser);   
           
          

            try {
               ls.update (id,num,ser) ;
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
 private void DeleteChambre(ActionEvent event) {
            chambreservice  cs= new chambreservice();
                                       
           
        
            chambre c =new chambre();
           
            int id=Integer.parseInt(Idc.getText()) ; 
               
           
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
}
