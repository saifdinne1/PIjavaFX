/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pc
 */
public class chambre {
     private int id;
      private int numero_chambre;
      private int service_affecter_id;

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
     * @return the numero_chambre
     */
    public int getNumero_chambre() {
        return numero_chambre;
    }

    /**
     * @param numero_chambre the numero_chambre to set
     */
    public void setNumero_chambre(int numero_chambre) {
        this.numero_chambre = numero_chambre;
    }

    /**
     * @return the service_affecter_id
     */
    public int getService_affecter_id() {
        return service_affecter_id;
    }

    /**
     * @param service_affecter_id the service_affecter_id to set
     */
    public void setService_affecter_id(int service_affecter_id) {
        this.service_affecter_id = service_affecter_id;
    }

    @Override
    public String toString() {
        return "chambre{" + "id=" + id + ", numero_chambre=" + numero_chambre + ", service_affecter_id=" + service_affecter_id + '}';
    }

    public chambre(int id, int numero_chambre, int service_affecter_id) {
        this.id = id;
        this.numero_chambre = numero_chambre;
        this.service_affecter_id = service_affecter_id;
    }

    public chambre(int numero_chambre, int service_affecter_id) {
        this.numero_chambre = numero_chambre;
        this.service_affecter_id = service_affecter_id;
    }

    public chambre() {
    }

    
}
