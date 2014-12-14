/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vistas.Formulario_Login;

/**
 *
 * @author JP
 */
public class ParkingApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Usuario superAdmin = new Usuario("Ivan", "Martinez", 890000, "SuperAdmin", "SA123456", 000, "vanmartc.com", 0);
        Usuario superAdmin1 = new Usuario("Juan Pablo", "Aguirre", 890000, "SuperAdmin", "SA123456", 000, "jpac.com", 0);

        Formulario_Login formularioLogin = new Formulario_Login();
        formularioLogin.setVisible(true);
        formularioLogin.EnviarUsuarios(superAdmin, superAdmin1);

    }

}
