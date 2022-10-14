/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.model;

/**
 *
 * @author tecin
 */
public class Telefone {

    private long numero;

    public Telefone(long numero) {
        this.numero = numero;
    }
    
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }
}
