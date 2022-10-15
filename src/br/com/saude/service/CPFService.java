/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.service;

/**
 *
 * @author tecin
 */
public class CPFService {

    public static long validar(String cpf) throws Exception {
        if (!cpf.contains(" ")) {
            cpf = cpf.replace(".", "");
            cpf = cpf.replace("-", "");

            return Long.parseLong(cpf);
        } else {
            throw new Exception("CPF INVÁLIDA!");
        }
    }

    public static String formatar(long cpf) {
        return String.format("%011d", cpf);
    }
}
