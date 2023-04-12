/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import infrastructure.DBconnector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.bilan;
import model.bilaninterface;
import model.interfaceService;
import model.service;

/**
 *
 * @author pc
 */

    public class serviceservice  implements interfaceService <service>{
private Connection conn;
    private PreparedStatement pst;
    private Statement ste;

    public serviceservice() {
        conn = DBconnector.getInstance().getCnx();
    }


    public ObservableList<service> getlivraisonList() {
        ObservableList<service> Livraisonliste=FXCollections.observableArrayList();
//Connection conn=getConnection(); 
  String req = "SELECT * from `service`";
        
        try {
            pst = conn.prepareStatement(req);
            ResultSet rs= pst.executeQuery();
    while(rs.next()){
                
           service l = new service();
                l.setId(rs.getInt("id"));
                l.setNom_service(rs.getString(2));
                l.setType_service(rs.getString(3));
              
         
                Livraisonliste.add(l);
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
           
  
     return Livraisonliste ;  
    }

    @Override
    public List<service> display() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Add(service l)  throws SQLException{
      String req = "INSERT INTO `service` (`id`, `nom_service`, `type_service`)  VALUES  ('"+ l.getId()+"','"+l.getNom_service()+"','"+l.getType_service()+"')";
        
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("service  ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void Update(int Id,String nomservice, String typeservice ) throws SQLException {
       try {    
    String req="UPDATE service SET nom_service='"+nomservice+"',type_service='"+typeservice
            +"'WHERE id="+Id;
       
            ste = conn.prepareStatement(req);
            ste.executeUpdate(req);
            System.out.println("La service "+Id+ "est modifier");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

    } }
    
    
           public void Delete(int l ) throws SQLException {
 String req="DELETE FROM service WHERE `id`='"+l+"'";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("La service "+l+ "est supprimer");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());    

    } 
}
}