package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
 * 
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
    boolean sesion;

    public Usuario() {

    }

    public Usuario(String nombre, String apellido, int telefono, String role, String password, int cedula, String email, int idParqueadero) {
        this.sesion = false;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.role = role;
        this.password = password;
        this.cedula = cedula;
        this.email = email;
        this.idParqueadero = idParqueadero;
    }

   
public void AbrirSesion(String email){
     try {
                // create the java mysql update preparedstatement
                Conectar con = new Conectar();
                Connection reg = con.conexion();    
                String query = "update usuario set sesion = ? where email = ?"; 
                PreparedStatement preparedStmt = reg.prepareStatement(query);
                preparedStmt.setBoolean(1, true);
                preparedStmt.setString(2, email);

                // execute the java preparedstatement
                preparedStmt.executeUpdate();
                System.out.println("Sesion Abierta");
                reg.close();
              } catch (Exception e) {
              System.out.println(""+ e);  
              }
}
 public void CerrarSesion(String email) {
        try {
                // create the java mysql update preparedstatement
                Conectar con = new Conectar();
                Connection reg = con.conexion();    
                String query = "update usuario set sesion = ? where email = ?"; 
                PreparedStatement preparedStmt = reg.prepareStatement(query);
                preparedStmt.setBoolean(1, false);
                preparedStmt.setString(2, email);

                // execute the java preparedstatement
                preparedStmt.executeUpdate();
                System.out.println("Sesion Cerrada");
                reg.close();
              } catch (Exception e) {
              System.out.println(""+ e);  
              }
    }
    public boolean LoginUsuario(String email, String password) {
       
        try {
            Conectar con = new Conectar();
            Connection reg = con.conexion();
            Statement st = reg.createStatement();
            //ResultSet rs = st.executeQuery("select * from usuario where email like .com");
            ResultSet rs = st.executeQuery("select * from usuario where email ='" + email + "' && contraseña = '" + password + "'");
            while (rs.next()) {
                System.out.println("LOGUEADO Y USUARIO OBTENIDO");
       
                //OBTENIENDO USUARIO DE LA BD
                nombre=rs.getString("nombre");
                apellido=rs.getString("apellido");
                cedula=rs.getInt("cedula");
                this.email=rs.getString("email");
                telefono=rs.getInt("telefono");
                idParqueadero=rs.getInt("parqueadero_idparqueadero");
                role=rs.getString("role");
                this.password=rs.getString("contraseña");
                sesion=rs.getBoolean("sesion");
                
                
                return true;
            }
            
            rs.close();
            st.close();
            reg.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public void insertarUsuario(int idParqueadero) {
        
        this.idParqueadero = idParqueadero;
        Conectar con = new Conectar();
        Connection reg = con.conexion();
        String sql;
        sql = "INSERT INTO `usuario`( `nombre`, `apellido`, `cedula`, `telefono`, `role`, `email`, `contraseña`, `sesion`,`parqueadero_idparqueadero`) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = reg.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setInt(3, cedula);
            pst.setInt(4, telefono);
            pst.setString(5, role);
            pst.setString(6, email);
            pst.setString(7, password);
            pst.setBoolean(8, sesion);
            pst.setInt(9, this.idParqueadero);
            int n = pst.executeUpdate();

            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Registrado con exito ");
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
        try {
            Conectar con = new Conectar();
            Connection reg = con.conexion();
            Statement st = reg.createStatement();
            //ResultSet rs = st.executeQuery("select * from usuario where email like .com");
            ResultSet rs = st.executeQuery("select * from usuario where email ='" + email + "' && contraseña = '" + password + "'");
            while (rs.next()) {
                
       
                //OBTENIENDO IDUSUARIO DE LA BD
                id=rs.getInt("idusuario");
                System.out.println("idusuario obtenido");
                
            }
            
            rs.close();
            st.close();
            reg.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

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
