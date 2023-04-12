/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import infrastructure.DBconnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.chambre;
import model.interfaceChambre;
import model.interfaceService;
import model.reservation;
import model.service;

/**
 *
 * @author pc
 */

    public class chambreservice  implements interfaceChambre <service>{
private Connection conn;
    private PreparedStatement pst;
    private Statement ste;

    public chambreservice () {
        conn = DBconnector.getInstance().getCnx();
    }


    public ObservableList <chambre> getlivraisonList() {
        ObservableList<chambre> Livraisonliste=FXCollections.observableArrayList();
//Connection conn=getConnection(); 
  String req = "SELECT * from `chambre`";
        
        try {
            pst = conn.prepareStatement(req);
            ResultSet rs= pst.executeQuery();
    while(rs.next()){
                
           chambre l = new chambre();
                l.setId(rs.getInt("id"));
                l.setNumero_chambre(rs.getInt(2));
                l.setService_affecter_id(rs.getInt(3));
              
         
                Livraisonliste.add(l);
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
           
  
     return Livraisonliste ;  
    }
public void Add(chambre l)  throws SQLException{
      String req = "INSERT INTO `chambre` (`id`, `numero_chambre`, `service_affecter_id`) VALUES  ('"+ l.getId()+"','"+l.getNumero_chambre()+"','"+l.getService_affecter_id()+"')";
        
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("chambre  ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
      public void update(int Id, int numerochambre, int serviceaffecter_id) throws SQLException {
      try {
          String req="UPDATE chambre SET numero_chambre='"+numerochambre+"',service_affecter_id='"+serviceaffecter_id
            +"'WHERE id="+Id;
          
            ste = conn.prepareStatement(req);
            ste.executeUpdate(req);
            System.out.println("La chambre "+Id+ "est modifier");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

    } }
      
      public void Delete(int l ) throws SQLException {
 String req="DELETE FROM chambre WHERE `id`='"+l+"'";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("La chambre "+l+ "est supprimer");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());    

    } 
}

    @Override
    public List<reservation> display() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    }
  

    
