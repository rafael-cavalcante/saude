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
public class NumericoService {
    
    public static long converterLong(String numero) {
        try {
            return Long.parseLong(numero);
        } catch (NumberFormatException numberFormatException) {
            System.out.println(Estilo.AZUL.getCor() + "NÚMERO VAZIA OU INVÁLIDA!");
        }
        return 0;
    }

    public static int converterInt(String numero) {
        try {
            return Integer.parseInt(numero);
        } catch (NumberFormatException numberFormatException) {
            System.out.println(Estilo.AZUL.getCor() + "NÚMERO VAZIA OU INVÁLIDA!");
        }
        return 0;
    }
    
    public static double converterDouble(String numero){
        try {
            return Double.parseDouble(numero);
        } catch (NumberFormatException numberFormatException) {
            System.out.println(Estilo.AZUL.getCor() + "NÚMERO VAZIA OU INVÁLIDA!");
        }
        return 0.0;
    }

    public static String formatar(long numero) {
        try {
            return String.valueOf(numero);
        } catch (Exception exception) {
            System.out.println(Estilo.AZUL.getCor() + "NÚMERO VAZIA OU INVÁLIDA!");
        }
        return null;
    }
}
