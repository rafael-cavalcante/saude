/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.configuracao;

import br.com.saude.controller.ControllerAdministrador;
import br.com.saude.model.Administrador;
import br.com.saude.model.Endereco;
import java.util.ArrayList;

/**
 *
 * @author tecin
 */
public class Configuracao {
        
    public static void iniciar(){
        ControllerAdministrador controllerAdministrador = new ControllerAdministrador();

        Administrador administrador = new Administrador(
                "000.000.000-00", 
                "saude+", 
                "Saude+", 
                new Endereco(
                        "Projeto saude",
                        0,
                        "Ufersa Saude"
                ), 
                new ArrayList<>()
        );
        
        controllerAdministrador.cadastrar(administrador);
        
        System.out.println("ADMINISTRADOR CADASTRADO!");
    }
}
