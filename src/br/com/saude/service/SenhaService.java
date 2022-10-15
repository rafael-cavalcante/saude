/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.service;

/**
 *
 * @author tecin
 */
public class SenhaService {
    
    public static String validar(String senha) throws Exception{
        if(!senha.isEmpty() && senha.length() >= 6){
            return senha;
        } else {
            throw new Exception("SENHA INVÁLIDA!");
        }
    }
}
