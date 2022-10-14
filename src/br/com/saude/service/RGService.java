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
public class RGService {

    public static long formatar(String rg) {
        try {
            rg = rg.replace(".", "");

            return Long.parseLong(rg);
        } catch (NumberFormatException numberFormatException) {
            System.out.println(Cor.AZUL.getCor() + numberFormatException.getMessage());
            return 0;
        }
    }

    public static String formatar(long rg) {
        try {
            String RG = String.valueOf(rg);

            return (RG.substring(0, 3) + "." + RG.substring(3, 6) + "."
                    + RG.substring(6, 9));
        } catch (Exception e) {
            System.out.println(Cor.VERMELHO.getCor() + e.getMessage());
            return null;
        }
    }
}
