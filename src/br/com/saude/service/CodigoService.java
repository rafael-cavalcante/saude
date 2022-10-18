/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.service;

/**
 *
 * @author tecin
 */
public class CodigoService {

    public static long validar(String codigo) throws Exception {
        if (!codigo.isEmpty()) {
            return Long.parseLong(codigo);
        }
        throw new Exception("CODIGO INVÁLIDA!");
    }
}
