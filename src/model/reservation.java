/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author pc
 */
public class reservation {
      private int id;
      private int chambre_id  ;
      private int service_id;
      private Date date_debut;
      private Date date_fin;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the chambre_id
     */
    public int getChambre_id() {
        return chambre_id;
    }

    /**
     * @param chambre_id the chambre_id to set
     */
    public void setChambre_id(int chambre_id) {
        this.chambre_id = chambre_id;
    }

    /**
     * @return the service_id
     */
    public int getService_id() {
        return service_id;
    }

    /**
     * @param service_id the service_id to set
     */
    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    /**
     * @return the date_debut
     */
    public Date getDate_debut() {
        return date_debut;
    }

    /**
     * @param date_debut the date_debut to set
     */
    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    /**
     * @return the date_fin
     */
    public Date getDate_fin() {
        return date_fin;
    }

    /**
     * @param date_fin the date_fin to set
     */
    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public reservation(int chambre_id, int service_id, Date date_debut, Date date_fin) {
        this.chambre_id = chambre_id;
        this.service_id = service_id;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public reservation(int id, int chambre_id, int service_id, Date date_debut, Date date_fin) {
        this.id = id;
        this.chambre_id = chambre_id;
        this.service_id = service_id;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public reservation() {
    }

    @Override
    public String toString() {
        return "reservation{" + "id=" + id + ", chambre_id=" + chambre_id + ", service_id=" + service_id + ", date_debut=" + date_debut + ", date_fin=" + date_fin + '}';
    }

    public void setdate_debut(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setdate_fin(java.sql.Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
