/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.service;

import br.com.saude.configuracao.estilo.Cor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
 *
 * @author tecin
 */
public class DataService {

    public static boolean validar(String data) {
        try {
            LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy").withResolverStyle(ResolverStyle.STRICT));

            return true;
        } catch (DateTimeParseException dateTimeParseException) {
            System.out.println(Cor.AZUL.getCor() + dateTimeParseException.getMessage());
            return false;
        }
    }

    public static String formatar(String data) {
        try {
            data = data.replace("/", "");

            return data;
        } catch (Exception exception) {
            System.out.println(Cor.AZUL.getCor() + exception.getMessage());
            return null;
        }
    }
}
