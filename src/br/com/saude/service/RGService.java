/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.service;

import br.com.saude.configuracao.estilo.Estilo;

/**
 *
 * @author tecin
 */
public class RGService {

    public static long converterLong(String rg) {
        try {
            if (!rg.equals("   .   .   ")) {
                rg = rg.replace(".", "");

                return Long.parseLong(rg);
            }
        } catch (NumberFormatException numberFormatException) {
            System.out.println(Estilo.AZUL.getCor() + "RG INVÁLIDA!");
        }
        return 0;
    }

    public static long converterLong(String rg, long rgAntigo) {
        try {
            if (!rg.equals("   .   .   ")) {
                rg = rg.replace(".", "");

                return Long.parseLong(rg);
            }
        } catch (NumberFormatException numberFormatException) {
            System.out.println(Estilo.AZUL.getCor() + "RG INVÁLIDA!");
        }
        return rgAntigo;
    }

    public static String formatar(long rg) {
        return String.format("%09d", rg);
    }
}
