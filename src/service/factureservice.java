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
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.facture;
import model.interfaceFacture;

/**
 *
 * @author pc
 */
public class factureservice implements interfaceFacture <facture>{
    private Connection conn;
    private PreparedStatement pst;
    private Statement ste;

    public factureservice() {
        conn = DBconnector.getInstance().getCnx();
    }

    @Override
    public List<facture> display() throws SQLException {
          List<facture> ListAr = new ArrayList<>();

        String req = "SELECT * FROM `facture`";

        try {
            pst = conn.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
               facture l = new facture();
                l.setId(rs.getInt("id"));
                l.setDate_facture(rs.getDate(2));
                l.setDesignation(rs.getString(3));
                l.setPrix_designation(rs.getFloat(4));
                l.setMontant(rs.getFloat(5));
                l.setPatient_id(rs.getInt(6));
                l.setNumero_facture(rs.getString(7));
                ListAr.add(l);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return ListAr;
    }
public ObservableList<facture> getlivraisonList() 

{
    ObservableList<facture> Livraisonliste=FXCollections.observableArrayList();
//Connection conn=getConnection(); 
  String req = "SELECT * from `facture`";
        
        try {
            pst = conn.prepareStatement(req);
            ResultSet rs= pst.executeQuery();
    while(rs.next()){
                
           facture l = new facture();
                l.setId(rs.getInt("id"));
                l.setDate_facture(rs.getDate(2));
                l.setDesignation(rs.getString(3));
                l.setPrix_designation(rs.getFloat(4));
                l.setMontant(rs.getFloat(5));
                l.setPatient_id(rs.getInt(6));
                l.setNumero_facture(rs.getString(7));
                Livraisonliste.add(l);
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
           
  
     return Livraisonliste ;  
        }

 public void Add(facture l)  throws SQLException{
      String req = "INSERT INTO `facture` (`id`, `date_facture`, `designation`, `prix_designation`, `montant`, `patient_id`, `numero_facture`) VALUES ('"+ l.getId()+"','"+l.getDate_facture()+"','"+l.getDesignation()+"','"+l.getPrix_designation()+"','"+l.getMontant()+"','"+l.getPatient_id()+"','"+l.getNumero_facture()+"')";
        
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("faccture ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
 
     public void Update(int Id,Date DateFacture, String designation,float prix_des ,float montant,int patId,String numfacture ) throws SQLException {
       try {    
    String req="UPDATE facture SET date_facture='"+DateFacture+"',designation='"+designation+"',prix_designation='"+prix_des+"',montant='"+montant+"',patient_id='"+patId+"',numero_facture='"+numfacture 
            +"'WHERE id="+Id;
       
            ste = conn.prepareStatement(req);
            ste.executeUpdate(req);
            System.out.println("La livraison "+Id+ "est modifier");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

    } } 
     
       public void Delete(int l ) throws SQLException {
 String req="DELETE FROM facture WHERE `id`='"+l+"'";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("La facture "+l+ "est supprimer");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());    

    } 
}
}   
