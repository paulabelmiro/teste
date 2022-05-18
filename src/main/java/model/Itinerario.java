/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Paula Belmiro
 */
public class Itinerario {
    private int idLinha;
    private int id;
    private String lat;
    private String lng;

    public Itinerario(int idLinha, int id, String lat, String lng) {
        this.idLinha = idLinha;
        this.id = id;
        this.lat = lat;
        this.lng = lng;
    }

    public Itinerario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdLinha() {
        return idLinha;
    }

    public void setIdLinha(int idLinha) {
        this.idLinha = idLinha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Itinerario{" + "idLinha=" + idLinha + ", id=" + id + ", lat=" + lat + ", lng=" + lng + '}';
    }
    
    
}
