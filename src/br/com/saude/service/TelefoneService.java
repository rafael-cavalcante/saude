/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.service;

/**
 *
 * @author tecin
 */
public class TelefoneService {

    public static long validar(String numero) throws Exception {
        if (!numero.contains(" ")) {
            numero = numero.replace("(", "");
            numero = numero.replace(")", "");
            numero = numero.replace(" ", "");
            numero = numero.replace("-", "");

            return Long.parseLong(numero);
        }
        throw  new Exception("NÚMERO DE TELEFONE INVÁLIDO");
    }
}
