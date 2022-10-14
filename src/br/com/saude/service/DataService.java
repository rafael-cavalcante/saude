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

    public static long formatar(String cpf) {
        try {
            cpf = cpf.replace(".", "");
            cpf = cpf.replace("-", "");

            return Long.parseLong(cpf);
        } catch (NumberFormatException numberFormatException) {
            System.out.println(Cor.AZUL.getCor() + numberFormatException.getMessage());
            return 0;
        }
    }

    public static String formatar(long cpf) {
        try {
            String CPF = String.valueOf(cpf);

            return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "."
                    + CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
        } catch (NumberFormatException numberFormatException) {
            System.out.println(Cor.AZUL.getCor() + numberFormatException.getMessage());
            return null;
        }
    }
}