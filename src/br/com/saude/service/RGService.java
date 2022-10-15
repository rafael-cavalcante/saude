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

    public static long validar(String rg) {
        try {
            if (!rg.contains(" ")) {
                rg = rg.replace(".", "");

                return Long.parseLong(rg);
            }
        } catch (NumberFormatException numberFormatException) {
            System.out.println(Cor.AZUL.getCor() + "RG INVÁLIDA!");
        }
        return 0;
    }

    public static String formatar(long rg) {
        return String.format("%09d", rg);
    }
}
