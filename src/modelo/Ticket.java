package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
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
public class Ticket {
    String id;
    Date fecha_entrada;
    Date fecha_salida;
    String placa;
    int id_tipoVehiculo;
    int id_usuario;
    int id_parqueadero;
    int valor;
    public int getId_parqueadero() {
        return id_parqueadero;
    }

    public void setId_parqueadero(int id_parqueadero) {
        this.id_parqueadero = id_parqueadero;
    }
    

    public Ticket( Date fecha_entrada, Date fecha_salida, String placa, int id_TipoVehiculo, int id_usuario, int valor, int idParqueadero) {
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.placa = placa;
        this.id_tipoVehiculo = id_TipoVehiculo;
        this.id_usuario = id_usuario;
        this.valor = valor;
        this.id_parqueadero = idParqueadero;
    }

   
    public Ticket() {
    }
    
    //CRUD Create Read Update Delete
    public void crear(Ticket t){
        Conectar con = new Conectar();
        Connection reg = con.conexion();
        String sql;
        sql = "INSERT INTO `ticket`( `fecha_entrada`, `fecha_salida`, `placa`, `valor`, `parqueadero_idparqueadero`, `tipo_vehiculo_idtipo_vehiculo`, `usuario_idusuario`) VALUES (?,?,?,?,?,?,?)";
     try {
            PreparedStatement pst = reg.prepareStatement(sql);
            pst.setDate(1, fecha_entrada);
            pst.setDate(2, fecha_salida);
            pst.setString(3, placa);
            pst.setInt(4, valor);
            pst.setInt(5, id_parqueadero);
            pst.setInt(6, id_tipoVehiculo);
            pst.setInt(7, id_usuario);
            
            int n = pst.executeUpdate();

            if (n > 0) {
                JOptionPane.showMessageDialog(null, " Ticket Registrado en BD ");
            }
            pst.close();
            reg.close();
        } catch (SQLException ex) {
            Logger.getLogger(Formulario_RegistroParqueadero.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
     public void leer(int id){
    
    }
    
    public void borrar(int id){
    
    }
    
    public void modificar(int id){
    
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getId_TipoVehiculo() {
        return id_tipoVehiculo;
    }

    public void setId_TipoVehiculo(int id_tipoVehiculo) {
        this.id_tipoVehiculo = id_tipoVehiculo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}
