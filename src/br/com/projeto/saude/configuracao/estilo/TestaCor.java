/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.saude.configuracao.estilo;

/**
 *
 * @author tecin
 */
public class TestaCor {

    public static void main(String[] args) {
        System.out.println(Cor.VERDE.getCor() + "Teste");
        for(int i = 0; i < Status.values().length; i++){
            System.out.println(Status.COMFIRMADA.name());
        }
    }
}
