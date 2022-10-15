/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.service;

import br.com.saude.configuracao.estilo.Cor;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tecin
 */
public class DataService {

    public static LocalDate validar(String data) {
        try {
            if (data != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                simpleDateFormat.setLenient(false);
                simpleDateFormat.parse(data);

                return LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        } catch (ParseException parseException) {
            System.out.println(Cor.AZUL.getCor() + "DATA VAZIA OU INVÁLIDA!");
        }
        return null;
    }

    public static Date converter(LocalDate localDate) {
        if (localDate != null) {
            return Date.valueOf(localDate);
        }
        Date data = null;
        return data;
    }
    
    public static LocalDate converter(Date date) {
        if (date != null) {
            return date.toLocalDate();
        }
        LocalDate localDate = null;
        return localDate;
    }
    

    public static String formatar(LocalDate localDate) {
        if (localDate != null) {
            return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        return null;
    }
}
