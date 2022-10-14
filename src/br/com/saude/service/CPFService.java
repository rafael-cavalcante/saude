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
public class CPFService {

    public static long formatar(String cpf) {
        try {
            cpf = cpf.replace(".", "");
            cpf = cpf.replace("-", "");
            
            return Long.parseLong(cpf);
        } catch (NumberFormatException numberFormatException) {
            System.out.println(Cor.AZUL.getCor() + numberFormatException.getMessage());
            return 0;
        }
    }

    public static String formatar(long cpf) {
        try {
            String CPF = String.format("%011d", cpf);
            
            return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "."
                    + CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
        } catch (Exception e) {
            System.out.println(Cor.AZUL.getCor() + e.getMessage());
            return null;
        }
    }
}
