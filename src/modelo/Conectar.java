/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Myrian Chica
 */
public class Conectar {
    Connection con=null;
    
    public Connection conexion(){
        try {
            //cargar driver
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/dbparqueadero","root","");
         //   System.out.println("conexion establecida");
           // JOptionPane.showMessageDialog(null,"conexion establecida");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error de conexion");
            JOptionPane.showMessageDialog(null, "error de conexion"+e);
        }
        return con;
    }
}
