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
        if (!crm.contains(" ")) {
            crm = crm.replace("CRM/", "");
            crm = crm.replace(" ", "");

            return crm;
        } else {
            throw new Exception("CRM INVÁLIDA!");
        }
    }
}
