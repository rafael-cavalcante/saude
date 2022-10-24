/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.service;

/**
 *
 * @author tecin
 */
public class CRMService {

    public static String validar(String crm) throws Exception {
        if (!crm.equals("CRM/        ")) {
            crm = crm.replace("CRM/", "");

            return crm;
        } else {
            throw new Exception("CRM INVÁLIDO!");
        }
    }

    public static String formatar(String crm) {
        return "CRM/" + crm;
    }
}
