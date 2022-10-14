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
    
    public static String formatar(String crm) {
        try {
            crm = crm.replace("CRM/", "");
            crm = crm.replace(" ", "");

            return crm;
        } catch (Exception exception) {
            System.out.println(Cor.AZUL.getCor() + exception.getMessage());
            return null;
        }
    }
}
