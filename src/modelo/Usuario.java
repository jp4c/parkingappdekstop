package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vistas.Formulario_RegistroParqueadero;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Myrian Chica
 */
public class Usuario {
    int id;
    String nombre;
    String apellido;
    int telefono;
    String role;
    String password;
    int cedula;
    String email;
    int idParqueadero;
   
    public Usuario() {
       
    }

    public Usuario(String nombre, String apellido, int telefono, String role, String password, int cedula, String email, int idParqueadero) {
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.role = role;
        this.password = password;
        this.cedula = cedula;
        this.email = email;
        this.idParqueadero = idParqueadero;
    }

  
public void RecibirIdParquedero(int idParqueadero){
    this.idParqueadero=idParqueadero;
}


public void insertarUsuario() {
        Conectar con = new Conectar();
        Connection reg = con.conexion();
        String sql;
        sql = "INSERT INTO `usuario`( `nombre`, `apellido`, `cedula`, `telefono`, `role`, `email`, `contraseña`, `parqueadero_idparqueadero`) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = reg.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setInt(3, cedula);
            pst.setInt(4, telefono);
            pst.setString(5, role);
            pst.setString(6, email);
            pst.setString(7, password);
            pst.setInt(8, idParqueadero);
            int n = pst.executeUpdate();
          
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Registrado con exito BITCH");
            }
            pst.close();
            reg.close();
        } catch (SQLException ex) {
            Logger.getLogger(Formulario_RegistroParqueadero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

   

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getIdParqueadero() {
        return idParqueadero;
    }

    public void setIdParqueadero(int idParqueadero) {
        this.idParqueadero = idParqueadero;
    }

    
    
}
