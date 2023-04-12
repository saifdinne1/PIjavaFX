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
import static jdk.nashorn.internal.objects.Global.getDate;
import model.bilan;
import model.chambre;
import model.interfaceChambre;
import model.interfaceReservation;
import model.reservation;
import model.service;

/**
 *
 * @author pc
 */

    public class reservationservice  implements interfaceReservation <service>{
private Connection conn;
    private PreparedStatement pst;
    private Statement ste;

    public reservationservice () {
        conn = DBconnector.getInstance().getCnx();
    }


    public ObservableList <reservation> getlivraisonList() {
        ObservableList<reservation> Livraisonliste=FXCollections.observableArrayList();
//Connection conn=getConnection(); 
  String req = "SELECT * from `reservation`";
        
        try {
            pst = conn.prepareStatement(req);
            ResultSet rs= pst.executeQuery();
    while(rs.next()){
                
           reservation l = new reservation();
               l.setId(rs.getInt("id"));
               l.setService_id(rs.getInt(2));
               l.setChambre_id(rs.getInt(3));
               l.setDate_debut(rs.getDate(4));
               
               l.setDate_fin(rs.getDate(5));
               
               
              
         
                Livraisonliste.add(l);
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
           
  
     return Livraisonliste ;  
    }
    
    
    
    public void Add(reservation l)  throws SQLException{
      String req = "INSERT INTO `reservation` (`id`, `service_id`, `chambre_id`, `date_debut`, `date_fin`) VALUES ('"+ l.getId()+"','"+l.getService_id()+"','"+l.getChambre_id()+"','"+l.getDate_debut()+"','"+l.getDate_fin()+"')";
        
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("reservation  ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void Update(int Id,Date datedebut, Date datefin, int chambre,int service ) throws SQLException {
       try {    
    String req="UPDATE reservation SET date_debut='"+datedebut+"',date_fin='"+datefin+"',chambre_id='"+chambre+"',service_id='"+service
            +"'WHERE id="+Id;
       
            ste = conn.prepareStatement(req);
            ste.executeUpdate(req);
            System.out.print(req);
            System.out.println("La reservation "+Id+ "est modifier");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

    } }
    
    
           public void Delete(int l ) throws SQLException {
 String req="DELETE FROM reservation WHERE `id`='"+l+"'";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("La facture "+l+ "est supprimer");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());    

    } 
}

    @Override
    public List<reservation> display() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
