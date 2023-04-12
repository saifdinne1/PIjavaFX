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
import model.facture;
import model.interfaceFacture;

/**
 *
 * @author pc
 */
public class Bilanservice  implements bilaninterface <bilan>{
private Connection conn;
    private PreparedStatement pst;
    private Statement ste;

    public Bilanservice() {
        conn = DBconnector.getInstance().getCnx();
    }


    public ObservableList<bilan> getlivraisonList() {
        ObservableList<bilan> Livraisonliste=FXCollections.observableArrayList();
//Connection conn=getConnection(); 
  String req = "SELECT * from `bilan`";
        
        try {
            pst = conn.prepareStatement(req);
            ResultSet rs= pst.executeQuery();
    while(rs.next()){
                
           bilan l = new bilan();
                l.setId(rs.getInt("id"));
                l.setDate_debut(rs.getDate(2));
                l.setDate_fin(rs.getDate(3));
                l.setCharge(rs.getInt(4));
                l.setVente_id(rs.getInt(5));
                System.out.println(l);
             
                Livraisonliste.add(l);
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
           
  
     return Livraisonliste ;  
    }
public void Add(bilan l)  throws SQLException{
      String req = "INSERT INTO `bilan` (`id`, `date_debut`, `date_fin`, `cahrge`, `vente_id`) VALUES  ('"+ l.getId()+"','"+l.getDate_debut()+"','"+l.getDate_fin()+"','"+l.getCharge()+"','"+l.getVente_id()+"')";
        
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("bilan  ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void Update(int Id,Date datedebut, Date datefin,int charge,int venteid ) throws SQLException {
       try {    
    String req="UPDATE bilan SET date_debut='"+datedebut+"',date_fin='"+datefin+"',cahrge='"+charge+"',vente_id='"+venteid
            +"'WHERE id="+Id;
       
            ste = conn.prepareStatement(req);
            ste.executeUpdate(req);
            System.out.println("La facture "+Id+ "est modifier");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

    } }
    
    
           public void Delete(int l ) throws SQLException {
 String req="DELETE FROM bilan WHERE `id`='"+l+"'";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Le bilan "+l+ "est supprimer");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());    

    } 
}
    
}
