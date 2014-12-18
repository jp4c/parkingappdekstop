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
    TipoVehiculo id_TipoVehiculo;
    int id_usuario;
    int idParqueadero;

    public int getIdParqueadero() {
        return idParqueadero;
    }

    public void setIdParqueadero(int idParqueadero) {
        this.idParqueadero = idParqueadero;
    }
    float valor;

    public Ticket( Date fecha_entrada, Date fecha_salida, String placa, TipoVehiculo id_TipoVehiculo, int id_usuario, float valor, int idParqueadero) {
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.placa = placa;
        this.id_TipoVehiculo = id_TipoVehiculo;
        this.id_usuario = id_usuario;
        this.valor = valor;
        this.idParqueadero = idParqueadero;
    }

   
    public Ticket() {
    }
    
    //CRUD Create Read Update Delete
    public void crear(Ticket t){
        Conectar con = new Conectar();
        Connection reg = con.conexion();
        String sql;
        sql = "INSERT INTO `ticket`( `fecha_entrada`, `fecha_salida`, `placa`, `valor`, `parqueadero_idparqueadero`, `tipo_vehiculo_idtipo_vehiculo`, `usuario_idusuario`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7])";
     try {
            PreparedStatement pst = reg.prepareStatement(sql);
            pst.setDate(1, fecha_entrada);
            pst.setDate(2, fecha_salida);
            pst.setString(3, placa);
            pst.setInt(4, id_TipoVehiculo);
            
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

    public TipoVehiculo getId_TipoVehiculo() {
        return id_TipoVehiculo;
    }

    public void setId_TipoVehiculo(TipoVehiculo id_TipoVehiculo) {
        this.id_TipoVehiculo = id_TipoVehiculo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
}
