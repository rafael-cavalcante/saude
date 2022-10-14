/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.model;

import java.util.List;

/**
 *
 * @author tecin
 */
public class Administrador extends Pessoa {

    public Administrador() {

    }

    public Administrador(long cpf) {
        super(cpf);
    }

    public Administrador(long cpf, String senha) {
        super(cpf, senha);
    }

    public Administrador(long cpf, String senha, String nome, String rua, long numero, String bairro, List<Telefone> telefones) {
        super(cpf, senha, nome, rua, numero, bairro, telefones);
    }
}
