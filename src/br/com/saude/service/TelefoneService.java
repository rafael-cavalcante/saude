/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.service;

import br.com.saude.configuracao.estilo.Cor;

/**
 *
 * @author tecin
 */
public class TelefoneService {
    
    public static long formatar(String numero){
        try {
            numero = numero.replace("(", "");
            numero = numero.replace(")", "");
            numero = numero.replace(" ", "");
            numero = numero.replace("-", "");

            return Long.parseLong(numero);
        } catch (NumberFormatException numberFormatException) {
            System.out.println(Cor.AZUL.getCor() + numberFormatException.getMessage());
            return 0;
        }
    }
}
