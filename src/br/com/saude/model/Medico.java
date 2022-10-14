/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.model;

import java.util.List;

/**
 *
 * @author Rafael Cavalcante
 */
public class Medico extends Pessoa {

    private String crm;
    private String especializacao;

    public Medico() {

    }

    public Medico(String crm) {
        this.crm = crm;
    }

    public Medico(String crm, String senha) {
        super(senha);
        this.crm = crm;
    }

    public Medico(long cpf, String senha, String nome, String rua, long numero, String bairro, List<Telefone> telefones, String crm, String especializacao) {
        super(cpf, senha, nome, rua, numero, bairro, telefones);
        this.crm = crm;
        this.especializacao = especializacao;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
}
