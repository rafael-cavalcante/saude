/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.service;

import javax.mail.MessagingException;

/**
 *
 * @author tecin
 */
public class TestaEmail {

    public static void main(String[] args) {
        try {
            GoogleMail.Send("santos852.rafael",
                    "axxswhufmikklznf",
                    "santos852.rafael",
                    "Teste email java",
                    "Enviando primeiro email por java");
        } catch (MessagingException e) {
            System.out.println(e.getMessage());
        }
    }
}
