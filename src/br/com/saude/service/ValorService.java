/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.service;

/**
 *
 * @author tecin
 */
public class ValorService {
    
    public static String verificarValor(String valor, String valorAntigo){
        if(!valor.isEmpty()){
            return valor;
        }
        return valorAntigo;
    }
}
