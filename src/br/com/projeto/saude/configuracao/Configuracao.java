/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.saude.configuracao;

import br.com.projeto.saude.controller.ControllerAdministrador;
import br.com.projeto.saude.model.Administrador;
import br.com.projeto.saude.model.Endereco;
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
                        1,
                        "Ufersa Saude"
                ), 
                new ArrayList<>()
        );
        
        controllerAdministrador.cadastrar(administrador);
        
        System.out.println("ADMINISTRADOR CADASTRADO!");
    }
}
