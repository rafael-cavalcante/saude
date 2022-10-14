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
public class CRMService {
    
    public static String formatar(String rg) {
        try {
            rg = rg.replace("CRM/", "");
            rg = rg.replace(" ", "");

            return rg;
        } catch (Exception exception) {
            System.out.println(Cor.AZUL.getCor() + exception.getMessage());
            return null;
        }
    }
}
