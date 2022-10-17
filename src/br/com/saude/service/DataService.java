/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.service;

import br.com.saude.configuracao.estilo.Estilo;
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

    private static final LocalDate localDateErro = null;
    private static final Date dateErro = null;

    public static LocalDate validar(String data) throws Exception {
        if (data != null) {
            return LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } else {
            throw new Exception("DATA INVÁLIDA!");
        }
    }

    public static LocalDate verificar(String data) {
        try {
            if (data != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                simpleDateFormat.setLenient(false);
                simpleDateFormat.parse(data);

                return LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        } catch (ParseException parseException) {
            System.out.println(Estilo.AZUL.getCor() + "DATA VAZIA OU INVÁLIDA!");
        }
        return localDateErro;
    }

    public static Date converter(LocalDate localDate) {
        if (localDate != null) {
            return Date.valueOf(localDate);
        }
        return dateErro;
    }

    public static LocalDate converter(Date date) {
        if (date != null) {
            return date.toLocalDate();
        }
        return localDateErro;
    }

    public static String formatar(LocalDate localDate) {
        if (localDate != null) {
            return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        return null;
    }
}
