/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.service;

import br.com.saude.configuracao.estilo.Cor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tecin
 */
public class DataService {

    public static LocalDate formatar(String data) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            simpleDateFormat.setLenient(false);
            simpleDateFormat.parse(data);
            
            return LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (ParseException exception) {
            System.out.println(Cor.AZUL.getCor() + exception.getMessage());
        }
        return null;
    }

    public static String formatar(LocalDate data) {
        try {
            return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).replace("/", "");
        } catch (Exception exception) {
            System.out.println(Cor.AZUL.getCor() + exception.getMessage());
        }
        return null;
    }
}
