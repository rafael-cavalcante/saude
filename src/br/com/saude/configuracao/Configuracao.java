/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.configuracao;

import br.com.saude.controller.ControllerAdministrador;
import br.com.saude.model.Administrador;
import java.util.ArrayList;

/**
 *
 * @author tecin
 */
public class Configuracao {

    public static void iniciar() {
        ControllerAdministrador controllerAdministrador = new ControllerAdministrador();

        Administrador administrador = new Administrador(
                0,
                "saude+",
                "Saude+",
                "Projeto saude",
                0,
                "Ufersa Saude",
                new ArrayList<>()
        );

        controllerAdministrador.cadastrar(administrador);

        System.out.println("CONFIGURAÇÕES INICIADAS!");
    }
}
