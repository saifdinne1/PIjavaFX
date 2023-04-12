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
import model.facture;
import service.Bilanservice;
import service.factureservice;
import static view.FactureController.isAlpha;
import static view.FactureController.isNumeric;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class BilanController implements Initializable {

    @FXML
    private TableView<bilan> tablebilan;
    @FXML
    private TableColumn<bilan, Integer> id;
    @FXML
    private TableColumn<bilan, Date> datedebut;
    @FXML
    private TableColumn<bilan, Date> datefin;

    @FXML
    private TableColumn<bilan, Integer> venteid;
    
    @FXML
    private TableColumn<bilan, Integer> ch;
    @FXML
    private TextField charge;
    @FXML
    private Button addbilan;
    @FXML
    private DatePicker d1;
    @FXML
    private TextField Idb;
    @FXML
    private DatePicker d2;
    @FXML
    private TextField vid;
    @FXML
    private Button addbilan1;
    @FXML
    private Button addbilan11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showLivraison();
        setCellValue();
        // TODO
    }    
    public void showLivraison()
    {   Bilanservice  ls= new Bilanservice();
     ObservableList<bilan> list=ls.getlivraisonList(); 
 
     id.setCellValueFactory(new PropertyValueFactory<bilan,Integer>("id"));
  datedebut.setCellValueFactory(new PropertyValueFactory<bilan,Date>("date_debut"));
   datefin.setCellValueFactory(new PropertyValueFactory<bilan,Date>("date_fin"));
    ch.setCellValueFactory(new PropertyValueFactory<bilan,Integer>("charge"));
     venteid.setCellValueFactory(new PropertyValueFactory<bilan,Integer>("vente_id")); 

   tablebilan.setItems(list);
     
        
    }
    
    public void setCellValue(){
    
    tablebilan.setOnMouseClicked(new EventHandler<MouseEvent>(){
    public void handle(MouseEvent event)
    { 
       
        bilan p1=tablebilan.getItems().get(tablebilan.getSelectionModel().getSelectedIndex());
     //   datefact.setValue(String.valueOf(p1.getDate_facture()));
              Idb.setText(String.valueOf(p1.getId()));
     //date_livraison.setValue(p1.getDateLivraison()); 
           charge.setText(String.valueOf(p1.getCharge()));
               vid.setText(String.valueOf(p1.getVente_id()));
                  
                      
    }
});
}
    
      @FXML 
    private void AddLivraison(ActionEvent event) throws Exception { 
                Bilanservice  ls= new Bilanservice();
         
            
     
        
            bilan l =new bilan();
if (((isNumeric(vid.getText()))&& (vid.getText().length() != 0) ) && ((isNumeric(charge.getText()))&& (charge.getText().length() != 0) )
             ) {
         //int id=Integer.parseInt(id_livr.getText());
          Date datedebut=Date.valueOf(d1.getValue()); 
           Date datefin=Date.valueOf(d2.getValue()); 
           

          int chrge= Integer.parseInt(charge.getText()) ;  
        int vente= Integer.parseInt(vid.getText()) ; 
          
          
          //l.setIdLiv(id);
          l.setDate_debut(datedebut);
  
          l.setDate_fin(datefin);
          l.setCharge(chrge);
          l.setVente_id(vente);
         

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
        }}else{
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Invalid champ!");
            alert.show();
        }
    
}
    
    @FXML
 private void Updatebilan(ActionEvent event){
            Bilanservice  ls= new Bilanservice();
                       
        
            bilan l =new bilan();
           
       int id=Integer.parseInt(Idb.getText());
              Date datedebut=Date.valueOf(d1.getValue()); 
               Date datefin=Date.valueOf(d2.getValue()); 
           
          int ch= Integer.parseInt(charge.getText()) ;  
       int venteid= Integer.parseInt(vid.getText()) ; 
          
          
          //l.setIdLiv(id);
          l.setDate_debut(datedebut);
  
          l.setDate_fin(datefin);
          l.setCharge(ch);
          l.setVente_id(venteid);
         

            try {
               ls.Update(id,datedebut,datefin,ch,venteid) ;
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
 private void Deletebilan(ActionEvent event) {
            Bilanservice  cs= new Bilanservice();
                                       
           
        
            bilan c =new bilan();
           
            int id=Integer.parseInt(Idb.getText()) ; 
               
           
            c.setId(id);
                        

            try 
            {
            cs.Delete(id); 
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("bilan is deleted successfully!");
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
