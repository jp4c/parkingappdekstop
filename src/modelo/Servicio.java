package modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Myrian Chica
 */
public class Servicio {
    String id;
    String nombre;
    float costo;
    TipoVehiculo id_TipoVehiculo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public TipoVehiculo getId_TipoVehiculo() {
        return id_TipoVehiculo;
    }

    public void setId_TipoVehiculo(TipoVehiculo id_TipoVehiculo) {
        this.id_TipoVehiculo = id_TipoVehiculo;
    }
    
    
}
