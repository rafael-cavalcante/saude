/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.configuracao.estilo;

/**
 *
 * @author Rafael Cavalcante
 */
public enum Estilo {
    PRETO("\u001B[30m"),
    VERMELHO("\u001B[31m"),
    VERDE("\u001B[32m"),
    AMARELO("\u001B[33m"),
    AZUL("\u001B[34m"),
    ROXO("\u001B[35m"),
    CIANO("\u001B[36m"),
    BRANCO("\u001B[37m");

    private final String cor;

    Estilo(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return this.cor;
    }
}
