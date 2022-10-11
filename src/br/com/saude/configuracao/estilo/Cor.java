/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.configuracao.estilo;

/**
 *
 * @author Rafael Cavalcante
 */
public enum Cor {
    AMARELO ("\u001B[33m"),
    VERDE   ("\u001B[32m"),
    VERMELHO("\u001B[31m"),
    ROXO    ("\u001B[35m");

    private final String cor;

    Cor(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return this.cor;
    }
}
