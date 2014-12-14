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
public class TipoVehiculo {
    String id;
    String nombre;
    Parqueadero id_parqueadero;

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

    public Parqueadero getId_parqueadero() {
        return id_parqueadero;
    }

    public void setId_parqueadero(Parqueadero id_parqueadero) {
        this.id_parqueadero = id_parqueadero;
    }
    
    
}
