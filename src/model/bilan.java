/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author pc
 */
public class bilan {
    
       private int id;
      private Date date_debut;
      private Date date_fin;
      private int charge ;
      private int vente_id;

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

    /**
     * @return the charge
     */
    public int getCharge() {
        return charge;
    }

    /**
     * @param charge the charge to set
     */
    public void setCharge(int charge) {
        this.charge = charge;
    }

    /**
     * @return the vente_id
     */
    public int getVente_id() {
        return vente_id;
    }

    /**
     * @param vente_id the vente_id to set
     */
    public void setVente_id(int vente_id) {
        this.vente_id = vente_id;
    }

    @Override
    public String toString() {
        return "bilan{" + "id=" + id + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", charge=" + charge + ", vente_id=" + vente_id + '}';
    }

    public bilan(int id, Date date_debut, Date date_fin, int charge, int vente_id) {
        this.id = id;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.charge = charge;
        this.vente_id = vente_id;
    }

    public bilan() {
    }

    public bilan(Date date_debut, Date date_fin, int charge, int vente_id) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.charge = charge;
        this.vente_id = vente_id;
    }
            
}
